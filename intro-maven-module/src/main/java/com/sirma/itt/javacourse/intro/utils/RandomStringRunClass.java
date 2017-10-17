package com.sirma.itt.javacourse.intro.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.itt.javacourse.intro.math.ReadUserInput;

/**
 * Run class for {@link RandomStringsWithGivenLength}.
 * 
 * @author Stiliyan Koev
 */
public final class RandomStringRunClass {
	private static final Logger LOGGER = LoggerFactory.getLogger(RandomStringRunClass.class);

	/**
	 * Private constructor for utility class.
	 */
	private RandomStringRunClass() {
	}

	/**
	 * 
	 * @param stringLengths
	 *            - the Lengths of the arrays.
	 * @param arraySize
	 *            - the size of the arrays.
	 * @return - returning the lengths of the 7 arrays given by user.
	 */
	public static int[] takeStringLengths(int[] stringLengths) {
		int size = ReadUserInput.readInt();
		for (int i = 0; i < size; i++) {
			LOGGER.info("Type in number: ");
			size = ReadUserInput.readInt();
			stringLengths[i] = size;

		}
		return stringLengths;
	}

	/**
	 * Main entry point to the program that runs
	 * {@link RandomStringsWithGivenLength}.
	 * 
	 * @param args
	 *            - input arguments
	 */
	public static void main(String[] args) {
		LOGGER.info("Type in how many arrays you want to have: ");
		int arrayCount = ReadUserInput.readInt();
		int[] stringLength = new int[arrayCount];

		stringLength = takeStringLengths(stringLength);

		char[] charHex = RandomStringsWithGivenLength.fillCharDec();
		String[] numbersSequence = RandomStringsWithGivenLength.generateRandomNumber(stringLength, charHex, arrayCount);

		RandomStringsWithGivenLength printTheStrings = new RandomStringsWithGivenLength();

		printTheStrings.printTheRandomStrings(numbersSequence, stringLength, arrayCount);

	}
}
