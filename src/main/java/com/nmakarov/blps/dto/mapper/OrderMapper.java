package com.nmakarov.blps.dto.mapper;

import com.nmakarov.blps.data.domain.Order;
import com.nmakarov.blps.data.domain.Product;
import com.nmakarov.blps.dto.response.OrderCreateResponse;
import com.nmakarov.blps.dto.response.OrderCreateResponseAscendingByDate;
import com.nmakarov.blps.dto.response.ProductCreateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "deliveryDate", source = "deliveryDate")
    //TODO
//    @Mapping(target = "cntOfProducts", source = "")
    @Mapping(target = "totalCost", source = "totalCost")
    OrderCreateResponseAscendingByDate toFind(Order order);

    @Mapping(target = "id", source = "order.id")
    @Mapping(target = "product", expression = "java(getProducts(product))")
    OrderCreateResponse toCreate(Order order, List<ProductCreateResponse> product);

    default List<ProductCreateResponse> getProducts(List<ProductCreateResponse> product) {
        return product;
    }
}
