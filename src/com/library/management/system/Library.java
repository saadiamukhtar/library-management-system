package com.library.management.system;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {

    List<Book> books= new ArrayList<>();
    List<Patron> members= new ArrayList<>();
    public void addPatrons(Patron patron){
        members.add(patron);
    }
    public void addBooks(Book book){
        books.add(book);
    }
    public void removeBook(Book book){
        books.remove(book);

    }
    public void updateBook(String ISBN, String newTitle, String newAuthor, int newPublicationYear) {

        Book book = searchBookByISBN(ISBN);

        book.setTitle(newTitle);
        book.setAuthor(newAuthor);
        book.setPublicationYear(newPublicationYear);
    }

    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (title.equalsIgnoreCase(book.getTitle())) {
                return book;
            }
        }
        throw new BookNotFoundException("No such book exists");
    }
    public List<Book> searchBookByAuthor(String author){
        List<Book> booksByAuthor= new ArrayList<>();
        for(Book book: books){
            if(author.equalsIgnoreCase(book.getAuthor())){
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }
    public Book searchBookByISBN(String ISBN){
        for(Book book: books){
            if(ISBN.equalsIgnoreCase(book.getISBN())){
               return book;
            }
        }
        throw new BookNotFoundException("NO such book exist");
    }

    public void checkOutBook(Book book, Patron patron) {
        if (book.getStatus() == BookStatus.AVAILABLE) {

            LocalDate borrowedAt = LocalDate.now();

            BorrowingHistory history =
                    new BorrowingHistory(book, patron, borrowedAt);

            patron.addBorrowingHistory(history);

            book.borrow();
        }
    }
//    public void returnBook(Book book, Patron patron){
//        List<BorrowingHistory> borrowingList= patron.getBorrowingHistoryList();
//        for(BorrowingHistory borrow: borrowingList){
//            if(book.getISBN().equalsIgnoreCase(borrow.getBook().getISBN())){
//                LocalDate returnedAt= LocalDate.now();
//
//            }
//            book.available();
//
//        }
//
//    }
public void returnBook(Book book, Patron patron) {

    for (BorrowingHistory history : patron.getBorrowingHistoryList()) {

        if (history.getBook().getISBN().equalsIgnoreCase(book.getISBN())) {

            history.markReturned(LocalDate.now());
            book.makeAvailable();

            return;
        }
    }

    throw new BookNotFoundException(
            "This book was not borrowed by this patron"
    );
}






}
