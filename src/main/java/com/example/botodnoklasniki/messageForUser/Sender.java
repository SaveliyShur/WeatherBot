package com.example.botodnoklasniki.messageForUser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Sender {

    @JsonProperty("user_id")
    String userId;
}
