package com.nmakarov.blps.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmakarov.blps.data.domain.Country;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProductFindResponse implements Serializable {
    private static final Long serialVersionUID = 1L;
    @JsonProperty("id")
    private Long id;

    @JsonProperty("productName")
    private String productName;

    @JsonProperty("productPrice")
    private Double productPrice;

    @JsonProperty("country")
    private Country country;

    @JsonProperty("weight")
    private Double weight;

    @JsonProperty("height")
    private Double height;

    @JsonProperty("length")
    private Double length;

    @JsonProperty("width")
    private Double width;

    @JsonProperty("structure")
    private String structure;
}
