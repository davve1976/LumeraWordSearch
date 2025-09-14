package com.lumera.wordsearch;

@FunctionalInterface
public interface Rule {

    boolean test(String word);

}
