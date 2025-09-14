package com.lumera.wordsearch;

import java.io.IOException;
import java.util.List;

public class WordSearchApplication {
    public static void main(String[] args) {
        try {
            List<String> words = WordList.load("wordlist.txt");
            System.out.println("Loaded " + words.size() + " words.");

            // TODO: implement search logic later
        } catch (IOException e) {
            System.err.println("Could not read wordlist.txt: " + e.getMessage());
        }
    }
}
