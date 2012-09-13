package com.pigraph.stemmer.data;

import java.util.HashMap;

public class SuffixTreeNode<T> {

	private HashMap<Character, SuffixTreeNode<T>> edges;
	private T value;
	
	public SuffixTreeNode()
	{
		edges = new HashMap<Character, SuffixTreeNode<T>>(26);
	}
	
	public SuffixTreeNode(T value)
	{
		edges = new HashMap<Character, SuffixTreeNode<T>>(26);
		this.value = value;
	}
	
	/**
	 * Add edge to node
	 * @param c
	 * @param value
	 * @return
	 */
	public SuffixTreeNode<T> addEdge(char c, T value)
	{
		SuffixTreeNode<T> node = edges.get(c);
		if(node == null)
		{
			node = new SuffixTreeNode<T>(value);
			edges.put(c, node);
		}
		return node;
	}
	
	public SuffixTreeNode<T> getEdge(char c)
	{
		return edges.get(c);
	}
	
	public T getValue()
	{
		return value;
	}
	
	public void setValue(T value)
	{
		this.value = value;
	}	
	
	public String toString()
	{
		return "["+value+"]";
	}
}
