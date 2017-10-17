package com.sirma.itt.javacourse.intro.utils;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * @author Stiliyan Koev
 */
public class RandomStringsWithGivenLength {
	private static final Logger LOGGER = LoggerFactory.getLogger(RandomStringsWithGivenLength.class);

	/**
	 * 
	 * @return - returning array filled with numbers given by the user.
	 */
	public static char[] fillCharDec() {
		char[] chars = new char[62];
		int startPos = 48;
		int endPos = 122;
		int currentDec = startPos;
		int arrayPositionCounter = 0;

		while (currentDec != endPos + 1) {
			chars[arrayPositionCounter] = (char) currentDec;
			currentDec++;
			arrayPositionCounter++;

			switch (currentDec) {
			case 58:
				currentDec = 65;
				break;
			case 91:
				currentDec = 97;
				break;
			default:
				break;
			}
		}

		return chars;
	}

	/**
	 * 
	 * @param length
	 *            - arrays length.
	 * @param charDecValues
	 *            - array with the numbers,lower and upper case letters.
	 * @param arrayCount
	 *            - the number of arrays we want to create.
	 * @return - returning string with random symbols.
	 */
	public static String[] generateRandomNumber(int[] length, char[] charDecValues, int arrayCount) {
		String[] numbersSequence = new String[arrayCount];
		int number;
		StringBuilder strNumber = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length.length; i++) {
			for (int p = 0; p < length[i]; p++) {
				number = random.nextInt(62);
				strNumber.append(charDecValues[number]);
			}
			numbersSequence[i] = strNumber.toString();
			strNumber.setLength(0);
		}
		return numbersSequence;
	}

	/**
	 * 
	 * @param numbersAndLettersSequence
	 *            - array of random upper and lower case letter.
	 * @param arrayCount
	 *            - the number of arrays we want to create.
	 * @param stringsSize
	 *            - the size of the strings.
	 */

	public void printTheRandomStrings(String[] numbersAndLettersSequence, int[] stringsSize, int arrayCount) {
		for (int i = 0; i < arrayCount; i++) {
			LOGGER.info(numbersAndLettersSequence[i]);
		}
	}
}
