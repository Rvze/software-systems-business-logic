package com.nmakarov.blps.dto.mapper;

import com.nmakarov.blps.data.domain.PaymentMethod;
import com.nmakarov.blps.data.domain.ProductOrder;
import com.nmakarov.blps.data.domain.Status;
import com.nmakarov.blps.dto.request.OrderUpdateRequest;
import com.nmakarov.blps.dto.response.OrderCreateResponse;
import com.nmakarov.blps.dto.response.OrderCreateResponseAscendingByDate;
import com.nmakarov.blps.dto.response.ProductCreateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "deliveryDate", source = "deliveryDate")
    @Mapping(target = "totalCost", source = "totalCost")
    @Mapping(target = "cntOfProducts", source = "count")
    OrderCreateResponseAscendingByDate toFind(ProductOrder productOrder);

    @Mapping(target = "id", source = "productOrder.id")
    @Mapping(target = "product", expression = "java(getProducts(product))")
    @Mapping(target = "cntOfProducts", expression = "java(getCountOrProducts(product))")
    OrderCreateResponse toCreate(ProductOrder productOrder, List<ProductCreateResponse> product);

    @Mapping(target = "paymentMethod", expression = "java(getPaymentMethod(request))")
    @Mapping(target = "deliveryDate", source = "deliveryDate")
    @Mapping(target = "status", expression = "java(getStatus(request))")
    void update(@MappingTarget ProductOrder productOrder, OrderUpdateRequest request);

    default PaymentMethod getPaymentMethod(OrderUpdateRequest request) {
        return PaymentMethod.numOf(request.getPaymentMethod());
    }

    default Integer getCountOrProducts(List<ProductCreateResponse> product) {
        return product.size();
    }

    default Status getStatus(OrderUpdateRequest request) {
        if (request.getStatus() == null)
            return null;
        return Status.valueOf(request.getStatus());
    }

    default List<ProductCreateResponse> getProducts(List<ProductCreateResponse> product) {
        return product;
    }
}
