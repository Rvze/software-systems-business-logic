package com.nmakarov.blps.service;

import com.nmakarov.blps.data.domain.Category;
import com.nmakarov.blps.data.domain.QCategory;
import com.nmakarov.blps.data.repository.CategoryRepository;
import com.nmakarov.blps.dto.mapper.CategoryMapper;
import com.nmakarov.blps.dto.request.CategoryCreateRequest;
import com.nmakarov.blps.dto.request.CategoryFindRequest;
import com.nmakarov.blps.dto.response.CategoryCreateResponse;
import com.nmakarov.blps.dto.response.CategoryFindResponse;
import com.nmakarov.blps.utils.ExceptionsUtils;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.nmakarov.blps.utils.ExceptionsUtils.*;

import static com.nmakarov.blps.utils.ErrorMessages.CATEGORY_NOT_FOUND;
import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;
    private final CategoryMapper mapper;
    private final ResourceService res;

    public CategoryCreateResponse createCategory(CategoryCreateRequest request) {
        Category categoryEntity = mapper.toEntity(request);
        return mapper.toResponse(repository.save(categoryEntity));
    }

    public Page<CategoryFindResponse> findCategories(CategoryFindRequest predicate, Pageable pageable) {
        BooleanBuilder bb = new BooleanBuilder();
        QCategory q = QCategory.category;
        ofNullable(predicate.getCategoryName()).map(q.categoryName::eq).ifPresent(bb::and);
        return repository.findAll(bb, pageable).map(mapper::to);
    }

    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }

    public CategoryFindResponse findCategoryById(Long id) {
        return repository.findById(id).map(mapper::to)
                .orElseThrow(() -> ExceptionsUtils.notFound(res.localize(CATEGORY_NOT_FOUND, id)));
    }
}
