package com.example.botodnoklasniki.logic.weather;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Sys {
    int type;
    int id;
    String country;
    long sunrise;
    long sunset;
}
