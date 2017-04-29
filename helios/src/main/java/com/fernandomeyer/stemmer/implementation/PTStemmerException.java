package com.fernandomeyer.stemmer.implementation;

public class PTStemmerException extends Exception {
	private static final long serialVersionUID = -8308726135393629156L;

	public PTStemmerException(String message, Throwable cause)
	{
		super(message,cause);
	}
	
	public PTStemmerException(String message)
	{
		super(message);
	}
}
