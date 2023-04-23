package com.nmakarov.blps.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Data
public class TrademarkResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private Long trademarkId;
    @JsonProperty("trademarkName")
    private String trademarkName;
}
