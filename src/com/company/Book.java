package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;


public class Book extends LibraryItem implements Comparable<Book>, Serializable {
    private int numberOfpages;

    Book(String title, String date, String id, String author, int numberOfpages) {
        super(id, title, date, author);
        this.setId(id);
        this.setAuthor(author);
        this.setDate(date);
        this.setTitle(title);
        this.numberOfpages = numberOfpages;
    }

    public int getNumberOfpages() {
        return numberOfpages;
    }


    //public void setNumberOfpages(int numberOfpages){
    //  this.numberOfpages = numberOfpages;
    //}


    public int compareTo(Book otherBook) {
        return getAuthor().compareTo(otherBook.getAuthor());
    }


    @Override
    void PrintInfo() {
        ArrayList<Book> books = LibrarySystem.getBooks();
        for (Book book : books) {
        System.out.println("Title: " + book.getTitle() + " " + "Date: " + book.getDate() + " " + "Id: " + book.getId() + " " + "Author: " + book.getAuthor() + " " + "Pages: " + book.getNumberOfpages());
        }
}}









