package com.nmakarov.blps.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmakarov.blps.data.domain.Country;
import lombok.Data;

@Data
public class CharacteristicCreateRequest {
    @JsonProperty("country")
    private Country country;

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
