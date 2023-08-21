package com.example.demo.controllers;

import com.example.demo.models.Book.Book;
import com.example.demo.models.Book.RegularBook;
import com.example.demo.repositories.BookRepository;
import com.example.demo.services.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DataJpaTest
@AutoConfigureMockMvc
@WebMvcTest
public class BookControllerTest {

    @Mock
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;
    //
    @InjectMocks
    private BookController bookController;

    @Autowired
    private MockMvc mockMvc;

    private Book book1;
    private Book book2;
    private Book book3;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @BeforeEach
    public void fillData() {
        book1 = new RegularBook("SN123", "The Great Novel", 300, "NOVEL", "Author A", 5, 10);
        book2 = new RegularBook("SN456", "Science Explained", 250, "SCIENCE", "Author B", 3, 5);
        book3 = new RegularBook("SN789", "Fiction Adventures", 400, "FICTION", "Author C", 7, 7);
    }

    @Test
    public void getLibraryBooks_success() throws Exception {
        List<Book> list = new ArrayList<>();
        list.add(book1);
        list.add(book2);
        list.add(book3);

        when(bookController.getLibraryBooks()).thenReturn(list);

        this.mockMvc.perform(get("/book"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(list.size())));
    }
}
