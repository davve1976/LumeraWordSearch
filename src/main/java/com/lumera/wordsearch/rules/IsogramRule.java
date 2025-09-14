package com.lumera.wordsearch.rules;

import com.lumera.wordsearch.Rule;

public final class IsogramRule implements Rule {

    @Override
    public boolean test(String word) {
    	
        var seen = new boolean[Character.MAX_VALUE + 1];
        var normalizedWord = word.toLowerCase();
        
        for (int i = 0; i < normalizedWord.length(); i++) {
            char c = normalizedWord.charAt(i);
            if (seen[c]) {
            	return false;
            }
            seen[c] = true;
        }
        return true;
    }
}
