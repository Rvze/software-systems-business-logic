package com.nmakarov.blps.controller;

import com.nmakarov.blps.dto.request.CategoryCreateRequest;
import com.nmakarov.blps.dto.request.CategoryFindRequest;
import com.nmakarov.blps.dto.response.CategoryCreateResponse;
import com.nmakarov.blps.dto.response.CategoryDeleteResponse;
import com.nmakarov.blps.dto.response.CategoryFindResponse;
import com.nmakarov.blps.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/create-category")
    public ResponseEntity<CategoryCreateResponse> createCategory(
            @RequestBody(required = false)
            CategoryCreateRequest request
    ) {
        CategoryCreateResponse response = categoryService.createCategory(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/delete-category/{id}")
    public ResponseEntity<CategoryDeleteResponse> deleteCategory(
            @PathVariable Long id
    ) {
        categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.OK).body(new CategoryDeleteResponse(id));
    }

    @GetMapping("find-categories")
    public ResponseEntity<Page<CategoryFindResponse>> findCategory(
            @RequestBody CategoryFindRequest categoryFindRequest,
            Pageable pageable
    ) {
        Page<CategoryFindResponse> page = categoryService.findCategories(categoryFindRequest, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @GetMapping("find-category/{id}")
    public ResponseEntity<CategoryFindResponse> findCategoryById(
            @PathVariable Long id
    ) {
        CategoryFindResponse categoryFindResponse = categoryService.findCategoryById(id);
        return ResponseEntity.status(HttpStatus.OK).body(categoryFindResponse);
    }
}
