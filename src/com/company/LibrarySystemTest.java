package com.company;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LibrarySystemTest {

    public ArrayList<Book> books = LibrarySystem.getBooks();
    public ArrayList<AudioBook> audioBooks = LibrarySystem.getAudiobooks();
    @org.junit.jupiter.api.Test
    void readObjects() {

    }

    @org.junit.jupiter.api.Test
    void readObjectss() {

    }

    @org.junit.jupiter.api.Test
    void writeObjects() {

        assertNotNull(books);
    }

    @org.junit.jupiter.api.Test
    void writeObjectss() {

        assertNotNull(audioBooks);
    }

    @org.junit.jupiter.api.Test
    void showMainMenu() {

    }
}