package com.nmakarov.blps.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmakarov.blps.data.domain.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CharacteristicUpdateRequest implements Serializable {
    private static final long serialVersionUID = 1L;
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
