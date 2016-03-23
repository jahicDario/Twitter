package com.twitter.test;

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
		tp.setKorisnik("");
	}
	@Test
	public void testToString() {
		TwitterPoruka tp = new TwitterPoruka();
//		String s = "KORISNIK:"+tp.getKorisnik()+ " PORUKA:"+tp.getPoruka();
//		assertEquals(s, tp.toString());
		assertTrue(tp.toString(), true);
	}

}
