package com.example.demo.controllers;

import com.example.demo.models.Borrow;
import com.example.demo.services.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrow")
public class BorrowController {
    @Autowired
    BorrowService service;

    @GetMapping(params = "userID")
    public List<Borrow> getUserBorrowHistory(@RequestParam Integer userID) {
        return service.getUserBorrowHistory(userID);
    }

    @PostMapping(params = {"userID", "serialNumber"})
    public String borrowBook(@RequestParam Integer userID, @RequestParam String serialNumber) {
        return service.borrowBook(userID, serialNumber);
    }

    @PutMapping(params = {"userID", "serialNumber"})
    public String extendBorrow(@RequestParam Integer userID, @RequestParam String serialNumber) {
        return service.extendBorrow(userID, serialNumber);
    }

    @DeleteMapping(params = {"userID", "serialNumber"})
    public int deleteBorrow(@RequestParam Integer userID, @RequestParam String serialNumber) {
        return service.deleteBorrow(userID, serialNumber);
    }
}
