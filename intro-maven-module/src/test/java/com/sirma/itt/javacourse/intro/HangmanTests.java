package com.sirma.itt.javacourse.intro;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.javacourse.intro.utils.Hangman;

/**
 * JUnit tests for {@link Hangman}.
 * 
 * @author Stiliyan Koev
 */
public class HangmanTests {
	/**
	 * Testing modifyTheWord method.
	 */
	@Test
	public void testModifyTheWord() {
		Hangman hangman = new Hangman();
		String expected = "T__T_E";
		String actual = hangman.modifyTheWord(new StringBuilder("TURTLE")).toString();
		assertEquals(expected, actual);
	}

	/**
	 * Testing remainingLetters method.
	 */
	@Test
	public void testRemainingLetters() {
		Hangman hangman = new Hangman();
		int actual = hangman.getRemainingLettersForGuess(new StringBuilder("T__T_E"));
		int expected = 3;
		assertEquals(expected, actual);
	}

	/**
	 * Testing chooseWord method.
	 */
	@Test
	public void testChooseWord() {
		Hangman hangman = new Hangman();
		String[] words = new String[1];
		words[0] = "cheese";
		String actual = hangman.chooseWord(words);
		String expected = "cheese";
		assertEquals(expected, actual);
	}
}
