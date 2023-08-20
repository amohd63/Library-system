package com.example.demo.models;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "books")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Book{
    @Id
    @Column(name = "serialNumber")
    private String serialNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "numOfPages")
    private int numOfPages;

    @Column(name = "genre")
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(name = "author")
    private String author;

    @Column(name = "availableCopies")
    private int availableCopies;

    @Column(name = "totalCopies")
    private int totalCopies;

    public Book(String serialNumber, String name, int numOfPages, String genre, String author, int availableCopies, int totalCopies) {
        super();
        this.serialNumber = serialNumber;
        this.name = name;
        this.numOfPages = numOfPages;
        this.genre = Genre.valueOf(genre);
        this.author = author;
        this.availableCopies = availableCopies;
        this.totalCopies = totalCopies;
    }
}
