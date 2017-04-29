package com.fernandomeyer.stemmer;


import java.util.Collection;
import java.util.HashSet;

import com.fernandomeyer.stemmer.data.LRUCache;
import com.fernandomeyer.stemmer.implementation.OrengoStemmer;
import com.fernandomeyer.stemmer.implementation.PTStemmerException;


public abstract class Stemmer {

	private boolean cacheStems;
	private LRUCache lruCache;

	private HashSet<String> toIgnore = new HashSet<String>();

	public enum StemmerType{ORENGO};

	/**
	 * Stemmer construction factory
	 * @param stype
	 * @return
	 * @throws PTStemmerException 
	 */
	public static Stemmer StemmerFactory(StemmerType stype)
	{
		switch (stype) {
		default:
		    try {
			return new OrengoStemmer();
		    } catch (PTStemmerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
		}
		return null;
	}

	/**
	 * Create a LRU Cache, caching the last <code>size</code> stems
	 * @param size
	 */
	public void enableCaching(int size)
	{
		cacheStems = true;
		lruCache = new LRUCache(size);
	}

	/**
	 * Disable and delete the LRU Cache
	 */
	public void disableCaching()
	{
		cacheStems = false;
		lruCache = null;
	}

	/**
	 * Check if LRU Cache is enabled
	 * @return
	 */
	public boolean isCachingEnabled()
	{
		return cacheStems;
	}

	/**
	 * Add list of words to ignore list
	 * @param words
	 */
	public void ignore(String... words)
	{
		for(String word: words)
			toIgnore.add(word);
	}

	/**
	 * Add Collection of words to ignore list
	 * @param words
	 */
	public void ignore(Collection<String> words)
	{
		toIgnore.addAll(words);
	}

	/**
	 * Clear the contents of the ignore list
	 */
	public void clearIgnoreList()
	{
		toIgnore.clear();
	}

	/**
	 * Performs stemming on the <code>phrase</code>, using a simple space tokenizer
	 * @param phrase
	 * @return
	 */
	public String[] getPhraseStems(String phrase)
	{
		String[] res = phrase.split(" ");
		for(int i=0; i<res.length; i++)
			res[i] = getWordStem(res[i]);
		return res;
	}

	/**
	 * Performs stemming on the <code>word</code>
	 * @param word
	 * @return
	 */
	public String getWordStem(String word)
	{
		String res;
		word = word.trim().toLowerCase();

		if(cacheStems)
			if(lruCache.containsKey(word))
				return lruCache.get(word);

		if(toIgnore.contains(word))
			return word;
		
		res = stemming(word);

		if(cacheStems)
			lruCache.put(word, res);
		return res;
	}

	protected abstract String stemming(String word);
}
