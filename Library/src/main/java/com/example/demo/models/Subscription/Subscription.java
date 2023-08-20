package com.example.demo.models.Subscription;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Inheritance
@Entity
@Table(name = "subscription")
@DiscriminatorColumn(name = "dtype")
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class Subscription {
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
