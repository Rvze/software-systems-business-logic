package com.nmakarov.blps.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProductCreateRequest implements Serializable {
    private static final Long serialVersionUID = 1L;

    @JsonProperty("productName")
    private String productName;

    @JsonProperty("productPrice")
    private Double productPrice;

    @JsonProperty("characteristicId")
    private Long characteristicId;
}
