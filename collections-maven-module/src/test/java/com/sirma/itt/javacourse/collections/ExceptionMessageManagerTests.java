package com.sirma.itt.javacourse.collections;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.sirma.itt.javacourse.collections.exceptions.ExceptionsMessageManager;

/**
 * Tests cases for {@link ExceptionsMessageManager}.
 * 
 * @author Stiliyan Koev
 */
public class ExceptionMessageManagerTests {
	ExceptionsMessageManager emm = new ExceptionsMessageManager();

	/**
	 * Tests for checkDoesTheMessageExcists() function.
	 */
	@Test
	public void testCheckDoesTheMessageExists() {
		ExceptionsMessageManager emm = new ExceptionsMessageManager();

		boolean result = emm.checkDoesTheMessageExists("Invalid EGN");
		assertEquals(true, result);

		result = emm.checkDoesTheMessageExists("Invalid PIN");
		assertEquals(false, result);
	}

	/**
	 * Tests for checkDoesTheKeyExcists() function.
	 */
	@Test
	public void testCheckDoesTheKeyExists() {
		ExceptionsMessageManager emm = new ExceptionsMessageManager();

		boolean result = emm.checkDoesTheKeyExists("EGN");
		assertEquals(true, result);

		result = emm.checkDoesTheMessageExists("PIN");
		assertEquals(false, result);
	}

	/**
	 * Tests for addExceptionMessage() function.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAddExceptionMessageThrowingException() {
		ExceptionsMessageManager emm = new ExceptionsMessageManager();
		emm.addExceptionMessage("Invalid PIN");
	}

	/**
	 * Tests for addExceptionMessageUsingCode() function.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAddExceptionMessageUsingCodeThrowingException() throws NullPointerException {
		ExceptionsMessageManager emm = new ExceptionsMessageManager();
		emm.addExceptionMessageUsingCode("PIN");
		emm.addExceptionMessageUsingCode("ACC");

	}

	/**
	 * Tests for getMessage() function.
	 */
	@Test
	public void testGetMessage() {
		ExceptionsMessageManager emm = new ExceptionsMessageManager();
		emm.addExceptionMessage("Invalid card number");
		emm.addExceptionMessageUsingCode("EGN");
		assertEquals("Invalid card number,EGN", emm.getMessage());
	}

	/**
	 * Tests for getMessages() function.
	 */
	@Test
	public void testGetMessages() {
		List<String> listOfMessages = emm.getMessages("Invalid PIN,Invalid User,PIN,ACC");
		assertEquals("Invalid PIN", listOfMessages.get(0));
		assertEquals("Invalid User", listOfMessages.get(1));
		assertEquals("PIN", listOfMessages.get(2));
		assertEquals("ACC", listOfMessages.get(3));
	}
}
