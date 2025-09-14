package com.lumera.wordsearch.rules;

import com.lumera.wordsearch.Rule;

import java.util.Set;

public final class SemordnilapRule implements Rule {

    private final Set<String> dictionaryLower;

    public SemordnilapRule(Set<String> dict) {
        this.dictionaryLower = dict.stream().map(String::toLowerCase).collect(java.util.stream.Collectors.toSet());
    }

    @Override
    public boolean test(String word) {
        var normalizedWord = word.toLowerCase();
        var reversed = new StringBuilder(normalizedWord).reverse().toString();
        return !normalizedWord.equals(reversed) && dictionaryLower.contains(reversed);
    }
}
