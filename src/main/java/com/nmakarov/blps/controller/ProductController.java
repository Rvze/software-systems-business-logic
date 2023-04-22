package com.nmakarov.blps.controller;

import com.nmakarov.blps.dto.request.ProductCreateRequest;
import com.nmakarov.blps.dto.request.ProductFindRequest;
import com.nmakarov.blps.dto.response.ProductCreateResponse;
import com.nmakarov.blps.dto.response.ProductFindResponse;
import com.nmakarov.blps.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController(value = "products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping(value = "/create")
    public ResponseEntity<ProductCreateResponse> createProduct(
            @RequestBody(required = false)
            ProductCreateRequest request) {
        ProductCreateResponse response = productService.createProduct(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(value = "/find")
    public ResponseEntity<Page<ProductFindResponse>> findProduct(
            @RequestBody(required = false)
            ProductFindRequest request,
            Pageable pageable
    ) {
        Page<ProductFindResponse> response = productService.findProduct(request, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable Long id
    ) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
