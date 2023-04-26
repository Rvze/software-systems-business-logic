package com.nmakarov.blps.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class CharacteristicFindRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("characteristicId")
    private Long characteristicId;
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
