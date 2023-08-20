package com.example.demo.repositories;

import com.example.demo.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    //@Transactional
    Book findBookBySerialNumber(String serialNumber);

    //@Transactional
    int deleteBookBySerialNumber(String serialNumber);
}
