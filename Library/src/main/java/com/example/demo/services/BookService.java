package com.example.demo.services;

import com.example.demo.models.Book.Book;
import com.example.demo.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
	@Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public String addBook(Book book) {
        if (bookRepository.existsById(book.getSerialNumber())) {
            return "Book already in the database!";
        }
        bookRepository.save(book);
        return "Book added successfully!";
    }

    @Transactional
    public Book findBook(String serialNumber) {
        return bookRepository.findBookBySerialNumber(serialNumber);
    }

    public Book updateBook(Book book) {
        Book bookObj = bookRepository.findBookBySerialNumber(book.getSerialNumber());
        if (bookObj == null){
            return null;
        }
        return bookRepository.save(book);
    }

    public int deleteBook(String serialNumber) {
        return bookRepository.deleteBookBySerialNumber(serialNumber);
    }
}
