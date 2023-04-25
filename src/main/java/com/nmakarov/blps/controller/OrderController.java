package com.nmakarov.blps.controller;

import com.nmakarov.blps.dto.request.OrderCreateRequest;
import com.nmakarov.blps.dto.response.OrderCreateResponse;
import com.nmakarov.blps.dto.response.OrderCreateResponseAscendingByDate;
import com.nmakarov.blps.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController(value = "/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;

    @PostMapping("/create-order")
    public ResponseEntity<OrderCreateResponse> createOrder(@RequestBody OrderCreateRequest request) {
        var response = service.createOrder(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    //TODO по токену посмотреть
    @GetMapping("/findAllOrders")
    public ResponseEntity<Page<OrderCreateResponseAscendingByDate>> findAllOrdersAscendingByDate(
            @RequestParam Long userId,
            Pageable pageable) {
        var response = service.findAll(userId, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
