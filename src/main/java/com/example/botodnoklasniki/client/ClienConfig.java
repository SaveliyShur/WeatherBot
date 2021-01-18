package com.example.botodnoklasniki.client;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "client")
@Data
public class ClienConfig {
    private String botHook;
    private String methodUrlTemplate;
    private String subscribeMethod;
    private String subscriptionMethod;
    private String token;
    private String sendMessageMethod;
}
