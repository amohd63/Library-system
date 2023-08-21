package com.example.demo.services;

import com.example.demo.models.Borrow.Borrow;
import com.example.demo.repositories.BorrowRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@DataJpaTest
@AutoConfigureMockMvc
@WebMvcTest
public class BorrowServiceTests {

    @Mock
    private BorrowRepository borrowRepository;

    @InjectMocks
    private BorrowService borrowService;

    private List<Borrow> borrowHistory;
    private Borrow borrow;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    public void fillData() {
        borrowHistory = new ArrayList<>();
        borrow = new Borrow(1, 1, "SN123", Date.valueOf("2023-04-01"), Date.valueOf("2023-04-08"));
        borrowHistory.add(borrow);
    }

    @Test
    public void getUserBorrowHistory_success() {
        when(borrowService.getUserBorrowHistory(borrow.getUserID())).thenReturn(borrowHistory);
        List<Borrow> borrowList = borrowService.getUserBorrowHistory(borrow.getUserID());
        assertNotNull(borrowList);
        assertThat(borrowList.size()).isEqualTo(borrowHistory.size());
    }
}