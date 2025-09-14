package com.lumera.wordsearch;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RuleParserTest {

    private final List<String> sampleWords = List.of(
            "level", "deed", "banana", "live", "evil", "bad", "decade", "abc", "bca"
    );

    @Test
    void palindromeMaxLen() throws Exception {
        var query = RuleParser.parse(new String[]{"class=palindrome", "maxlength=5"}, Set.copyOf(sampleWords));
        var matchingWords = sampleWords.stream().filter(query::matches).toList();
        assertTrue(matchingWords.contains("level"));
        assertTrue(matchingWords.contains("deed"));
        assertFalse(matchingWords.contains("decade")); // length 6
    }

    @Test
    void exactLength() throws Exception {
        var query = RuleParser.parse(new String[]{"maxlength=3", "minlength=3"}, Set.copyOf(sampleWords));
        var matchingWords = sampleWords.stream().filter(query::matches).toList();
        assertTrue(matchingWords.contains("bad"));
        assertTrue(matchingWords.contains("abc"));
        assertTrue(matchingWords.contains("bca"));
        assertFalse(matchingWords.contains("live"));
    }

    @Test
    void semordnilap() throws Exception {
        var query = RuleParser.parse(new String[]{"class=semordnilap"}, Set.copyOf(sampleWords));
        var matchingWords = sampleWords.stream().filter(query::matches).toList();
        assertTrue(matchingWords.contains("live")); // reverse 'evil'
        assertTrue(matchingWords.contains("evil"));
        assertFalse(matchingWords.contains("level")); // palindrome is not semordnilap
    }

    @Test
    void containsOnly() throws Exception {
        var query = RuleParser.parse(new String[]{"containsonly=abcde"}, Set.copyOf(sampleWords));
        var matchingWords = sampleWords.stream().filter(query::matches).toList();
        assertTrue(matchingWords.contains("bad"));
        assertTrue(matchingWords.contains("decade"));
        assertFalse(matchingWords.contains("banana"));
    }
}
