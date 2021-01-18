package com.example.botodnoklasniki.client;

import com.example.botodnoklasniki.client.chat.Message;
import com.example.botodnoklasniki.client.chat.MessageTitle;
import com.example.botodnoklasniki.client.chat.Recipient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Service
public class OdnoklassnikiClient {

    private static final Logger logger = LoggerFactory.getLogger(OdnoklassnikiClient.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ClienConfig config;

    @PostConstruct
    void init(){
        if(!checkSubscriptions() && !subscribe()){
            logger.error("Failed to subscribe. Exiting...");
            System.exit(2);
        }
    }

    public boolean subscribe() {
            logger.info("Trying to subscribe...");
            final String methodUrl = String.format(config.getMethodUrlTemplate(),
                    config.getSubscribeMethod(),
                    config.getToken());
            final Response response = restTemplate.postForObject(methodUrl,
                    new SubscribeBody(config.getBotHook()),
                    Response.class );
            logger.info("Succsesssss");
            return response != null && response.isSuccses();
    }

    public boolean checkSubscriptions(){
        logger.info("Checking for Subscriptions");
        final SubscriptionsResponse response = restTemplate.getForObject(String.format(config.getMethodUrlTemplate(),
                config.getSubscriptionMethod(),
                config.getToken()),
                SubscriptionsResponse.class);
        if(response == null || response.getSubscriptions().isEmpty()){
            logger.info("Subscriptions responce is empty");
            return false;
        }
        final String botHook = config.getBotHook();
        final boolean result = response.getSubscriptions().stream()
                .anyMatch(subscription -> botHook.equals(subscription.getUrl()));
        if(result){
            logger.info("There is a subscription for " + botHook);
        } else {
            logger.info("There is not a subscription for " + botHook);
        }
        return result;
    }

    public boolean sendMessage(String message, String chatId){
        logger.info("Отправка сообщения " + message + "в " + chatId);
        MessageTitle messageTitle = new MessageTitle(
                new Recipient(chatId),
                new Message(message)
        );
        final String methodUrl = String.format(config.getMethodUrlTemplate(),
                config.getSendMessageMethod() + chatId,
                config.getToken());
        final Response response = restTemplate.postForObject(methodUrl, messageTitle, Response.class);
        logger.info("Сообщение куда то пошло");
        logger.info("Статус сообщения: " + (response != null ) + response.isSuccses());
        return response != null && response.isSuccses();
    }
}
