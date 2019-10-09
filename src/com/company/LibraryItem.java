package com.company;

abstract class LibraryItem {
    String id;
    String title;
    String date;
    String author;

    LibraryItem(String id, String title, String date, String author) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.author = author;
    }

    abstract void displayGreetingMessage();
}

