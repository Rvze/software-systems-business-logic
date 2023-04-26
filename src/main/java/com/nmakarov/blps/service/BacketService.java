package com.nmakarov.blps.service;

import com.nmakarov.blps.data.domain.Backet;
import com.nmakarov.blps.data.domain.Product;
import com.nmakarov.blps.data.domain.User;
import com.nmakarov.blps.data.repository.BacketRepository;
import com.nmakarov.blps.data.repository.ProductRepository;
import com.nmakarov.blps.data.repository.UserRepository;
import com.nmakarov.blps.dto.mapper.BacketMapper;
import com.nmakarov.blps.dto.request.BacketCreateRequest;
import com.nmakarov.blps.dto.response.BacketCreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BacketService {
    private final BacketRepository repository;
    private final BacketMapper mapper;
    private final ResourceService res;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Transactional
    public BacketCreateResponse addProductToBucket(BacketCreateRequest request) {
        User user = userRepository.findById(request.getUserId()).get();
        var backets = repository.findAllByUser(user);
        Double wholePrice = backets.stream().mapToDouble(Backet::getTotalCost).sum();
        Backet backet = mapper.toEntity(request);
        Product product = productRepository.findById(request.getProductId()).get();
        backet.setTotalCost(product.getProductPrice() * request.getCount());
        backet.setProduct(product);

        repository.save(backet);

        BacketCreateResponse response = mapper.toResponse(backet);
        response.setTotalCost(wholePrice + backet.getTotalCost());
        return response;
    }

}
