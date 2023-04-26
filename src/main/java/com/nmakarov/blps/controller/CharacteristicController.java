package com.nmakarov.blps.controller;

import com.nmakarov.blps.dto.request.CharacteristicCreateRequest;
import com.nmakarov.blps.dto.request.CharacteristicFindRequest;
import com.nmakarov.blps.dto.request.CharacteristicUpdateRequest;
import com.nmakarov.blps.dto.response.CharacteristicResponse;
import com.nmakarov.blps.service.CharacteristicService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/characteristic")
@RequiredArgsConstructor
public class CharacteristicController {
    private final CharacteristicService characteristicService;

    @PostMapping("/create-characteristic")
    public ResponseEntity<CharacteristicResponse> createCharacteristic(
            @RequestBody(required = false) CharacteristicCreateRequest request
    ) {
        CharacteristicResponse response = characteristicService.createCharacteristic(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @PutMapping("update-characteristic/{id}")
    public ResponseEntity<CharacteristicResponse> updateCharacteristic(
            @PathVariable Long id, @RequestBody CharacteristicUpdateRequest request
    ) {
        CharacteristicResponse response = characteristicService.updateCharacteristic(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/find-characteristic")
    public ResponseEntity<Page<CharacteristicResponse>> findCharacteristic(
            @RequestBody CharacteristicFindRequest findRequest,
            Pageable pageable
    ) {
        Page<CharacteristicResponse> responsePage = characteristicService.findCharacteristic(findRequest, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(responsePage);
    }


    @DeleteMapping("/delete-characteristic/{id}")
    public ResponseEntity<Void> deleteCharacteristic(
            @PathVariable Long id
    ) {
        characteristicService.deleteCharacteristicById(id);
        return ResponseEntity.noContent().build();
    }
}
