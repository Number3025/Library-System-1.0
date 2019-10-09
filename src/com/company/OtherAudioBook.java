package com.company;

public class OtherAudioBook extends LibraryItem implements Add,Remove,Comparable<AudioBook> {
    OtherAudioBook(String title, String date, String id, String author) {
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
    public int compareTo (AudioBook otherAudioBook) {
        return title.compareTo(otherAudioBook.title);
    }
}
