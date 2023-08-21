package com.example.demo.models.Subscription;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.sql.Date;

@Entity
@NoArgsConstructor
@DiscriminatorValue("BudgetSubscription")
public class BudgetSubscription extends Subscription implements SubscriptionStrategy{
    private static final int BORROW_LIMIT = 1;

    @Override
    public void subscribe() {
        this.setBorrowLimit(BORROW_LIMIT);
    }
}
