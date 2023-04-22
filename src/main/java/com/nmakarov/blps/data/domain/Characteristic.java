package com.nmakarov.blps.data.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "characteristic")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Characteristic {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "characteristic_characteristic_id_seq")
    @Column(name = "characteristic_id")
    private Long characteristicId;

    @Column(name = "country")
    @Enumerated(EnumType.STRING)
    private Country country;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "height")
    private Double height;

    @Column(name = "length")
    private Double length;

    @Column(name = "width")
    private Double width;

    @Column(name = "structure")
    private String structure;
}
