package com.example.botodnoklasniki.messageForUser;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Message {
    String text;
    long seq;
    String mid;
}
