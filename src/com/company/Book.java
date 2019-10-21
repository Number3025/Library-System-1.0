package com.company;

import java.io.Serializable;
import java.util.Comparator;


public class Book extends LibraryItem implements Add, Remove, Comparable<Book>, Serializable {
    Book(String title, String date, String id, String author) {
        super(id, title, date, author);
        this.id = id;
        this.author = author;
        this.date = date;
        this.title = title;

    }



    public int compareTo(Book otherBook) {
        return author.compareTo(otherBook.author);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    void displayGreetingMessage() {
        System.out.println("What Book to add Master?");
        return;
    }

    @Override
    public void Add() {

    }

    @Override
    public void remove() {

    }
}









