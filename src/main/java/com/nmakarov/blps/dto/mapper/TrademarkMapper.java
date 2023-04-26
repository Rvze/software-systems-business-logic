package com.nmakarov.blps.dto.mapper;

import com.nmakarov.blps.data.domain.Trademark;
import com.nmakarov.blps.dto.request.TrademarkRequest;
import com.nmakarov.blps.dto.response.TrademarkResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TrademarkMapper {

    Trademark toEntity(TrademarkRequest request);

    TrademarkResponse toResponse(Trademark trademark);

    void update(@MappingTarget Trademark trademark, TrademarkRequest request);
}
