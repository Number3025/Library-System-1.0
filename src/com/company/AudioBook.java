package com.company;

import java.io.Serializable;

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
    void displayGreetingMessage() {
        System.out.println("What Audiobook too add Master?");
        return;
    }


}




