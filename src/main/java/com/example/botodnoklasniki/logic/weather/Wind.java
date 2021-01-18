package com.example.botodnoklasniki.logic.weather;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Wind {
    double speed;
    double deg;
    double gust;
}
