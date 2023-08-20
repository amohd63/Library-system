package com.example.demo.models;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "subscription")
public class Subscription {
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

    public Subscription(Integer subscriptionID, Integer userID, Date startDate, Date endDate) {
        this.subscriptionID = subscriptionID;
        this.userID = userID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Subscription(Integer subscriptionID, Integer userID, Date endDate) {
        this.subscriptionID = subscriptionID;
        this.userID = userID;
        this.startDate = Date.valueOf(LocalDate.now());
        this.endDate = endDate;
    }

    public Subscription() {
        this.startDate = Date.valueOf(LocalDate.now());
    }

    public Integer getSubscriptionID() {
        return subscriptionID;
    }

    public void setSubscriptionID(Integer subscriptionID) {
        this.subscriptionID = subscriptionID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return Objects.equals(subscriptionID, that.subscriptionID) && Objects.equals(userID, that.userID) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "subscriptionID=" + subscriptionID +
                ", userID=" + userID +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
