package com.library.management.system;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Patron {
    public int getPatronId() {
        return patronId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<BorrowingHistory> getBorrowingHistoryList() {
        return Collections.unmodifiableList(borrowingHistoryList);
    }
    public void addBorrowingHistory(BorrowingHistory history){
        borrowingHistoryList.add(history);
    }


    public Patron(int patronId, String name, String email) {
        this.patronId = patronId;
        this.name = name;
        this.email = email;

    }

    private int patronId;
    private String name;
    private String email;
    private List<BorrowingHistory> borrowingHistoryList= new ArrayList<>();




}
