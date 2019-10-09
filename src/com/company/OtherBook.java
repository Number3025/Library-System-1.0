package com.company;

public class OtherBook extends LibraryItem implements Add,Remove,Comparable<Book> {
    OtherBook(String title, String date, String id, String author) {
        super(id, title, date, author);
    }

    @Override
    void displayGreetingMessage() {

    }

    @Override
    public void Add() {

    }

    @Override
    public void remove() {

    }


    @Override
    public int compareTo (Book otherBook) {
        return title.compareTo(otherBook.title);
    }
}

