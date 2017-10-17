package com.sirma.itt.javacourse.intro.utils;

/**
 * Run class for {@link Hangman}.
 * 
 * @author Stiliyan Koev
 */
public final class HangmanRunClass {

	/**
	 * Private constructor for utility class.
	 */
	private HangmanRunClass() {

	}

	/**
	 * The 'words' array contains 9 words for playing. With the method
	 * 'choosingWord' the program is randomly choosing one of them. After this
	 * we have a method 'LetsPlay' with the chosen word.
	 * 
	 * @param args
	 *            - input arguments
	 */
	public static void main(String[] args) {
		String[] words = { "cheese", "spaceship", "elephant", "turtle", "cooler", "bicycle", "supermarket", "computer",
				"programming" };

		Hangman hangmanGame = new Hangman();
		String chosenWord = hangmanGame.chooseWord(words);
		hangmanGame.letsPlay(chosenWord);

	}

}
