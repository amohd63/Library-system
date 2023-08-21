package com.example.demo.models.Book;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@DiscriminatorValue("Journals")
public class Journal extends Book implements BookStrategy{
//    public Journals(String serialNumber, String name, int numOfPages, String genre, String author, int availableCopies, int totalCopies) {
//        super(serialNumber, name, numOfPages, genre, author, availableCopies, totalCopies);
//    }

    @Override
    public void implementBook() {

    }
}