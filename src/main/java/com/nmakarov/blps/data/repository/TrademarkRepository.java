package com.nmakarov.blps.data.repository;

import com.nmakarov.blps.data.domain.Trademark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TrademarkRepository extends JpaRepository<Trademark, Long>,
        QuerydslPredicateExecutor<Trademark> {
}
