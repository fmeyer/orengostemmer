package com.fernandomeyer.stemmer.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.fernandomeyer.stemmer.data.SuffixTree;



public abstract class XMLUtils {
	
	public static void setProperty(SuffixTree<?> tree, String propertyName, Integer defaultValue, Element element)
	{
		try
		{
			int value = Integer.parseInt(element.getAttribute(propertyName));
			tree.setProperty(propertyName, value);
		}catch (Exception e) {
			tree.setProperty(propertyName, defaultValue);
		}
	}

	public static Collection<Element> getChilds(Element e)
	{
		List<Element> childs = new ArrayList<Element>();
		if(e == null)
			return childs;

		NodeList cnodes = e.getChildNodes();
		for(int i=0; i< cnodes.getLength(); i++)
		{
			Node cnode = cnodes.item(i);
			if(cnode instanceof Element)
			{
				Element child = (Element)cnode;
				childs.add(child);
			}
		}
		return childs;
	}
}
