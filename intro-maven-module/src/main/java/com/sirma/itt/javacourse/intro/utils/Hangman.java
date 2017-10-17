package com.sirma.itt.javacourse.intro.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.itt.javacourse.intro.math.ReadUserInput;

/**
 * Final class for Hangman.
 * 
 * @author User
 */
public class Hangman {
	private static final Logger LOGGER = LoggerFactory.getLogger(Hangman.class);

	/**
	 * 
	 * @param words
	 *            - array of words. The code is choosing one of them.
	 * @return - When the function has chosen one of the words from the array it
	 *         returns it.
	 */
	public String chooseWord(String[] words) {
		int number = (int) (Math.random() * words.length);
		return words[number];
	}

	/**
	 * This is the main class of the code. Here is happening the most important
	 * thing - the checks. The 'while' loop will end only if you discovered all
	 * of the letters of the word or if you run out your lives.
	 * 
	 * @param word
	 *            - chosen word from the previous method.
	 */
	public void letsPlay(String word) {

		int lifesRemaining = 10;

		StringBuilder guessedType = new StringBuilder(word);
		guessedType = modifyTheWord(guessedType);
		int lettersRemainingForGuessing = getRemainingLettersForGuess(guessedType);
		printingInformation(lifesRemaining);
		while (lifesRemaining != 0 && lettersRemainingForGuessing != 0) {

			LOGGER.info(guessedType.toString());
			String input = ReadUserInput.readString();

			Boolean didIGuessedRight = false;
			for (int i = 1; i < word.length() - 1; i++) {
				String check = Character.toString(word.charAt(i));
				if (input.equals(check) && guessedType.charAt(i) == '_') {
					guessedType.setCharAt(i, input.charAt(0));
					lettersRemainingForGuessing--;
					didIGuessedRight = true;
					printingInformation(lifesRemaining);
				}
			}
			if (!didIGuessedRight) {
				lifesRemaining--;
				printingInformation(lifesRemaining);
			}
		}
		if (lifesRemaining == 0) {
			LOGGER.info("You lost ! The word was: {}", word);
		} else {
			LOGGER.info("{} \nCONGRATULATIONS !!! \nYou WON !!!", word);
		}
	}

	/**
	 * This is modifying the word. Example: if the word is TURTLE it converts it
	 * to T _ _ _ _ _ _ E
	 * 
	 * @param word
	 *            - chosen word.
	 * @return - returning the modified word.
	 */
	public StringBuilder modifyTheWord(StringBuilder word) {
		Character firstLetter = word.charAt(0);
		Character lastLetter = word.charAt(word.length() - 1);
		for (int i = 1; i < word.length() - 1; i++) {
			Character currentLetter = word.charAt(i);
			if (currentLetter.equals(firstLetter) || currentLetter.equals(lastLetter)) {
				word.setCharAt(i, currentLetter);
			} else {
				word.setCharAt(i, '_');
			}
		}
		return word;
	}

	/**
	 * This is printing the modified word + it's guessed words, the remaining
	 * lifes. At the begining you have 10 lifes. If you wasted 3 of them it
	 * means you have only 7. So it will be printed like: O O O O O O O X X X.
	 * 
	 * @param lifesRemaining
	 *            - How many lives you have remained.
	 */
	public static void printingInformation(int lifesRemaining) {
		if (lifesRemaining != -2) {

			StringBuilder life = new StringBuilder();
			for (int i = 0; i < lifesRemaining; i++) {
				life = life.append("O ");
			}
			for (int i = lifesRemaining; i < 10; i++) {
				life = life.append("X ");
			}
			LOGGER.info(life.toString());

		} else {
			LOGGER.info("Please type in your letter: ");
		}
	}

	/**
	 * This is getting how many letters you have to guess.
	 * 
	 * @param word
	 *            - the modified word.
	 * @return - returns the number of the letters that you have to guess.
	 */
	public int getRemainingLettersForGuess(StringBuilder word) {
		int remainingLetters = 0;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == '_') {
				remainingLetters++;
			}
		}
		return remainingLetters;
	}
}