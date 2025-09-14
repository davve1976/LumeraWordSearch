package com.lumera.wordsearch.rules;

import com.lumera.wordsearch.Rule;

public final class StartsWithRule implements Rule {

    private final String head;

    public StartsWithRule(String head) {
    	this.head = head.toLowerCase();
    }

    @Override
    public boolean test(String word) {
    	return word.toLowerCase().startsWith(head);
    }
}