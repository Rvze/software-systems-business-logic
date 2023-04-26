package com.nmakarov.blps.service;

import com.nmakarov.blps.data.domain.QTrademark;
import com.nmakarov.blps.data.domain.Trademark;
import com.nmakarov.blps.data.repository.TrademarkRepository;
import com.nmakarov.blps.dto.mapper.TrademarkMapper;
import com.nmakarov.blps.dto.request.TrademarkFindRequest;
import com.nmakarov.blps.dto.request.TrademarkRequest;
import com.nmakarov.blps.dto.response.TrademarkResponse;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.nmakarov.blps.utils.ErrorMessages.TRADEMARK_NOT_FOUND;
import static com.nmakarov.blps.utils.ExceptionsUtils.ifThrow;
import static com.nmakarov.blps.utils.ExceptionsUtils.notFound;
import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class TrademarkService {
    private final TrademarkRepository repository;
    private final ResourceService res;
    private final TrademarkMapper mapper;

    public TrademarkResponse createTrademark(TrademarkRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    @Transactional
    public TrademarkResponse updateTrademark(Long id, TrademarkRequest request) {
        Trademark trademark = repository.findById(id).orElseThrow(() -> notFound(res.localize(TRADEMARK_NOT_FOUND, id)));
        mapper.update(trademark, request);
        return mapper.toResponse(repository.save(trademark));
    }

    public Page<TrademarkResponse> findTrademark(TrademarkFindRequest predicate, Pageable pageable) {
        BooleanBuilder bb = new BooleanBuilder();
        QTrademark q = QTrademark.trademark;
        ofNullable(predicate.getId()).map(q.trademarkId::eq).ifPresent(bb::and);
        ofNullable(predicate.getTrademarkName()).map(q.trademarkName::eq).ifPresent(bb::and);
        return repository.findAll(bb, pageable).map(mapper::toResponse);
    }

    public void deleteTrademarkById(Long id) {
        ifThrow(!repository.existsById(id), () -> notFound(res.localize(TRADEMARK_NOT_FOUND, id)));
        repository.deleteById(id);
    }
}
