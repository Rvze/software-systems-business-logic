package com.nmakarov.blps.service;

import com.nmakarov.blps.data.domain.Product;
import com.nmakarov.blps.data.domain.QProduct;
import com.nmakarov.blps.data.repository.ProductRepository;
import com.nmakarov.blps.dto.mapper.ProductMapper;
import com.nmakarov.blps.dto.request.ProductCreateRequest;
import com.nmakarov.blps.dto.request.ProductFindRequest;
import com.nmakarov.blps.dto.response.ProductCreateResponse;
import com.nmakarov.blps.dto.response.ProductFindResponse;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.nmakarov.blps.utils.ErrorMessages.PRODUCT_CHARACTERISTIC_ALREADY_EXIST;
import static com.nmakarov.blps.utils.ErrorMessages.PRODUCT_NOT_FOUND;
import static com.nmakarov.blps.utils.ExceptionsUtils.*;
import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    private final ResourceService res;
    private final ProductMapper mapper;

    @Transactional
    public ProductCreateResponse createProduct(ProductCreateRequest request) {
        validateProductCreate(request);
        Product product = mapper.toEntity(request);
        return mapper.toCreate(repository.save(product));
    }

    @Transactional
    public void deleteProduct(Long id) {
        repository.delete(repository.findById(id).orElseThrow(() -> notFound(res.localize(PRODUCT_NOT_FOUND, id))));
    }

    public Page<ProductFindResponse> findProduct(ProductFindRequest request, Pageable pageable) {
        BooleanBuilder bb = new BooleanBuilder();
        QProduct q = QProduct.product;
        ofNullable(request.getId()).map(q.productId::eq).ifPresent(bb::and);
        ofNullable(request.getProductName()).map(q.productName::containsIgnoreCase).ifPresent(bb::and);
        ofNullable(request.getProductPrice()).map(q.productPrice::eq).ifPresent(bb::and);
        ofNullable(request.getCountry()).map(q.characteristic.country::eq).ifPresent(bb::and);
        ofNullable(request.getWeight()).map(q.characteristic.weight::eq).ifPresent(bb::and);
        ofNullable(request.getHeight()).map(q.characteristic.height::eq).ifPresent(bb::and);
        ofNullable(request.getLength()).map(q.characteristic.length::eq).ifPresent(bb::and);
        ofNullable(request.getWidth()).map(q.characteristic.width::eq).ifPresent(bb::and);
        ofNullable(request.getStructure()).map(q.characteristic.structure::containsIgnoreCase).ifPresent(bb::and);
        return repository.findAll(bb, pageable).map(mapper::toFind);
    }


    private void validateProductCreate(ProductCreateRequest request) {
        ifThrow(repository.existsProductByCharacteristicId(request.getCharacteristicId()),
                () -> badRequest(res.localize(PRODUCT_CHARACTERISTIC_ALREADY_EXIST)));
    }
}
