package com.example.demo.models.Book;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@DiscriminatorValue("Other")
public class Other extends Book implements BookStrategy{
    @Override
    public void implementBook() {

    }
}
