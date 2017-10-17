package com.sirma.itt.javacourse.intro.math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Run class for {@link LeastCommonMultiple}.
 * 
 * @author Stiliyan Koev
 */
public final class LeastCommonMultipleRunClass {
	private static final Logger LOGGER = LoggerFactory.getLogger(LeastCommonMultipleRunClass.class);

	/**
	 * Private constructor for utility class.
	 */
	private LeastCommonMultipleRunClass() {

	}

	/**
	 * Main entry point to the program that runs {@link LeastCommonMultiple}.
	 * 
	 * @param args
	 *            - input arguments
	 */
	public static void main(String[] args) {
		int firstNumber = ReadUserInput.readInt();
		int secondNumber = ReadUserInput.readInt();

		int rCD;
		int leastCommonMultiple;

		rCD = LeastCommonMultiple.greatestCommonDivisor(firstNumber, secondNumber);

		leastCommonMultiple = LeastCommonMultiple.leastCommonMultiple(firstNumber, secondNumber, rCD);
		LOGGER.info(Integer.toString(leastCommonMultiple));

	}
}
