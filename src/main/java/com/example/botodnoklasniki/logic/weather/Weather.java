package com.example.botodnoklasniki.logic.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Weather {
    Coord coord;
    List<WeatherInObject> weather;
    String base;
    @JsonProperty("main")
    MainObject mainObject;
    int visibility;
    Wind wind;
    Clouds clouds;
    Rain rain;
    Snow snow;
    long dt;
    Sys sys;
    long timezone;
    long id;
    String name;
    int cod;
}
