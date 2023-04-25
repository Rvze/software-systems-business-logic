package com.nmakarov.blps.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ProductCreateResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("id")
    private Long id;

    @JsonProperty("productName")
    private String productName;

    @JsonProperty("productPrice")
    private Double productPrice;

    @JsonProperty("count")
    private Integer count;

}
