package com.library.management.system;

public class Reservation {

    public Reservation(Book book, Patron patron) {
        this.book = book;
        this.patron = patron;
    }

    public Book getBook() {
        return book;
    }

    public Patron getPatron() {
        return patron;
    }

    private Book book;
    private Patron patron;

}