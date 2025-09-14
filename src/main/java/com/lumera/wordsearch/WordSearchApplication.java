package com.lumera.wordsearch;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordSearchApplication {

    public static void main(String[] args) {
        if (args.length == 0) {
            printUsage();
            return;
        }

        try {
            List<String> words = WordList.loadFromResource("wordlist.txt");
            Set<String> wordSet = words.stream().collect(Collectors.toSet());

            Query query = RuleParser.parse(args, wordSet);

            List<String> matches = words.stream()
                    .filter(query::matches)
                    .sorted(Comparator.comparing(String::length).thenComparing(String::compareToIgnoreCase))
                    .toList();

            matches.forEach(System.out::println);
            System.out.printf("%n%d match(es).%n", matches.size());
        } catch (InvalidQueryException e) {
            System.err.println("Invalid query: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Failed to read wordlist.txt: " + e.getMessage());
        }
    }

    private static void printUsage() {
        System.out.println("""
            Word Search - Lumera assignment (Java)
            
            Usage examples:
              mvn -q exec:java -Dexec.args="class=palindrome maxlength=8"
              mvn -q exec:java -Dexec.args="maxlength=3 minlength=3"
              mvn -q exec:java -Dexec.args="startswith=ba"
              mvn -q exec:java -Dexec.args="containsonly=abcde"
              
            Supported rules (ANDed):
              class={isogram|palindrome|semordnilap}
              maxlength=<INT>
              minlength=<INT>
              startswith=<head>
              endswith=<tail>
              containsonly=<characters>
            """);
    }
}
