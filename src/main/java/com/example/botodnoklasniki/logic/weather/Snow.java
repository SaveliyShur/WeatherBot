package com.example.botodnoklasniki.logic.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Snow {
    @JsonProperty("1h")
    double h1;
    @JsonProperty("h3")
    double h3;
}
