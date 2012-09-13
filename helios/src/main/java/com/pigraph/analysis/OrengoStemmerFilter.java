package com.pigraph.analysis;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.KeywordAttribute;

import com.pigraph.stemmer.Stemmer;

public class OrengoStemmerFilter extends TokenFilter {

    private Stemmer stemmer;
    
    private Set<?> exclusions = null;
    private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
    private final KeywordAttribute keywordAttr = addAttribute(KeywordAttribute.class);
    
    public OrengoStemmerFilter(TokenStream in, List<String> stemmerExceptionIgnoreList) {
	super(in);
	 stemmer = Stemmer.StemmerFactory(Stemmer.StemmerType.ORENGO);
	 stemmer.ignore(stemmerExceptionIgnoreList);
    }

    @Override
    public boolean incrementToken() throws IOException {
	if (input.incrementToken()) {
	    final String term = termAtt.toString();
	    // Check the exclusion table.
	    if (!keywordAttr.isKeyword()
		    && (exclusions == null || !exclusions.contains(term))) {
		final String s = stemmer.getWordStem(term);
		// If not stemmed, don't waste the time adjusting the token.
		if ((s != null) && !s.equals(term))
		    termAtt.setEmpty().append(s);
	    }
	    return true;
	} else {
	    return false;
	}
    }

}
