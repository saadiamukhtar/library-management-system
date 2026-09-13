package com.library.management.system;

import java.util.ArrayList;
import java.util.List;

public class SearchByISBN implements  SearchStrategy{
    @Override
    public List<Book> search(List<Book> books, String ISBN){
        List<Book> result= new ArrayList<>();
        for(Book book: books){
            if(ISBN.equalsIgnoreCase(book.getISBN())){
                result.add(book);

            }
            return result;
        }

        throw new BookNotFoundException("NO such book exist");
    }
}
