package com.nmakarov.blps.data.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "backet")
@Getter
@Setter
@IdClass(User.class)
public class Backet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "backet_backet_id_seq")
    @SequenceGenerator(name = "backet_backet_id_seq", allocationSize = 1)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "total_cost")
    private Double totalCost;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "count")
    private Integer count;
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
