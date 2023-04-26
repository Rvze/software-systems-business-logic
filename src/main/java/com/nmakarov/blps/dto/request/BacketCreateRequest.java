package com.nmakarov.blps.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class BacketCreateRequest implements Serializable {
    private static final Long serialVersionUID = 1L;

    @JsonProperty("userId")
    private Long userId;

    @JsonProperty("productId")
    private Long productId;

    @JsonProperty("count")
    private Integer count;
}
