package com.lumera.wordsearch;

import com.lumera.wordsearch.rules.*;

import java.util.Locale;
import java.util.Set;

public final class RuleParser {

    private RuleParser() {
    }

    public static Query parse(String[] arguments, Set<String> dictionary) throws InvalidQueryException {

        Query query = new Query();

        for (String argument : arguments) {
            int equalsIndex = argument.indexOf('=');
            if (equalsIndex <= 0 || equalsIndex == argument.length() - 1) {
                throw new InvalidQueryException("Expected key=value but got: " + argument);
            }

            String ruleName = argument.substring(0, equalsIndex).trim().toLowerCase(Locale.ROOT);
            String ruleValue = argument.substring(equalsIndex + 1).trim();

            switch (ruleName) {
                case "maxlength"    -> query.add(new MaxLengthRule(parseInt(ruleValue, "maxlength")));
                case "minlength"    -> query.add(new MinLengthRule(parseInt(ruleValue, "minlength")));
                case "startswith"   -> query.add(new StartsWithRule(ruleValue));
                case "endswith"     -> query.add(new EndsWithRule(ruleValue));
                case "containsonly" -> query.add(new ContainsOnlyRule(ruleValue));
                case "class" -> {
                    String className = ruleValue.toLowerCase(Locale.ROOT);
                    switch (className) {
                        case "palindrome"  -> query.add(new PalindromeRule());
                        case "isogram"     -> query.add(new IsogramRule());
                        case "semordnilap" -> query.add(new SemordnilapRule(dictionary));
                        default -> throw new InvalidQueryException("Unknown class: " + ruleValue);
                    }
                }
                default -> throw new InvalidQueryException("Unknown rule: " + ruleName);
            }
        }
        return query;
    }

    private static int parseInt(String value, String name) throws InvalidQueryException {
        try {
            int number = Integer.parseInt(value);
            if (number < 0) {
            	throw new NumberFormatException();
            }
            return number;
        } catch (NumberFormatException e) {
            throw new InvalidQueryException(name + " must be a non-negative integer");
        }
    }
}
