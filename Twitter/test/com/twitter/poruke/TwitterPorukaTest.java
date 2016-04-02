package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterPorukaTest {

	@Test
	public void testSetKorisnikNaziv() {
		TwitterPoruka tp = new TwitterPoruka();
		String k = "Dario";
		tp.setKorisnik(k);
		assertEquals("Dario", tp.getKorisnik());
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		TwitterPoruka tp = new TwitterPoruka();
		String k = null;
		tp.setKorisnik(k);
		assertEquals(null, tp.getKorisnik());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(new String(""));
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaStringDuziOd140() {
		TwitterPoruka tp = new TwitterPoruka();
		tp.setPoruka("ovde se nalazi string koji je duzi od 140 karaktera.."
				+ "asdasdasdasdadsadsaadasd ad asd sad asdsadasdadasdasdasdasd"
				+ "ad asd sad as dasd sadasdsadsadsadasdsadasdsadasdsad asd asdas"
				+ "dasd asda dasdsadasdasdasdasdasdasdasdsadsadsadsadsadasdsadasdsa"
				+ "sadasdasdasdasdasdasdasdadasdasdasdsadasdsadsadsad.");
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		TwitterPoruka tp = new TwitterPoruka();
		String k = null;
		tp.setPoruka(k);
	}
	@Test
	public void testToString() {
		TwitterPoruka tp = new TwitterPoruka();
		String s = "KORISNIK:"+tp.getKorisnik()+ " PORUKA:"+tp.getPoruka();
		assertEquals(s, tp.toString());
		//Greska u getMetodi jer se ne vraca atribut poruka vec string "poruka".
	}

}
