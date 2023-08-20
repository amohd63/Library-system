package com.example.demo.controllers;

import com.example.demo.models.Book;
import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    public BookService service;

    public BookController() {
    }

    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
    public List<Book> getLibraryBooks() {
        return service.getAllBooks();
    }

    @PostMapping
    public String addBook(@RequestBody Book book) {
        return service.addBook(book);
    }

    @GetMapping(params = "serialNumber")
    public Resource<Book> findBook(@RequestParam String serialNumber) {
        Book book = service.findBook(serialNumber);
        Resource<Book> resource = new Resource<Book>(book);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getLibraryBooks());
        resource.add(linkTo.withRel("all-students"));
        return resource;
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book) {
        return service.updateBook(book);
    }

    @DeleteMapping(params = "serialNumber")
    public int deleteBook(@RequestParam String serialNumber) {
        return service.deleteBook(serialNumber);
    }
}
