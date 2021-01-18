package com.example.botodnoklasniki.logic;

import com.example.botodnoklasniki.client.OdnoklassnikiClient;
import com.example.botodnoklasniki.logic.weather.Weather;
import com.example.botodnoklasniki.messageForUser.Message;
import com.example.botodnoklasniki.messageForUser.Notification;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HandlerForUserMessage {
    private static final Logger logger = LoggerFactory.getLogger(HandlerForUserMessage.class);

    @Autowired
    RequestWeather requestWeather;

    @Autowired
    OdnoklassnikiClient odnoklassnikiClient;


    public void handleMessage(Notification notification){
        Message message = notification.getMessage();
        String chatId = notification.getRecipient().getChatId();
        String[] messageString = message.getText().trim().split("\\s");
        logger.info("Город " + messageString[1]);
        if(messageString.length == 2 && messageString[0].equals("Погода")){
            Weather weather = requestWeather.getWeatherForCity(messageString[1]);
            if(weather == null){
                odnoklassnikiClient.sendMessage("Некорректный город", chatId);
            }else {
                odnoklassnikiClient.sendMessage(parseWeather(weather), chatId);
            }
        } else {
            odnoklassnikiClient.sendMessage("Неправильно введенные данные, скорее всего много слов или" +
                    " сообщение не начинается со слова Погода", chatId);
        }
    }

    // TODO: 18.01.2021 Написать парсер
    public String parseWeather(Weather weather){
        double temp = weather.getMainObject().getTemp();
        double tempFillsLike = weather.getMainObject().getFeelsLike();
        String answer = "В этом городе температура: " + temp + "\sНо ощущается как:" + tempFillsLike +
            "Температура указана в Кельвинах.";
        return answer;
    }



}
