package com.lumera.wordsearch;

public final class InvalidQueryException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidQueryException(String message) {
    	super(message);
    }
}