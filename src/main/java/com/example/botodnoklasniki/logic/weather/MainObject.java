package com.example.botodnoklasniki.logic.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MainObject {
    double temp;
    @JsonProperty("feels_like")
    double feelsLike;
    @JsonProperty("temp_min")
    double tempMin;
    @JsonProperty("temp_max")
    double tempMax;
    double pressure;
    double humidity;
    @JsonProperty("sea_level")
    double seaLevel;
    @JsonProperty("grnd_level")
    double grndLevel;
}
