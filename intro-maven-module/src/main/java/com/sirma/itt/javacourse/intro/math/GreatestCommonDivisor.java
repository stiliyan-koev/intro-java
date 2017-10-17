package com.sirma.itt.javacourse.intro.math;

/**
 * 
 * A program that finds greatest common divisor of two given numbers.
 * 
 * @author Stiliyan Koev
 */
public final class GreatestCommonDivisor {
	/**
	 * Private constructor of GreatestCommonDivisor class prevents the default
	 * parameter-less constructor from being used elsewhere.
	 */
	private GreatestCommonDivisor() {

	}

	/**
	 * 
	 * @param firstNumber
	 *            - first given number
	 * @param secondNumber
	 *            - second given number
	 * @return - swapped or not. Depends on their values.
	 */
	public static int[] switchAandB(int firstNumber, int secondNumber) {
		int[] numbers = new int[2];
		if (firstNumber < secondNumber) {
			int temporary = firstNumber;
			numbers[0] = secondNumber;
			numbers[1] = temporary;
		}
		return numbers;
	}

	/**
	 * Before starting the process we are checking are both of the numbers real
	 * positive numbers. If one or the both numbers are negative we are throwing
	 * an exception, because negative numbers doesn't have Greatest Common
	 * Divisor. The algorithm is based on dividing, in the beginning the bigger
	 * one to the smaller one, after that we are dividing the divisor to the
	 * remainder. The loop end when the remainder is equal to zero, which means
	 * the current divisor is the Greater Common Divisor.
	 * 
	 * @param firstNumber
	 *            - the first Integer number from console input
	 * @param secondNumber
	 *            - the second Integer number from console input
	 * @return - returns the Greatest common divisor
	 */
	public static int findGCD(int firstNumber, int secondNumber) {
		int result;
		int numberOne = firstNumber;
		int numberTwo = secondNumber;
		if (numberOne < 0 || numberTwo < 0) {

			throw new IllegalArgumentException("GCD cannot be negative.");
		} else if (numberTwo != 0) {
			while (numberOne % numberTwo != 0) {
				result = numberOne % numberTwo;
				numberOne = numberTwo;
				numberTwo = result;
			}
			return numberTwo;
		} else {
			return numberTwo;
		}
	}
}
