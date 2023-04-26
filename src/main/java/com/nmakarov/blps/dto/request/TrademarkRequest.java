package com.nmakarov.blps.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class TrademarkRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("trademarkName")
    private String trademarkName;

}
