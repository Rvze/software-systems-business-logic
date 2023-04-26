package com.nmakarov.blps.data.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "characteristic")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Characteristic implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "characteristic_characteristic_id_seq")
    @SequenceGenerator(name = "characteristic_characteristic_id_seq", allocationSize = 1)
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
    @OneToOne(mappedBy = "characteristic")
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        if (isSame(product))
            return;
        Product oldProduct = this.product;
        this.product = product;
        if (oldProduct != null)
            oldProduct.setCharacteristic(null);
        if (product != null)
            product.setCharacteristic(this);
        this.product = product;
    }

    private boolean isSame(Product newProduct) {
        return Objects.equals(product, newProduct);
    }
}
