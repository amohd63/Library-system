package com.example.demo.models.Book;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class BookContext {
    private BookStrategy bookStrategy;

    public void executeStrategy() {
        bookStrategy.implementBook();
    }
}
