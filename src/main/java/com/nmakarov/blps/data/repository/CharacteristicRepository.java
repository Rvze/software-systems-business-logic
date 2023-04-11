package com.nmakarov.blps.data.repository;

import com.nmakarov.blps.data.domain.Characteristic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CharacteristicRepository extends JpaRepository<Characteristic, Long>,
        QuerydslPredicateExecutor<Characteristic> {
}
