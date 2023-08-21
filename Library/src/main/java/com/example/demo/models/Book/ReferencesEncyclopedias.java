package com.example.demo.models.Book;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
//@DiscriminatorValue("ReferencesEncyclopedias")
public class ReferencesEncyclopedias extends Book {
    public ReferencesEncyclopedias(String serialNumber, String name, int numOfPages, String genre, String author, int availableCopies, int totalCopies) {
        super(serialNumber, name, numOfPages, genre, author, availableCopies, totalCopies);
    }
}
