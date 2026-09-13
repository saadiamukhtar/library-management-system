package com.library.management.system;

import java.time.LocalDate;

public class BorrowingHistory {
    public Book getBook() {
        return book;
    }

    public Patron getPatron() {
        return patron;
    }

    public LocalDate getBorrowedAt() {
        return borrowedAt;
    }

    public LocalDate getReturnedAt() {
        return returnedAt;
    }

    public BorrowingHistory(Book book, Patron patron, LocalDate borrowedAt) {
        this.book = book;
        this.patron = patron;
        this.borrowedAt = borrowedAt;

    }
    public void markReturned(LocalDate returnedAt) {
        if (this.returnedAt != null) {
            throw new BookAlreadyReturnedException("Book has already been returned");
        }

        this.returnedAt = returnedAt;
    }

    private Book book;
    private Patron patron;
    private LocalDate borrowedAt;


    private LocalDate returnedAt;
}
