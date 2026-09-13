package com.library.management.system;

import java.time.LocalDateTime;

public class Book {
    private String title;
    private String author;
    private String ISBN;

    public BookStatus getStatus() {
        return status;
    }

    private BookStatus status;

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    private int publicationYear;

    public Book(String title, String author, String ISBN, int publicationYear) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public void borrow() {
        status = BookStatus.BORROWED;
    }
    public void makeAvailable() {
        status = BookStatus.AVAILABLE;
    }

}
