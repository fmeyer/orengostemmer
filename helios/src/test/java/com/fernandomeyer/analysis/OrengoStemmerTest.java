package com.fernandomeyer.analysis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.solr.common.ResourceLoader;
import org.apache.solr.core.SolrResourceLoader;
import org.junit.Test;

public class OrengoStemmerTest {

    @Test
    public void testInform() throws Exception {
	ResourceLoader loader = new SolrResourceLoader(null, null);
//	assertTrue("loader is null and it shouldn't be", loader != null);
	OrengoStemmerFilterFactory factory = new OrengoStemmerFilterFactory();
	Map<String, String> args = new HashMap<String, String>();
	args.put("exceptionList", "stop-1.txt");
	args.put("ignoreCase", "true");
//	factory.setLuceneMatchVersion(TEST_VERSION_CURRENT);
	factory.init(args);
	factory.inform(loader);
	List<String> words = factory.getStemmerIgnoreList();
		
//	assertTrue("words is null and it shouldn't be", words != null);
//	assertTrue("words Size: " + words.size() + " is not: " + 2, words.size() == 2);
//	assertTrue(factory.isIgnoreCase() + " does not equal: " + true, factory.isIgnoreCase() == true);
//
//	factory = new StopFilterFactory();
//	args.put("words", "stop-1.txt, stop-2.txt");
//	factory.setLuceneMatchVersion(TEST_VERSION_CURRENT);
//	factory.init(args);
//	factory.inform(loader);
//	words = factory.getStopWords();
//	assertTrue("words is null and it shouldn't be", words != null);
//	assertTrue("words Size: " + words.size() + " is not: " + 4,
//		words.size() == 4);
//	assertTrue(factory.isIgnoreCase() + " does not equal: " + true,
//		factory.isIgnoreCase() == true);
//
//	factory = new StopFilterFactory();
//	factory.setLuceneMatchVersion(TEST_VERSION_CURRENT);
//	args.put("words", "stop-snowball.txt");
//	args.put("format", "snowball");
//	factory.init(args);
//	factory.inform(loader);
//	words = factory.getStopWords();
//	assertEquals(8, words.size());
//	assertTrue(words.contains("he"));
//	assertTrue(words.contains("him"));
//	assertTrue(words.contains("his"));
//	assertTrue(words.contains("himself"));
//	assertTrue(words.contains("she"));
//	assertTrue(words.contains("her"));
//	assertTrue(words.contains("hers"));
//	assertTrue(words.contains("herself"));
    }
}
