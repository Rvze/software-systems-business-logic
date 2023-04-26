package com.nmakarov.blps.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class BacketCreateResponse implements Serializable {
    private static final Long serialVersionUID = 1L;
    @JsonProperty("userId")
    private Long userId;

    @JsonProperty("productId")
    private Long productId;

    @JsonProperty("count")
    private Long cntOfProducts;

    @JsonProperty("productCost")
    private Double productCost;

    @JsonProperty("totalCost")
    private Double totalCost;

}
