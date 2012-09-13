package com.pigraph.analysis;

import java.io.IOException;
import java.util.List;

import org.apache.lucene.analysis.TokenStream;
import org.apache.solr.analysis.BaseTokenFilterFactory;
import org.apache.solr.common.ResourceLoader;
import org.apache.solr.util.plugin.ResourceLoaderAware;

public class OrengoStemmerFilterFactory extends BaseTokenFilterFactory  implements ResourceLoaderAware {

    private List<String> stemmerIgnoreList;
    private boolean ignoreCase;
    
    public OrengoStemmerFilter create(TokenStream in) {
	return new OrengoStemmerFilter(in, getStemmerIgnoreList());
    }
    
    @Override
    public void inform(ResourceLoader loader) {
      String stemmerIgnoreFile = args.get("exceptionList");
      ignoreCase = getBoolean("ignoreCase",false);

      if (stemmerIgnoreFile != null) {
	  try {
	      setStemmerIgnoreList(getWordList(loader, stemmerIgnoreFile, ignoreCase));
	} catch (IOException e) {
	    e.printStackTrace();
	}
      }
    }
    
    
    protected   List<String> getWordList(ResourceLoader loader,
	    String stemmerIgnoreFile, boolean ignoreCase) throws IOException {
	assureMatchVersion();

	return loader.getLines(stemmerIgnoreFile);
    }

    public List<String> getStemmerIgnoreList() {
	return stemmerIgnoreList;
    }

    public void setStemmerIgnoreList(List<String> stemmerIgnoreList) {
	this.stemmerIgnoreList = stemmerIgnoreList;
    }

}
