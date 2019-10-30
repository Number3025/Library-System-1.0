package com.company;


import java.util.ArrayList;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {

        BooksRealaseDateList booksRealaseDateList = new BooksRealaseDateList();

        booksRealaseDateList.AddBooksToList();

        LibrarySystem librarySystem = new LibrarySystem("The archive");

        librarySystem.showMainMenu("The Archive");


    }

}