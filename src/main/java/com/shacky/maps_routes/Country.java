package com.shacky.maps_routes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Country {
    private String cca3;

    @JsonProperty("borders")
    private List<String> borders;
}
