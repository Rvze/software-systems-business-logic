package com.nmakarov.blps.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryFindRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("categoryName")
    private String categoryName;
}