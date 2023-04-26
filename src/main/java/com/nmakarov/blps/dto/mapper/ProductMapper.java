package com.nmakarov.blps.dto.mapper;

import com.nmakarov.blps.data.domain.Category;
import com.nmakarov.blps.data.domain.Characteristic;
import com.nmakarov.blps.data.domain.Product;
import com.nmakarov.blps.data.domain.Trademark;
import com.nmakarov.blps.dto.request.ProductCreateRequest;
import com.nmakarov.blps.dto.response.ProductCreateResponse;
import com.nmakarov.blps.dto.response.ProductFindResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "trademark", expression = "java(getTrademark(request))")
    @Mapping(target = "categories", expression = "java(getCategories(request))")
    @Mapping(target = "characteristic", expression = "java(getCharacteristic(request))")
    Product toEntity(ProductCreateRequest request);

    ProductCreateResponse toCreate(Product product);

    @Mapping(target = "id", source = "productId")
    @Mapping(target = "country", source = "characteristic.country")
    @Mapping(target = "weight", source = "characteristic.weight")
    @Mapping(target = "height", source = "characteristic.height")
    @Mapping(target = "length", source = "characteristic.length")
    @Mapping(target = "width", source = "characteristic.width")
    @Mapping(target = "structure", source = "characteristic.structure")
    ProductFindResponse toFind(Product product);

    default Characteristic getCharacteristic(ProductCreateRequest request) {
        return Characteristic.builder().characteristicId(request.getCharacteristicId()).build();
    }

    default Trademark getTrademark(ProductCreateRequest request) {
        return Trademark.builder().trademarkId(request.getTrademarkId()).build();
    }

    default Set<Category> getCategories(ProductCreateRequest request) {
        if (request.getCategoriesId() == null || request.getCategoriesId().isEmpty())
            return Set.of();
        return request.getCategoriesId().stream()
                .map(category -> Category.builder().categoryId(category).build())
                .collect(Collectors.toSet());
    }
}
