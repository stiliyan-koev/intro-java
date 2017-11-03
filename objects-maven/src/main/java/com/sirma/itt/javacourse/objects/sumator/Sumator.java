package com.sirma.itt.javacourse.objects.sumator;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.sirma.itt.javacourse.intro.math.SummingLargeNumbers;

/**
 * Class for Sumator task.
 * 
 * @author Stiliyan Koev.
 */
public final class Sumator {
	/**
	 * Public constructor of Sumator .
	 */
	public Sumator() {

	}

	/**
	 * It calculates the sum of the two integer numbers.
	 * 
	 * @param firstNumber
	 *            - first integer number.
	 * @param secondNumber
	 *            - second integer number.
	 * @return - the sum of both numbers.
	 */
	public int sum(int firstNumber, int secondNumber) {
		return firstNumber + secondNumber;
	}

	/**
	 * It calculates the sum of the two float numbers.
	 * 
	 * @param firstNumber
	 *            - first float number.
	 * @param secondNumber
	 *            - second float number.
	 * @return - the sum of both numbers.
	 */
	public float sum(float firstNumber, float secondNumber) {
		return firstNumber + secondNumber;
	}

	/**
	 * It calculates the sum of the two String numbers.
	 * 
	 * @param firstNumber
	 *            - first String number.
	 * @param secondNumber
	 *            - second String number.
	 * @return - the sum of both numbers.
	 */
	public String sum(String firstNumber, String secondNumber) {
		return SummingLargeNumbers.stringCalculator(firstNumber, secondNumber);
	}

	/**
	 * It calculates the sum of the two BigDecimal numbers.
	 * 
	 * @param firstNumber
	 *            - first BigDecimal number.
	 * @param secondNumber
	 *            - second BigDecimal number.
	 * @return - the sum of both numbers.
	 */
	public BigDecimal sum(BigDecimal firstNumber, BigDecimal secondNumber) {
		return firstNumber.add(secondNumber);
	}

	/**
	 * It calculates the sum of the two BigInteger numbers.
	 * 
	 * @param firstNumber
	 *            - first BigInteger number.
	 * @param secondNumber
	 *            - second BigInteger number.
	 * @return - the sum of both numbers.
	 */
	public BigInteger sum(BigInteger firstNumber, BigInteger secondNumber) {
		return firstNumber.add(secondNumber);
	}
}