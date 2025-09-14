package com.lumera.wordsearch.rules;

import com.lumera.wordsearch.Rule;

public final class MaxLengthRule implements Rule {

    private final int max;

    public MaxLengthRule(int max) {
    	this.max = max;
    }

    @Override
    public boolean test(String word) {
    	return word.length() <= max;
    }
}
