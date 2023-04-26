package com.nmakarov.blps.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProductFindRequest implements Serializable {
    private static final Long serialVersionUID = 1L;

    @JsonProperty("id")
    private Long id;

    @JsonProperty("productName")
    private String productName;

    @JsonProperty("productPrice")
    private Double productPrice;

    @JsonProperty("count")
    private Integer count;

    @JsonProperty("country")
    private String country;

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
