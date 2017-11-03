package com.sirma.itt.javacourse.reflannotregex;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.javacourse.email.validator.EmailValidator;

public class EmailValidatorTests {
	/**
	 * Tests with valid emails.
	 */
	@Test
	public void validEmails() {
		EmailValidator validator = new EmailValidator();
		assertEquals(validator.validateEmail("test.t-s@sir-ma.com"), true);
		assertEquals(validator.validateEmail("h1ello@sirma999.com"), true);
		assertEquals(validator.validateEmail("test@sirma.com"), true);
		assertEquals(validator.validateEmail("eee@s-sirma.com"), true);
		assertEquals(validator.validateEmail("eee@cc.british.museum"), true);
	}

	/**
	 * Tests with invalid emails.
	 */
	@Test
	public void invalidEmails() {
		EmailValidator validator = new EmailValidator();
		assertEquals(validator.validateEmail("test.  t-s@sir-ma.com"), false);
		assertEquals(validator.validateEmail("h1ello123sirma999.com"), false);
		assertEquals(validator.validateEmail("test.comsirma.com"), false);
	}
}
