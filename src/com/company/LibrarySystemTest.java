package com.company;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LibrarySystemTest {
    LibrarySystem librarySystem = new LibrarySystem("The archive");

    @org.junit.jupiter.api.Test
    void readObjects() {

    }

    @org.junit.jupiter.api.Test
    void readObjectss() {

    }

    @org.junit.jupiter.api.Test
    void writeObjects() {
        ArrayList<Book> books = LibrarySystem.getBooks();
        assertFalse(books.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void writeObjectss() {
        ArrayList<AudioBook> audioBooks = LibrarySystem.getAudiobooks();
        assertFalse(audioBooks.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void showMainMenu() {

    }
}