package com.lumera.wordsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public final class WordList {

	private WordList() {
	}

	public static List<String> loadFromResource(String resourcePath) throws IOException {

		var in = WordList.class.getClassLoader().getResourceAsStream(resourcePath);

		if (in == null) {
			throw new IOException("Resource not found: " + resourcePath);
		}

		try (var reader = new BufferedReader(new InputStreamReader(in))) {
			return reader.lines()
					.map(String::trim)
					.filter(s -> !s.isEmpty())
					.toList();
		}
	}
}
