package com.pigraph.stemmer.data;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<String, String>
{
	private static final long serialVersionUID = 1L;
	private int defaultSize;
	
	public LRUCache(int size)
	{
		super(size, 0.75f, true);
		this.defaultSize = size;
	}
	
	@Override
	protected boolean removeEldestEntry(Map.Entry<String, String> entry)
	{
		return size() > defaultSize;
	}
}
