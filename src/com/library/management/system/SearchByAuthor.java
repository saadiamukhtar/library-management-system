package com.library.management.system;

import java.util.ArrayList;
import java.util.List;

public class SearchByAuthor implements SearchStrategy {
    @Override
    public List<Book> search(List<Book> books,String author){
        List<Book> booksByAuthor= new ArrayList<>();
        for(Book book: books){
            if(author.equalsIgnoreCase(book.getAuthor())){
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }
}
