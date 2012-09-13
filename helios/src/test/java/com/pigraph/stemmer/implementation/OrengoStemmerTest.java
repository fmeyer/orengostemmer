package com.pigraph.stemmer.implementation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pigraph.stemmer.Stemmer;


public class OrengoStemmerTest {
    
    
    	@Test
    	public void shouldNotFailWithUTF8() throws PTStemmerException {
    	    Stemmer st = Stemmer.StemmerFactory(Stemmer.StemmerType.ORENGO);
    	    assertEquals("falç", st.getWordStem("falção"));    	    
    	}

	@Test
	public void shouldBeReasonable() throws PTStemmerException{
		

    	    Stemmer st = Stemmer.StemmerFactory(Stemmer.StemmerType.ORENGO);

    	    assertEquals("lembranc", st.getWordStem("lembrancinha"));
    	    assertEquals("camar", st.getWordStem("camareira"));
    	    assertEquals("cam", st.getWordStem("cama"));
	}
	
	@Test
	public void shouldBehaveGoodWithCamera() throws PTStemmerException {
		Stemmer st = Stemmer.StemmerFactory(Stemmer.StemmerType.ORENGO);
		assertEquals("camer", st.getWordStem("camera"));
	}
	
	@Test
	public void shouldBehaveGoodWithEngish() throws PTStemmerException {
		Stemmer st = Stemmer.StemmerFactory(Stemmer.StemmerType.ORENGO);
		assertEquals("case", st.getWordStem("case"));
		assertEquals("cas", st.getWordStem("casa"));
	}

	
	@Test
	public void shouldMapFailures() throws Exception {
		 check("boas", "boa");
		 check("bôas", "bôa");
		 check("bobalhões", "bobalh");
		 check("bobs", "bob");

		 check("bocadinho", "boc");
		 check("bocaiúva", "bocaiúv");
		 check("bocarra", "boc");
		 check("bocas", "boc");
		 
		 
//		 check("bobear", "bob");
//		 check("bobeira", "bobeir");
//		 check("bobinho", "bobinh");
//		 check("bobinhos", "bobinh");
//		 check("bobagem", "bobag");
//		 check("bobagens", "bobagens");
		 
		 
//		 check("boem", "boem");
		 check("boemia", "boem");
		 check("boêmio", "boêmi");
		 check("quintal", "quint");
		 
	}
	
	
	@Test
	public void shouldMimicSnowboll() throws Exception {
		 check("boa", "boa");
		 check("boainain", "boainain");
		 check("boassu", "boassu");
		 check("boataria", "boat");
		 check("boate", "boat");
		 check("boates", "boat");
		 check("boatos", "boat");
		 check("bob", "bob");
		 check("boba", "bob");

		 

		 check("bobo", "bob");
		 check("boca", "boc");
		 check("bocadas", "boc");
		 check("bocado", "boc");

		 check("boçal", "boçal");
		 check("bode", "bod");
		 check("bodoque", "bodoqu");
		 check("body", "body");
		 check("boeing", "boeing");
		 check("bogotá", "bogot");
		 check("boi", "boi");
		 check("bóia", "bói");
		 check("boiando", "boi");
		 check("quiabo", "quiab");
		 check("quicaram", "quic");
		 check("quickly", "quickly");
		 check("quieto", "quiet");
		 check("quietos", "quiet");
		 check("quilate", "quilat");
		 check("quilates", "quilat");
		 check("quilinhos", "quil");
		 check("quilo", "quil");
		 check("quilombo", "quilomb");
		 check("quilométricas", "quilométr");
		 check("quilométricos", "quilométr");
		 check("quilômetro", "quilômetr"); 
		 check("quilômetros", "quilômetr"); 
		 check("quilos", "quil");
		 check("quimica", "quim");
		 check("quilos", "quil");
		 check("quimica", "quim");
		 check("quimicas", "quim");
		 check("quimico", "quim");
		 check("quimicos", "quim");
		 check("quimioterapia", "quimioterap");
		 check("quimioterápicos", "quimioteráp"); 
		 check("quimono", "quimon");
		 check("quincas", "quinc");
		 check("quinhão", "quinhão"); 
		 check("quinhentos", "quinhent");
		 check("quinn", "quinn");
		 check("quino", "quin");
		 check("quinta", "quint");
		 check("quintana", "quint");
		 check("quintanilha", "quintanilh");
		 check("quintão", "quint"); 
		 check("quintessência", "quintess");
		 check("quintino", "quintin");
		 check("quinto", "quint");
		 check("quintos", "quint");
		 check("quintuplicou", "quintuplic");
		 check("quinze", "quinz");
		 check("quinzena", "quinzen");
		 check("quiosque", "quiosqu");
	}
	
	  private void check(final String input, final String expected) throws Exception {
			Stemmer st = Stemmer.StemmerFactory(Stemmer.StemmerType.ORENGO);
			assertEquals(expected, st.getWordStem(input));
	  }

}
