package com.example.botodnoklasniki.logic;

import com.example.botodnoklasniki.logic.weather.Weather;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class RequestWeather {
    private static final Logger logger = LoggerFactory.getLogger(RequestWeather.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ConfigWeatherApi config;

    @Autowired
    ObjectMapper objectMapper;

    public Weather getWeatherForCity(String city){
        logger.info("Weather request");
        final String url = String.format(
                config.getMethodUrltemplate(),
                city,
                config.getApiKey());
        try {
            logger.info("Url for weather " + url);
            Weather weather = restTemplate.getForObject(url, Weather.class);
            logger.info("Успешный парсинг погоды");
            logger.info(weather.toString());
            return weather;
        } catch (RestClientException e) {
            logger.info("Ошибка при обработке запроса на погоду" + e.getMessage());
            return null;
        }
    }
}
