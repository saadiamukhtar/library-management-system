package com.library.management.system;



import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Create books
        Book cleanCode = new Book(
                "Clean Code",
                "Robert C. Martin",
                "ISBN001",
                2008
        );

        Book effectiveJava = new Book(
                "Effective Java",
                "Joshua Bloch",
                "ISBN002",
                2018
        );

        // Create patrons
        Patron alice = new Patron(1, "Alice", "alice@gmail.com");
        Patron bob = new Patron(2, "Bob", "bob@gmail.com");

        // Create notification manager
        NotificationManager notificationManager =
                new NotificationManager();

        // Create library
        Library library = new Library(notificationManager);

        // Add books and patrons
        library.addBooks(cleanCode);
        library.addBooks(effectiveJava);

        library.addPatrons(alice);
        library.addPatrons(bob);

        // -------------------------------
        // SEARCH USING FACTORY + STRATEGY
        // -------------------------------

        SearchStrategy titleStrategy =
                SearchStrategyFactory.create(SearchType.TITLE);

        List<Book> booksByTitle =
                library.search(titleStrategy, "Clean Code");

        System.out.println("Books found: " + booksByTitle.size());

        // -------------------------------
        // UPDATE BOOK
        // -------------------------------

        library.updateBook(
                "ISBN001",
                "Clean Code - Updated",
                "Robert C. Martin",
                2008
        );

        System.out.println("Updated title: "
                + cleanCode.getTitle());

        // -------------------------------
        // CHECKOUT
        // -------------------------------

        library.checkOutBook(cleanCode, alice);

        System.out.println("Book status after checkout: "
                + cleanCode.getStatus());

        // -------------------------------
        // RESERVATION
        // -------------------------------

        ReservationService reservationService =
                new ReservationService(notificationManager);

        reservationService.reserve(cleanCode, bob);

        // -------------------------------
        // RETURN
        // -------------------------------

        library.returnBook(cleanCode, alice);

        System.out.println("Book status after return: "
                + cleanCode.getStatus());
    }
}