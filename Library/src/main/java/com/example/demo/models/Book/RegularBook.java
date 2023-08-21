package com.example.demo.models.Book;

import com.example.demo.models.Genre;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
//@DiscriminatorValue("RegularBook")
public class RegularBook extends Book{
    public RegularBook(String serialNumber, String name, int numOfPages, String genre, String author, int availableCopies, int totalCopies) {
        super(serialNumber, name, numOfPages, genre, author, availableCopies, totalCopies);
    }
}
