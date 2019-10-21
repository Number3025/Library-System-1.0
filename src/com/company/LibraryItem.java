package com.company;

import java.io.Serializable;

abstract class LibraryItem implements Serializable {
    String id;
    String title;
    String date;
    String author;

    /**
     *
     * @param id The code for this specific book
     * @param title title The name of the book
     * @param date the date the book was published
     * @param author the person who wrote the book
     */
    LibraryItem(String id, String title, String date, String author) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.author = author;
    }

    abstract void displayGreetingMessage();


}

