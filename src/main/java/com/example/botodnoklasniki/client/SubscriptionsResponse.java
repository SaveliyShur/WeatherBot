package com.example.botodnoklasniki.client;

import lombok.Data;

import java.util.List;

@Data
public class SubscriptionsResponse {
    private List<Subscription> subscriptions;
}
