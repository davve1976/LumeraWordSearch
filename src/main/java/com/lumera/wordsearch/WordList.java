package com.lumera.wordsearch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class for loading the wordlist.
 */
public final class WordList {

    private WordList() {}

    public static List<String> load(String filename) throws IOException {
        return Files.lines(Path.of(filename))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toList());
    }
}
