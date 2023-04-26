package com.nmakarov.blps.dto.mapper;

import com.nmakarov.blps.data.domain.Characteristic;
import com.nmakarov.blps.dto.request.CharacteristicCreateRequest;
import com.nmakarov.blps.dto.request.CharacteristicUpdateRequest;
import com.nmakarov.blps.dto.response.CharacteristicResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CharacteristicMapper {
    Characteristic toEntity(CharacteristicCreateRequest request);

    CharacteristicResponse toCreate(Characteristic characteristic);

    @Mapping(target = "characteristicId", ignore = true)
    @Mapping(target = "country", ignore = true)
    @Mapping(target = "weight", source = "weight")
    @Mapping(target = "height", source = "height")
    @Mapping(target = "length", source = "length")
    @Mapping(target = "structure", source = "structure")
    void update(@MappingTarget Characteristic characteristic, CharacteristicUpdateRequest request);
}
