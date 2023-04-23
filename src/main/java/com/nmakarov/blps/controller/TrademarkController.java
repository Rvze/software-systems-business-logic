package com.nmakarov.blps.controller;

import com.nmakarov.blps.dto.request.TrademarkFindRequest;
import com.nmakarov.blps.dto.request.TrademarkRequest;
import com.nmakarov.blps.dto.response.TrademarkResponse;
import com.nmakarov.blps.service.TrademarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/trademark")
@RequiredArgsConstructor
public class TrademarkController {
    private final TrademarkService trademarkService;

    @PostMapping(value = "/create-trademark")
    public ResponseEntity<TrademarkResponse> createTrademark(
            @RequestBody TrademarkRequest request
    ) {
        var response = trademarkService.createTrademark(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(value = "/find-trademark")
    public ResponseEntity<Page<TrademarkResponse>> findTrademark(
            @RequestBody TrademarkFindRequest request,
            Pageable pageable
    ) {
        var response = trademarkService.findTrademark(request, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping(value = "/update-trademark/{id}")
    public ResponseEntity<TrademarkResponse> updateTrademark(
            @PathVariable Long id,
            @RequestBody TrademarkRequest request
    ) {
        var response = trademarkService.updateTrademark(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping(value = "delete-trademark/{id}")
    public ResponseEntity<Void> deleteTrademark(
            @PathVariable Long id
    ) {
        trademarkService.deleteTrademarkById(id);
        return ResponseEntity.noContent().build();
    }
}
