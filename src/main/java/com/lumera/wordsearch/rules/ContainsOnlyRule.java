package com.lumera.wordsearch.rules;

import com.lumera.wordsearch.Rule;

public final class ContainsOnlyRule implements Rule {

    private final String allowedCharacters;

    public ContainsOnlyRule(String chars) {
        this.allowedCharacters = chars.toLowerCase();
    }

    @Override
    public boolean test(String word) {
        var normalizedWord = word.toLowerCase();
        for (int i = 0; i < normalizedWord.length(); i++) {
            if (allowedCharacters.indexOf(normalizedWord.charAt(i)) < 0) {
                return false;
            }
        }
        return true;
    }
}
