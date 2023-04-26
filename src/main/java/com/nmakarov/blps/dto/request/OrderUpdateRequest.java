package com.nmakarov.blps.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class OrderUpdateRequest implements Serializable {
    private static final Long serialVersionUID = 1L;

    @JsonProperty("paymentMethod")
    private Integer paymentMethod;

    @JsonProperty("deliveryDate")
    private LocalDate deliveryDate;
    @JsonProperty("status")
    private String status;

}
