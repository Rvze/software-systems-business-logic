package com.nmakarov.blps.data.repository;

import com.nmakarov.blps.data.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ProductRepository extends JpaRepository<Product, Long>,
        QuerydslPredicateExecutor<Product> {

    boolean existsProductByCharacteristicId(Long characteristicId);
}
