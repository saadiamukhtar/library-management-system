package com.library.management.system;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationManager implements Subject {

    private Map<Book, List<Observer>> observers= new HashMap<>();

    @Override
    public void addObserver(Book book, Observer observer) {
        if (!observers.containsKey(book)) {
            observers.put(book, new ArrayList<>());
        }

        observers.get(book).add(observer);
    }

    @Override
    public void removeObserver(Book book, Observer observer) {
        List<Observer> bookObservers = observers.get(book);

        if (bookObservers != null) {
            bookObservers.remove(observer);
        }
    }

    @Override
    public void notifyObservers(Book book, String message) {

        List<Observer> bookObservers = observers.get(book);

        if (bookObservers != null) {
            for (Observer observer : bookObservers) {
                observer.notifyChannel(message);
            }
        }
        observers.remove(book);
    }
}