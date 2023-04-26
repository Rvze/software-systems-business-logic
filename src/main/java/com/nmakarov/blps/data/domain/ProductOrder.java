package com.nmakarov.blps.data.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductOrder implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_order_product_order_id_id_seq")
    @SequenceGenerator(name = "product_order_product_order_id_id_seq", allocationSize = 1)
    @Column(name = "product_order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "payment_method")
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Column(name = "delivery_data")
    private LocalDate deliveryDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "total_cost")
    private Double totalCost;

}
