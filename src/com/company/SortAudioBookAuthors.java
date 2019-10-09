package com.company;

import java.util.Comparator;

public class SortAudioBookAuthors implements Comparator<AudioBook> {


    @Override
    public int compare(AudioBook ab1, AudioBook ab2) {
        return ab1.getAuthor().compareTo(ab2.getAuthor());
    }
}
