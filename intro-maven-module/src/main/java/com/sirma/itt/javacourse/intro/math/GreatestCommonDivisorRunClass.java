package com.sirma.itt.javacourse.intro.math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Run class for {@link GreatestCommonDivisorRunClass}.
 * 
 * @author Stiliyan Koev
 */
public final class GreatestCommonDivisorRunClass {
	private static final Logger LOGGER = LoggerFactory.getLogger(GreatestCommonDivisorRunClass.class);

	/**
	 * Private constructor for utility class.
	 */
	private GreatestCommonDivisorRunClass() {

	}

	/**
	 * Main entry point to the program that
	 * runs{@link GreatestCommonDivisorRunClass}. .
	 * 
	 * @param args
	 *            - input arguments
	 */
	public static void main(String[] args) {
		int firstNumber = ReadUserInput.readInt();
		int secondNumber = ReadUserInput.readInt();
		int[] firstAndSecond = GreatestCommonDivisor.switchAandB(firstNumber, secondNumber);
		int greatestCommonDivisor = GreatestCommonDivisor.findGCD(firstAndSecond[0], firstAndSecond[1]);
		LOGGER.info(Integer.toString(greatestCommonDivisor));

	}

}
