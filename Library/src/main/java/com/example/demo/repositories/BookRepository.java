package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.User;
import com.example.demo.models.Book;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    //@Transactional
    Book findBookBySerialNumber(String serialNumber);

    //@Transactional
    int deleteBookBySerialNumber(String serialNumber);
}
