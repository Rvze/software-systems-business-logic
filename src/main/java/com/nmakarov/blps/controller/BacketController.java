package com.nmakarov.blps.controller;

import com.nmakarov.blps.dto.request.BacketCreateRequest;
import com.nmakarov.blps.dto.response.BacketCreateResponse;
import com.nmakarov.blps.service.BacketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/backet")
@RequiredArgsConstructor
public class BacketController {
    private final BacketService service;

    @PostMapping("/add-product")
    public ResponseEntity<BacketCreateResponse> addProductToBacket(
            @RequestBody BacketCreateRequest request
    ) {
        var response = service.addProductToBucket(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
