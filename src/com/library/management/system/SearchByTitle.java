package com.library.management.system;

import java.util.ArrayList;
import java.util.List;

public class SearchByTitle implements SearchStrategy {

    @Override
    public List<Book> search(List<Book> books, String title) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (title.equalsIgnoreCase(book.getTitle())) {
                result.add(book);
            }
        }

        if (result.isEmpty()) {
            throw new BookNotFoundException("No such book exists");
        }

        return result;
    }
}
