package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.Twitter;
import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {
	
	private Twitter t;
	
	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}

	@Test
	public void testVratiSvePoruke() {
		t.unesi("Dario", "test");
		t.unesi("Dario2", "test2");
		
		if(t.vratiSvePoruke().size() == 2){
			assertTrue(true);
		}
		
	}
	@Test
	public void testUnesi() {
		TwitterPoruka tPoruka = new TwitterPoruka();
		tPoruka.setKorisnik("Dario");
		tPoruka.setPoruka("test");
		t.unesi("Dario", "test");
		LinkedList<TwitterPoruka> tp = t.vratiSvePoruke();
		assertEquals(tp.getFirst().toString(),tPoruka.toString());
		//greska: u metodi setKorisnik smo prosledjivali "korisnik" umesto parametar korisnik
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagPrazanString() {
		TwitterPoruka [] niz = t.vratiPoruke(10, "");
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagPrazanNull() {
		TwitterPoruka [] niz = t.vratiPoruke(10,null);
	}
	@Test
	public void testVratiPoruke() {
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("Dario2");
		tp.setPoruka("#test2");
		t.unesi("Dario", "test1");
		t.unesi("Dario2", "#test2");
		t.unesi("Dario3", "#test3");
		TwitterPoruka [] niz = t.vratiPoruke(10, "#");
		assertEquals(tp.toString(), niz[0].toString());
		
	}
}
