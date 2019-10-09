package com.company;

import java.util.Comparator;

public class SortAudioBookTitle implements Comparator<AudioBook> {


    @Override
    public int compare(AudioBook ab1, AudioBook ab2) {
        return ab1.getTitle().compareTo(ab2.getTitle());
    }
}

