package com.nmakarov.blps.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class OrderCreateRequest implements Serializable {
    private static final Long serialVersionUID = 1L;

    @JsonProperty("userId")
    private Long userId;

    @JsonProperty("paymentMethod")
    private Integer paymentMethod;
}
