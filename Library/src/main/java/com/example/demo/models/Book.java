package com.example.demo.models;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book{
    @Id
    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "num_of_pages")
    private int numOfPages;

    @Column(name = "genre")
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(name = "author")
    private String author;

    @Column(name = "available_copies")
    private int availableCopies;

    @Column(name = "total_copies")
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
