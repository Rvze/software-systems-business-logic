package com.nmakarov.blps.data.repository;

import com.nmakarov.blps.data.domain.Backet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface BacketRepository extends JpaRepository<Backet, Long>, QuerydslPredicateExecutor<Backet> {
    List<Backet> findALlByUserId(Long userId);
}
