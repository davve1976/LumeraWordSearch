package com.lumera.wordsearch;

import java.util.ArrayList;
import java.util.List;

public final class Query {

    private final List<Rule> rules = new ArrayList<>();

    public void add(Rule rule) {
    	rules.add(rule);
    }

    public boolean matches(String word) {
        for (Rule rule : rules) { 
        	if (!rule.test(word)) {
        		return false;
        	}
        }
        return true;
    }
}
