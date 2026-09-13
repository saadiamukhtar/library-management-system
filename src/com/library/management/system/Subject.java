package com.library.management.system;

public interface Subject {

    void addObserver(Book book, Observer observer);

    void removeObserver(Book book, Observer observer);

    void notifyObservers(Book book, String message);
}