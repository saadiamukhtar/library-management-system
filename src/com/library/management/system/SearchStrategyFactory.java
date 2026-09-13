package com.library.management.system;

public class SearchStrategyFactory {

    public static SearchStrategy create(SearchType searchType) {

        switch (searchType) {
            case TITLE:
                return new SearchByTitle();

            case AUTHOR:
                return new SearchByAuthor();

            case ISBN:
                return new SearchByISBN();

            default:
                throw new IllegalArgumentException("Invalid search type");
        }
    }
}