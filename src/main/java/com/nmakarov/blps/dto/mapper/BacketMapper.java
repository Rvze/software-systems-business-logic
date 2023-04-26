package com.nmakarov.blps.dto.mapper;

import com.nmakarov.blps.data.domain.Backet;
import com.nmakarov.blps.data.domain.Product;
import com.nmakarov.blps.data.domain.User;
import com.nmakarov.blps.dto.request.BacketCreateRequest;
import com.nmakarov.blps.dto.response.BacketCreateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BacketMapper {

    @Mapping(target = "user", expression = "java(getUser(request))")
    @Mapping(target = "product", expression = "java(getProduct(request))")
    Backet toEntity(BacketCreateRequest request);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "productId", source = "product.productId")
    @Mapping(target = "cntOfProducts", source = "count")
    @Mapping(target = "productCost", source = "totalCost")
    BacketCreateResponse toResponse(Backet backet);

    default User getUser(BacketCreateRequest request) {
        return User.builder().id(request.getUserId()).build();
    }

    default Product getProduct(BacketCreateRequest request) {
        return Product.builder().productId(request.getProductId()).build();
    }

    default Double getProductCost(Backet backet) {
        if (backet.getProduct() == null)
            return null;
        Product product = backet.getProduct();
        return product.getProductPrice() * product.getCount();
    }
}
