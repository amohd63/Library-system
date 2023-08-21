package com.example.demo.models.Book;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@DiscriminatorValue("ReferencesEncyclopedias")
public class ReferencesEncyclopedia extends Book implements BookStrategy{
    @Override
    public void implementBook() {

    }
}
