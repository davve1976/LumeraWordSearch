package com.lumera.wordsearch.rules;

import com.lumera.wordsearch.Rule;

public final class EndsWithRule implements Rule {

    private final String tail;

    public EndsWithRule(String tail) {
    	this.tail = tail.toLowerCase();
    }

    @Override
    public boolean test(String word) {
    	return word.toLowerCase().endsWith(tail);
    }
}
