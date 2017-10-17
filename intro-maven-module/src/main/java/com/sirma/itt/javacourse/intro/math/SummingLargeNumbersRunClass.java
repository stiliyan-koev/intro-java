package com.sirma.itt.javacourse.intro.math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Run class for {@link SummingLargeNumbersRunClass}.
 * 
 * @author Stiliyan Koev
 */
public final class SummingLargeNumbersRunClass {
	private static final Logger LOGGER = LoggerFactory.getLogger(SummingLargeNumbersRunClass.class);

	/**
	 * Private constructor for utility class.
	 */
	private SummingLargeNumbersRunClass() {

	}

	/**
	 * Main entry point to the program that runs {@linkSummingLargeNumbersRunClass}.
	 * 
	 * @param args
	 *            - input arguments
	 */
	public static void main(String[] args) {
		String firstNumber;
		String secondNumber;

		firstNumber = ReadUserInput.readString();
		secondNumber = ReadUserInput.readString();

		String result = SummingLargeNumbers.stringCalculator(firstNumber, secondNumber);

		LOGGER.info(result);

	}
}
