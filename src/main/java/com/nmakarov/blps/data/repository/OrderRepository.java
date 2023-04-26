package com.nmakarov.blps.data.repository;

import com.nmakarov.blps.data.domain.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface OrderRepository extends JpaRepository<ProductOrder, Long>, QuerydslPredicateExecutor<ProductOrder> {
    List<ProductOrder> findAllByUserId(Long userId);
}
