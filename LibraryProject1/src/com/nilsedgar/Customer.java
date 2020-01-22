package com.nilsedgar;

import java.util.ArrayList;

public class Customer extends User{

    transient public ArrayList<Book> borrowedBooks = new ArrayList<>();

    public Customer(String name, String password) {
        super(name, password);
    }

}


