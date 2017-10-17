package com.sirma.itt.javacourse.intro.math;

/**
 * A program that finds the least common multiple of two given numbers.
 * 
 * @author Stiliyan Koev
 */
public final class LeastCommonMultiple {

	/**
	 * private constructor avoiding re-initialization.
	 */
	private LeastCommonMultiple() {

	}

	/**
	 * 
	 * @param firstNumber
	 *            - the first Integer number from console input
	 * @param secondNumber
	 *            - the second Integer number from console input
	 * @param gCD
	 *            - Greatest Common Divisor
	 * @return returns the Least common multiple The formula of finding Least
	 *         common Multiple is by multiplying both of the numbers and then
	 *         dividing to their Greatest Common Divisor. It is returning the
	 *         result, which means the Least common multiple of numbers A and B
	 */
	public static int leastCommonMultiple(int firstNumber, int secondNumber, int gCD) {
		return (firstNumber * secondNumber) / GreatestCommonDivisor.findGCD(firstNumber, secondNumber);
	}

	/**
	 * This method's work is based on Euklid algorithm.
	 * <p>
	 * Until the both numbers are different, from the bigger one we are subtract
	 * the smaller one. Before starting the process we are checking are both of
	 * the numbers real positive numbers. If one or the both numbers are
	 * negative we are throwing an exception, because negative numbers doesn't
	 * have Greatest Common Divisor or Least Common Multiple After this check,
	 * we are checking is 'a' bigger than 'b', because we can't subtract from
	 * <p>
	 * 
	 * @param firstNumber
	 *            - is the first number which was taken from the console.
	 * @param secondNumber
	 *            - is the second number which was taken from the console too.
	 * 
	 * @return The method is returning Greatest Common Divisor in the face of
	 *         'b'. Actually it doesn't matters what it returns - 'a' or 'b',
	 *         because when the while loop is completely done, they are equal.
	 *
	 * 
	 * 
	 */
	public static int greatestCommonDivisor(int firstNumber, int secondNumber) {
		int result = 0;
		int numberOne = firstNumber;
		int numberTwo = secondNumber;
		if (numberOne < 0 || numberTwo < 0) {
			throw new IllegalArgumentException("GCD cannot be negative.");
		}
		while (numberOne != numberTwo) {
			if (numberOne < numberTwo) {
				int temporary = numberOne;
				numberOne = numberTwo;
				numberTwo = temporary;
			}
			result = numberOne - numberTwo;
			numberOne = result;
		}
		return numberTwo;
	}
}
