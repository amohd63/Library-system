package com.example.demo.models.Book;

import com.example.demo.models.Genre;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@DiscriminatorValue("RegularBook")
public class RegularBook extends Book implements BookStrategy{
    @Override
    public void implementBook() {

    }
}
