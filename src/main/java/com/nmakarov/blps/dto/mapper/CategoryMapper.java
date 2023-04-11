package com.nmakarov.blps.dto.mapper;

import com.nmakarov.blps.data.domain.Category;
import com.nmakarov.blps.dto.request.CategoryCreateRequest;
import com.nmakarov.blps.dto.request.CategoryFindRequest;
import com.nmakarov.blps.dto.response.CategoryCreateResponse;
import com.nmakarov.blps.dto.response.CategoryFindResponse;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target = "categoryId", ignore = true)
    @Mapping(target = "products", ignore = true)
    Category toEntity(CategoryCreateRequest request);

    @Mapping(target = "id", source = "categoryId")
    CategoryCreateResponse toResponse(Category category);

    CategoryFindResponse to(Category category);

    CategoryFindRequest toDto(Category category);

//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Category partialUpdate(CategoryFindRequest categoryFindRequest, @MappingTarget Category category);
}
