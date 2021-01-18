package com.example.botodnoklasniki.client.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Recipient {
    @JsonProperty("chat_id")
    String chatId;
}
