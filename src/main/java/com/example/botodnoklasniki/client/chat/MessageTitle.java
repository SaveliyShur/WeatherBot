package com.example.botodnoklasniki.client.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class MessageTitle {
    Recipient recipient;
    Message message;
}
