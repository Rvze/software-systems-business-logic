package com.nmakarov.blps.controller;

import com.nmakarov.blps.dto.request.ProductCreateRequest;
import com.nmakarov.blps.dto.request.ProductFindRequest;
import com.nmakarov.blps.dto.response.ProductCreateResponse;
import com.nmakarov.blps.dto.response.ProductFindResponse;
import com.nmakarov.blps.service.ProductService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController(value = "/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping(value = "/create-product")
    public ResponseEntity<ProductCreateResponse> createProduct(
            @RequestBody(required = false)
            ProductCreateRequest request) {
        ProductCreateResponse response = productService.createProduct(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(value = "/find-product")
    @PageableAsQueryParam
    public ResponseEntity<Page<ProductFindResponse>> findProduct(
            ProductFindRequest request,
            @Parameter(hidden = true) Pageable pageable
    ) {
        Page<ProductFindResponse> response = productService.findProduct(request, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping(value = "/delete-product/{id}")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable Long id
    ) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

//    public ResponseEntity<Void>
}
