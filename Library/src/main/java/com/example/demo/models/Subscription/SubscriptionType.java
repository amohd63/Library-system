package com.example.demo.models.Subscription;

import java.util.HashMap;
import java.util.Map;

public class SubscriptionType {
    private static final Map<String, String> subscriptionTypeMap = new HashMap<>();

    static {
        subscriptionTypeMap.put("premium", "PremiumSubscription");
        subscriptionTypeMap.put("budget", "BudgetSubscription");
    }

    public static String getSubscriptionType(String type) {
        return subscriptionTypeMap.getOrDefault(type, "Unknown");
    }
}