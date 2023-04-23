package com.nmakarov.blps.service;

import com.nmakarov.blps.data.domain.Characteristic;
import com.nmakarov.blps.data.domain.QCharacteristic;
import com.nmakarov.blps.data.repository.CharacteristicRepository;
import com.nmakarov.blps.dto.mapper.CharacteristicMapper;
import com.nmakarov.blps.dto.request.CharacteristicCreateRequest;
import com.nmakarov.blps.dto.request.CharacteristicFindRequest;
import com.nmakarov.blps.dto.request.CharacteristicUpdateRequest;
import com.nmakarov.blps.dto.response.CharacteristicResponse;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.nmakarov.blps.utils.ErrorMessages.CHARACTERISTIC_NOT_FOUND;
import static com.nmakarov.blps.utils.ExceptionsUtils.ifThrow;
import static com.nmakarov.blps.utils.ExceptionsUtils.notFound;
import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class CharacteristicService {
    private final CharacteristicRepository repository;
    private final ResourceService res;
    private final CharacteristicMapper mapper;

    @Transactional
    public CharacteristicResponse createCharacteristic(CharacteristicCreateRequest request) {
        return mapper.toCreate(repository.save(mapper.toEntity(request)));
    }

    @Transactional
    public CharacteristicResponse updateCharacteristic(Long id, CharacteristicUpdateRequest request) {
        Characteristic characteristic = repository.findById(id).orElseThrow(() -> notFound(res.localize(CHARACTERISTIC_NOT_FOUND)));
        mapper.update(characteristic, request);
        return mapper.toCreate(repository.save(characteristic));
    }

    public Page<CharacteristicResponse> findCharacteristic(CharacteristicFindRequest predicate, Pageable pageable) {
        BooleanBuilder bb = new BooleanBuilder();
        QCharacteristic q = QCharacteristic.characteristic;
        ofNullable(predicate.getCharacteristicId()).map(q.characteristicId::eq).ifPresent(bb::and);
        ofNullable(predicate.getWeight()).map(q.weight::eq).ifPresent(bb::and);
        ofNullable(predicate.getHeight()).map(q.height::eq).ifPresent(bb::and);
        ofNullable(predicate.getLength()).map(q.length::eq).ifPresent(bb::and);
        ofNullable(predicate.getWidth()).map(q.width::eq).ifPresent(bb::and);
        ofNullable(predicate.getStructure()).map(q.structure::eq).ifPresent(bb::and);
        return repository.findAll(bb, pageable).map(mapper::toCreate);
    }


    public void deleteCharacteristicById(Long id) {
        ifThrow(!repository.existsById(id), () -> notFound(res.localize(CHARACTERISTIC_NOT_FOUND, id)));
        repository.deleteById(id);
    }


}
