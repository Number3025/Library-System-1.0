package com.company;

import java.io.Serializable;

abstract class LibraryItem implements Serializable {
    private String id;
    private String title;
    private String date;
    private String author;


    /**
     * @param id     The code for this specific book
     * @param title  title The name of the book
     * @param date   the date the book was published
     * @param author the person who wrote the book
     */
    LibraryItem(String id, String title, String date, String author) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.author = author;

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

    abstract void displayGreetingMessage();


}

