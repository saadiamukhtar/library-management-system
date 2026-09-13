package com.library.management.system;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {

    List<Book> books= new ArrayList<>();
    List<Patron> members= new ArrayList<>();

    private SearchStrategy searchStrategy;
    private NotificationManager notificationManager;
    public Library(NotificationManager notificationManager) {
        this.notificationManager = notificationManager;
    }
    public void addPatrons(Patron patron){
        members.add(patron);
    }
    public void addBooks(Book book){
        books.add(book);
    }
    public void removeBook(Book book){
        books.remove(book);

    }
    public List<Book> search(SearchStrategy strategy, String searchValue) {
        return strategy.search(books, searchValue);
    }
    public void updateBook(String ISBN, String newTitle, String newAuthor, int newPublicationYear) {
        searchStrategy= SearchStrategyFactory.create(SearchType.ISBN);
        List<Book> result = search(searchStrategy, ISBN);
        Book book = result.get(0);

        book.setTitle(newTitle);
        book.setAuthor(newAuthor);
        book.setPublicationYear(newPublicationYear);
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
public void returnBook(Book book, Patron patron) {

    for (BorrowingHistory history : patron.getBorrowingHistoryList()) {

        if (history.getBook().getISBN().equalsIgnoreCase(book.getISBN())) {

            history.markReturned(LocalDate.now());
            book.makeAvailable();
            notificationManager.notifyObservers(book, book.getTitle()+ "is now Available. ");

            return;
        }
    }

    throw new BookNotFoundException(
            "This book was not borrowed by this patron"
    );
}






}
