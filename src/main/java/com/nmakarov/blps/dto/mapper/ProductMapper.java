package com.nmakarov.blps.dto.mapper;

import com.nmakarov.blps.data.domain.Characteristic;
import com.nmakarov.blps.data.domain.Product;
import com.nmakarov.blps.dto.request.ProductCreateRequest;
import com.nmakarov.blps.dto.response.ProductCreateResponse;
import com.nmakarov.blps.dto.response.ProductFindResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "trademark", ignore = true)
    @Mapping(target = "categories", ignore = true)
    @Mapping(target = "characteristic", expression = "java(getCharacteristic(request))")
    Product toEntity(ProductCreateRequest request);

    ProductCreateResponse toCreate(Product product);

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
}
