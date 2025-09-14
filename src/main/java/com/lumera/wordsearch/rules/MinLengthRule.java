package com.lumera.wordsearch.rules;

import com.lumera.wordsearch.Rule;

public final class MinLengthRule implements Rule {

    private final int min;

    public MinLengthRule(int min) {
    	this.min = min;
    }

    @Override
    public boolean test(String word) {
    	return word.length() >= min;
    }
}