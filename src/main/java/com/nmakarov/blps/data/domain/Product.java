package com.nmakarov.blps.data.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Product implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_product_id_seq")
    @SequenceGenerator(name = "product_product_id_seq", allocationSize = 1)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private Double productPrice;

    @Column(name = "count")
    private Integer count;

    @OneToOne
    @JoinColumn(name = "characteristic_id", referencedColumnName = "characteristic_id")
    private Characteristic characteristic;

    @ManyToOne
    @JoinColumn(name = "trademark_id")
    private Trademark trademark;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "product_category",
            joinColumns = {
                    @JoinColumn(name = "product_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "category_id")
            }
    )
    private Set<Category> categories;

    @ManyToMany(mappedBy = "products")
    private Set<User> users;

    public Characteristic getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(Characteristic characteristic) {
        if (sameAsFormer(characteristic))
            return;
        Characteristic oldCharacteristic = this.characteristic;
        this.characteristic = characteristic;
        if (oldCharacteristic != null)
            oldCharacteristic.setProduct(null);
        if (characteristic != null)
            characteristic.setProduct(this);
        this.characteristic = characteristic;
    }

    private boolean sameAsFormer(Characteristic newCharacteristic) {
        return Objects.equals(characteristic, newCharacteristic);
    }
}
