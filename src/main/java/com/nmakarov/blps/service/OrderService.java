package com.nmakarov.blps.service;

import com.nmakarov.blps.data.domain.*;
import com.nmakarov.blps.data.repository.BacketRepository;
import com.nmakarov.blps.data.repository.OrderRepository;
import com.nmakarov.blps.data.repository.UserRepository;
import com.nmakarov.blps.dto.mapper.OrderMapper;
import com.nmakarov.blps.dto.mapper.ProductMapper;
import com.nmakarov.blps.dto.request.OrderCreateRequest;
import com.nmakarov.blps.dto.response.OrderCreateResponse;
import com.nmakarov.blps.dto.response.OrderCreateResponseAscendingByDate;
import com.nmakarov.blps.dto.response.ProductCreateResponse;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.nmakarov.blps.utils.ErrorMessages.BACKET_DOES_NOT_EXIST;
import static com.nmakarov.blps.utils.ExceptionsUtils.badRequest;
import static com.nmakarov.blps.utils.ServiceUtils.defaultSortDesc;
import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final ResourceService res;
    private final BacketRepository backetRepository;
    private final UserRepository userRepository;
    private final ProductMapper productMapper;

    @Transactional
    public OrderCreateResponse createOrder(OrderCreateRequest request) {
        User user = userRepository.findById(request.getUserId()).get();
        List<Backet> backets = backetRepository.findAllByUser(user);
        if (backets.isEmpty()) {
            throw badRequest(res.localize(BACKET_DOES_NOT_EXIST));
        }

        ProductOrder productOrder = ProductOrder.builder().user(user).creationDate(LocalDateTime.now())
                .paymentMethod(PaymentMethod.numOf(request.getPaymentMethod()))
                .deliveryDate(LocalDate.of(2023, 5, 10))
                .status(Status.WAIT)
                .totalCost(backets.stream()
                        .map(Backet::getProduct)
                        .map(Product::getProductPrice)
                        .mapToDouble(Double::doubleValue).sum())
                .build();
        List<ProductCreateResponse> productCreateResponses =
                backets.stream().map(Backet::getProduct)
                        .map(productMapper::toCreate).collect(Collectors.toList());
        OrderCreateResponse orderCreateResponse = mapper.toCreate(repository.save(productOrder), productCreateResponses);
        backets.forEach(b -> b.setProductOrder(productOrder));
        backetRepository.saveAll(backets);
        return orderCreateResponse;
    }

    public Page<OrderCreateResponseAscendingByDate> findAll(Long userId, Pageable pageable) {
        BooleanBuilder bb = new BooleanBuilder();
        QProductOrder q = QProductOrder.productOrder;
        ofNullable(userId).map(q.user.id::eq).ifPresent(bb::and);
        return repository.findAll(bb, defaultSortDesc(pageable, "creationDate"))
                .map(mapper::toFind);
    }


}
