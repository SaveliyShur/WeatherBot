package com.example.botodnoklasniki.logic;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "weather")
public class ConfigWeatherApi {
    private String methodUrltemplate;
    private String apiKey;
}
