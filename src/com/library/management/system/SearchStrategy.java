package com.library.management.system;

import java.util.List;

public interface SearchStrategy {
    List<Book> search(List<Book> books, String searchValue);
}
