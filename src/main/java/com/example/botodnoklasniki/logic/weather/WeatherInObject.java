package com.example.botodnoklasniki.logic.weather;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class WeatherInObject {
    int id;
    String main;
    String description;
    String icon;
}
