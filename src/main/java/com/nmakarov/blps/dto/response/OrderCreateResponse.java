package com.nmakarov.blps.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
public class OrderCreateResponse implements Serializable {
    private static final Long serialVersionUID = 1L;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("count")
    private Integer cntOfProducts;
    @JsonProperty("totalCost")
    private Double totalCost;
    @JsonProperty("product")
    private List<ProductCreateResponse> product;
}
