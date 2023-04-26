package com.nmakarov.blps.data.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "trademark")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Trademark implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trademark_trademark_id_seq")
    @SequenceGenerator(name = "trademark_trademark_id_seq", allocationSize = 1)
    @Column(name = "trademark_id")
    private Long trademarkId;

    @Column(name = "trademakr_name")
    private String trademarkName;

    @OneToMany(mappedBy = "productId")
    private Set<Product> products;
}
