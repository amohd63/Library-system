package com.example.demo.models.Book;

import com.example.demo.models.Genre;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "books")
@DiscriminatorColumn(name = "dtype")
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = RegularBook.class, name = "book"),
        @JsonSubTypes.Type(value = Journal.class, name = "journal"),
        @JsonSubTypes.Type(value = ReferencesEncyclopedia.class, name = "references"),
        @JsonSubTypes.Type(value = Other.class, name = "other")
})
public abstract class Book implements BookStrategy{
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
