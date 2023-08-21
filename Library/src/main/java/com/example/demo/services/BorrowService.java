package com.example.demo.services;

import com.example.demo.models.Book.*;
import com.example.demo.models.Borrow;
import com.example.demo.models.Subscription.PremiumSubscription;
import com.example.demo.models.Subscription.Subscription;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.BorrowRepository;
import com.example.demo.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class BorrowService {
    @Autowired
    BorrowRepository borrowRepository;
    @Autowired
    SubscriptionRepository subscriptionRepository;
    @Autowired
    BookRepository bookRepository;

    public List<Borrow> getUserBorrowHistory(Integer userID) {
        return borrowRepository.findBorrowByUserID(userID);
    }

    public String borrowBook(Integer userID, String serialNumber) {
        Subscription subscription = subscriptionRepository.findSubscriptionByUserID(userID);

        if (subscription.getEndDate().before(Date.valueOf(LocalDate.now()))) {
            return "Your subscription expired!";
        }

        if (borrowRepository.countBorrowByUserIDAndEndDateGreaterThanEqual(userID, Date.valueOf(LocalDate.now()))
                >= (subscription instanceof PremiumSubscription ? 4 : 1)) {
            return "You can't borrow more books";
        }

        Book book = bookRepository.findBookBySerialNumber(serialNumber);

        if (book == null) {
            return "Library doesn't have a book with serial number [" + serialNumber + "]";
        }

        Borrow borrow = new Borrow(userID, serialNumber);
        borrow.setStartDate(Date.valueOf(LocalDate.now()));

        if (borrowRepository.existsBorrowByUserIDAndSerialNumber(userID, serialNumber)) {
            borrow = borrowRepository.findBorrowByUserIDAndSerialNumber(userID, serialNumber);
            if (borrow.getEndDate().after(Date.valueOf(LocalDate.now()))) {
                return "You already borrowed the book!";
            } else if (borrow.getEndDate().equals(Date.valueOf(LocalDate.now()))) {
                return "You have to extend the borrow.";
            }
        }

        if (setBorrowEndDate(book, borrow)) {
            return "Book is not instance of supported types [regular book, journal, references encyclopedia, other";
        }

        borrowRepository.save(borrow);

        return "Borrowed the book successfully!";
    }

    public String extendBorrow(Integer userID, String serialNumber) {
        Subscription subscription = subscriptionRepository.findSubscriptionByUserID(userID);

        if (subscription.getEndDate().before(Date.valueOf(LocalDate.now()))) {
            return "Your subscription expired!";
        }

        if (borrowRepository.countBorrowByUserIDAndEndDateGreaterThanEqual(userID, Date.valueOf(LocalDate.now()))
                > (subscription instanceof PremiumSubscription ? 4 : 1)) {
            return "You can't borrow more books";
        }

        Book book = bookRepository.findBookBySerialNumber(serialNumber);

        if (book == null) {
            return "Library doesn't have a book with serial number [" + serialNumber + "]";
        }

        if (borrowRepository.existsBorrowByUserIDAndSerialNumber(userID, serialNumber)) {
            Borrow borrow = borrowRepository.findBorrowByUserIDAndSerialNumber(userID, serialNumber);
            if (borrow.getEndDate().after(Date.valueOf(LocalDate.now()))) {
                return "You already borrowed the book!";
            } else if (borrow.getEndDate().equals(Date.valueOf(LocalDate.now()))) {
                if (setBorrowEndDate(book, borrow)) {
                    return "Book is not instance of supported types [regular book, journal, references encyclopedia, other";
                }
                borrow.setStartDate(Date.valueOf(LocalDate.now()));
                borrowRepository.save(borrow);
                return "Borrowed the book successfully!";
            }
        }
        return "Extending process failed.";
    }

    private boolean setBorrowEndDate(Book book, Borrow borrow) {
        if (book instanceof Journal) {
            borrow.setEndDate(Date.valueOf(LocalDate.now().plusDays(3)));
        } else if (book instanceof Other) {
            borrow.setEndDate(Date.valueOf(LocalDate.now().plusDays(2)));
        } else if (book instanceof ReferencesEncyclopedia) {
            borrow.setEndDate(Date.valueOf(LocalDate.now().plusDays(14)));
        } else if (book instanceof RegularBook) {
            borrow.setEndDate(Date.valueOf(LocalDate.now().plusDays(7)));
        } else {
            return true;
        }
        return false;
    }

//    public String extendBorrow(Integer userID, String serialNumber) {
//        if (borrowRepository.existsBorrowByUserIDAndSerialNumber(userID, serialNumber)) {
//            Borrow borrow = borrowRepository.findBorrowByUserIDAndSerialNumber(userID, serialNumber);
//            if (borrow.getEndDate().equals(Date.valueOf(LocalDate.now()))) {
//                borrow.setStartDate(Date.valueOf(LocalDate.now()));
//                borrowRepository.saveAndFlush(borrow);
//                return "Borrow extended successfully!";
//            }
//        }
//        return "You have to borrow the book again!";
//    }

    public int deleteBorrow(Integer userID, String serialNumber) {
        return borrowRepository.deleteBorrowByUserIDAndSerialNumber(userID, serialNumber);
    }
}
