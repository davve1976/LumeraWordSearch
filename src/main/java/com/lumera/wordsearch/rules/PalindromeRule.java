package com.lumera.wordsearch.rules;

import com.lumera.wordsearch.Rule;

public final class PalindromeRule implements Rule {

    @Override
    public boolean test(String word) {
        
        String normalizedWord = word.toLowerCase();
        int leftIndex = 0;
        int rightIndex = normalizedWord.length() - 1;
        
        while (leftIndex < rightIndex) {
            if (normalizedWord.charAt(leftIndex++) != normalizedWord.charAt(rightIndex--)) {
                return false;
            }
        }
        return true;
    }
}