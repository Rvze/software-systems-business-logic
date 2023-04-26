package com.nmakarov.blps.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class OrderCreateResponseAscendingByDate implements Serializable {
    private static final Long serialVersionUID = 1L;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("deliveryDate")
    private LocalDate deliveryDate;
    @JsonProperty("count")
    private Integer cntOfProducts;
    @JsonProperty("totalCost")
    private Double totalCost;
}
