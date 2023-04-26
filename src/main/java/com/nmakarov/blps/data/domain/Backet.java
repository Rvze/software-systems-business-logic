package com.nmakarov.blps.data.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "backet")
@Getter
@Setter
public class Backet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "backet_backet_id_seq")
    @SequenceGenerator(name = "backet_backet_id_seq", allocationSize = 1)
    @Column(name = "backet_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "total_cost")
    private Double totalCost;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "count")
    private Integer count;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private ProductOrder productOrder;
}
