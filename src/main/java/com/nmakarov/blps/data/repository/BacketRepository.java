package com.nmakarov.blps.data.repository;

import com.nmakarov.blps.data.domain.Backet;
import com.nmakarov.blps.data.domain.Product;
import com.nmakarov.blps.data.domain.ProductOrder;
import com.nmakarov.blps.data.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface BacketRepository extends JpaRepository<Backet, Long>, QuerydslPredicateExecutor<Backet> {
    List<Backet> findAllByUser(User user);

    List<Backet> findAllByProductOrder(ProductOrder productOrder);

    boolean existsBacketByUserId(Long userId);

}
