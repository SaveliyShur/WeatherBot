package com.example.botodnoklasniki.messageForUser;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Notification {
     String webhookType;
     Sender sender;
     Recipient recipient;

    Message message;
    long timestamp;
}
