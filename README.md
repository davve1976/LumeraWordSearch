# Lumera Word Search (Java/Maven)

Command-line tool that searches `wordlist.txt` (bundled in resources) using AND-combined rules.

## Requirements
- JDK **21+** (tested on JDK 22)
- Maven **3.9+**

## Build
```bash
mvn clean install
```
Produces: target/wordsearch-1.0.0.jar

## Run with maven
```bash
# from project root
mvn -q exec:java -Dexec.args="class=palindrome maxlength=8"
```
-q = quiet mode (omit it for more logs)

## Run with runnable JAR
```bash
java -jar target/wordsearch-1.0.0.jar class=palindrome maxlength=8
```

## Usage
```bash
Supported rules (all ANDed, case-insensitive):

class={isogram|palindrome|semordnilap}
maxlength=<INT>
minlength=<INT>
startswith=<head>
endswith=<tail>
containsonly=<characters>
```

## Examples
```bash
class=palindrome maxlength=8
maxlength=3 minlength=3
endswith=abc endswith=bca
startswith=ba
containsonly=abcde
```

## Test
```bash
mvn test
```
