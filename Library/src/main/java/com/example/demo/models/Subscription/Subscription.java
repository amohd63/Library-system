package com.example.demo.models.Subscription;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Inheritance
@Entity
@Table(name = "subscription")
@DiscriminatorColumn(name = "dtype")
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PremiumSubscription.class, name = "premium"),
        @JsonSubTypes.Type(value = BudgetSubscription.class, name = "budget")
})
public abstract class Subscription implements SubscriptionStrategy{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subscriptionID")
    private Integer subscriptionID;

    @Column(name = "userID")
    private Integer userID;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "borrow_limit")
    private int borrowLimit;

//    public Subscription(int borrowLimit) {
//        this.borrowLimit = borrowLimit;
//    }
}
