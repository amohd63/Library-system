package com.example.demo.models;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "borrow")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "borrowID")
    private Integer borrowID;

    @Column(name = "userID")
    private Integer userID;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "borrow_date")
    private Date startDate;

    @Column(name = "due_date")
    private Date endDate;

    public Borrow(Integer userID, String serialNumber) {
        this.setUserID(userID);
        this.setSerialNumber(serialNumber);
    }
}
