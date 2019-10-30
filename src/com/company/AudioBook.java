package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class AudioBook extends LibraryItem implements Comparable<AudioBook>, Serializable {
    private float lengthMinutes;

    AudioBook(String title, String date, String id, String author, float lengthMinutes) {
        super(id, title, date, author);
        this.setId(id);
        this.setAuthor(author);
        this.setDate(date);
        this.setTitle(title);
        this.lengthMinutes = lengthMinutes;

    }

    public float getLengthMinutes() {
        return lengthMinutes;
    }

    public int compareTo(AudioBook otherAudioBook) {
        return getAuthor().compareTo(otherAudioBook.getAuthor());
    }


    @Override
    void PrintInfo() {
        ArrayList<AudioBook> audioBooks = LibrarySystem.getAudiobooks();
        for (AudioBook audioBook : audioBooks) {
            System.out.println("Title: " + audioBook.getTitle() + " " + "Date: " + audioBook.getDate() + " " + "Id: " + audioBook.getId() + " " + "Author: " + audioBook.getAuthor() + " " + "Minutes: " + audioBook.getLengthMinutes());
    }
}


}




