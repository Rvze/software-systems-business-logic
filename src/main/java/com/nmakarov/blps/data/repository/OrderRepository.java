package com.nmakarov.blps.data.repository;

import com.nmakarov.blps.data.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long>, QuerydslPredicateExecutor<Order> {
    List<Order> findAllByUserId(Long userId);
}
