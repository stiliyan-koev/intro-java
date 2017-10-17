package com.sirma.itt.javacourse.intro.math;

/**
 * 
 * 
 * @author Stiliyan Koev
 */
public class SummingLargeNumbers {
	/**
	 * Private constructor
	 */
	private SummingLargeNumbers() {

	}

	/**
	 * Starting from the last digit from each number. When the loop is done it
	 * is reversing the result.
	 * 
	 * @param firstNumber
	 *            - number given by the user.
	 * @param secondNumber
	 *            - second number given by the user.
	 * @return - returning string result.
	 */
	public static String stringCalculator(String firstNumber, String secondNumber) {
		int sizeOfFirstNumber = firstNumber.length();
		int sizeOfSecondNumber = secondNumber.length();
		int difference;
		String numberOne = firstNumber;
		String numberTwo = secondNumber;
		int firstIntDigit;
		char firstDigit;
		int secondDigit;
		int secondIntDigit;
		int tempResult = 0;

		if (sizeOfFirstNumber < sizeOfSecondNumber) {
			difference = sizeOfSecondNumber - sizeOfFirstNumber;
			numberOne = equalizingMethod(numberOne, difference);

		} else if (sizeOfFirstNumber > sizeOfSecondNumber) {
			difference = sizeOfFirstNumber - sizeOfSecondNumber;
			numberTwo = equalizingMethod(numberTwo, difference);

		}

		StringBuilder result = new StringBuilder();
		String toString;
		boolean carry = false;

		for (int i = numberOne.length() - 1; i >= 0; i--) {
			firstDigit = numberOne.charAt(i);
			firstIntDigit = Character.getNumericValue(firstDigit);
			secondDigit = numberTwo.charAt(i);
			secondIntDigit = Character.getNumericValue(secondDigit);
			tempResult = firstIntDigit + secondIntDigit;

			if ((firstIntDigit + secondIntDigit) >= 10) {
				if (carry) {
					firstIntDigit++;
				}
				carry = true;
				tempResult = (firstIntDigit + secondIntDigit) - 10;
			} else if (carry) {
				firstIntDigit++;
				tempResult = firstIntDigit + secondIntDigit;
				carry = false;
			}

			result.append(tempResult);

		}

		result = result.reverse();
		toString = result.toString();

		return toString;
	}

	/**
	 * This is adding nulls to the shorter number. Example "123" and "1234" the
	 * first one will be "0123".
	 * 
	 * @param num
	 *            - the shorter number.
	 * @param difference
	 *            - The difference between both numbers, this shows how many
	 *            nulls it is going to add.
	 * @return - return the new number, equal by length to the longer one and
	 *         with nulls before it.
	 */
	private static String equalizingMethod(String number, int difference) {
		String theNumber = number;
		for (int i = 0; i < difference; i++) {
			theNumber = "0" + theNumber;
		}
		return theNumber;
	}
}
