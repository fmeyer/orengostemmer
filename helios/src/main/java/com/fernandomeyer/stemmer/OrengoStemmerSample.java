package com.fernandomeyer.stemmer;


import java.util.Scanner;

import com.fernandomeyer.stemmer.implementation.PTStemmerException;


public class OrengoStemmerSample {

	public static void main(String[] args) throws PTStemmerException {
		OrengoStemmerSample ex = new OrengoStemmerSample();
		ex.starter();
	}
	
	public void starter() throws PTStemmerException
	{
		Stemmer st = Stemmer.StemmerFactory(Stemmer.StemmerType.ORENGO);
		st.enableCaching(1000);
		
		String line;
		Scanner s = new Scanner(System.in);
		System.out.println("Insert one word per line:");
		while(s.hasNext())
		{
			line = s.nextLine();
			System.out.println("Stem: "+st.getWordStem(line));
		}	
	}
}
