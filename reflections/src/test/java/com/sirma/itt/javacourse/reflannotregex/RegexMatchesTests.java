package com.sirma.itt.javacourse.reflannotregex;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

import com.sirma.itt.java.course.regex.IBAN_Validator;
import com.sirma.itt.java.course.regex.RegexUtilites;

public class RegexMatchesTests {
	StringBuilder IBAN = new StringBuilder();

	/**
	 * Testing does it returns correct the IBANs inputted.
	 */
	@Test
	public void testReadIBANs() {
		String input = "<iban>AZ21 NABZ 0000 0000 1370 1000 1944</iban>" + System.lineSeparator()
				+ "<iban>BG80 BNBG 9661 1020 3456 7843</iban>" + System.lineSeparator() + "</bankAccounts>";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		String result = IBAN_Validator.readIBANs().toString();
		assertEquals(input + System.lineSeparator(), result);
	}

	/**
	 * Test with one correct IBAN
	 */
	@Test
	public void testCorrectIBAN() {
		IBAN.setLength(0);
		IBAN.append("<iban>BG80 BNBG 9661 1020 3456 7843</iban>" + System.lineSeparator() + "</bankAccounts>");
		String result = RegexUtilites.applyRegexForIBANs(IBAN).toString();
		String expected = "<iban>****7843</iban>" + System.lineSeparator() + "</bankAccounts>" + System.lineSeparator();
		assertEquals(expected, result);
	}

	/**
	 * Test with IBAN which matches the regex pattern, except the <iban> in the
	 * beginning and </iban> in the end.
	 */
	@Test
	public void testIncorrectIBAN() {
		IBAN.setLength(0);
		IBAN.append("BG80 BNBG 9661 1020 3456 7843" + System.lineSeparator() + "</bankAccounts>");
		String result = RegexUtilites.applyRegexForIBANs(IBAN).toString();
		String expected = "BG80 BNBG 9661 1020 3456 7843" + System.lineSeparator() + "</bankAccounts>"
				+ System.lineSeparator();
		assertEquals(expected, result);
	}

	/**
	 * Test with IBAN which matches the regex pattern, except the <iban> in the
	 * beginning.
	 */
	@Test
	public void testIncorrectIBAN2() {
		IBAN.setLength(0);
		IBAN.append("BG80 BNBG 9661 1020 3456 7843</iban>" + System.lineSeparator() + "</bankAccounts>");
		String result = RegexUtilites.applyRegexForIBANs(IBAN).toString();
		String expected = "BG80 BNBG 9661 1020 3456 7843</iban>" + System.lineSeparator() + "</bankAccounts>"
				+ System.lineSeparator();
		assertEquals(expected, result);
	}

	/**
	 * Test with IBAN which matches the regex pattern, except the </iban> in the
	 * end.
	 */
	@Test
	public void testIncorrectIBAN3() {
		IBAN.setLength(0);
		IBAN.append("<iban>BG80 BNBG 9661 1020 3456 7843" + System.lineSeparator() + "</bankAccounts>");
		String result = RegexUtilites.applyRegexForIBANs(IBAN).toString();
		String expected = "<iban>BG80 BNBG 9661 1020 3456 7843" + System.lineSeparator() + "</bankAccounts>"
				+ System.lineSeparator();
		assertEquals(expected, result);
	}

	/**
	 * Correct IBAN, but not a Bulgarian.
	 */
	@Test
	public void testIncorrectIBAN4() {
		IBAN.setLength(0);
		IBAN.append("<iban>AZ21 NABZ 0000 0000 1370 1000 1944</iban>" + System.lineSeparator() + "</bankAccounts>");
		String result = RegexUtilites.applyRegexForIBANs(IBAN).toString();
		String expected = "<iban>AZ21 NABZ 0000 0000 1370 1000 1944</iban>" + System.lineSeparator() + "</bankAccounts>"
				+ System.lineSeparator();
		assertEquals(expected, result);
	}
}
