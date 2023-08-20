package com.example.demo.models.Subscription;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.sql.Date;

@Entity
@NoArgsConstructor
public class BudgetSubscription extends Subscription{
    private static final int BORROW_LIMIT = 1;
    public BudgetSubscription(Integer subscriptionID, Integer userID, Date startDate, Date endDate) {
        super(subscriptionID, userID, startDate, endDate, BORROW_LIMIT);
    }
}
