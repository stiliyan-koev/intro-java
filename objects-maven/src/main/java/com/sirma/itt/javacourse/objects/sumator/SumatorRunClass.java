package com.sirma.itt.javacourse.objects.sumator;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Run class for {@Sumator}.
 * 
 * @author Stiliyan Koev.
 */
public final class SumatorRunClass {
	private static final Logger LOGGER = LoggerFactory.getLogger(SumatorRunClass.class);

	/**
	 * Private constructor for ({@SumatorRunClass}
	 */
	private SumatorRunClass() {

	}

	/**
	 * Main method for {@Sumator} testing all the cases with: Integer, Float,
	 * String, BigDecimal and BigInteger numbers.
	 * 
	 * @param args
	 *            - user arguments.
	 */
	public static void main(String[] args) {
		int firstIntNumber = 5;
		int secondIntNumber = 10;
		float firstFloatNumber = 5.5f;
		float secondFloatNumber = 10.5f;
		String firstStringNumber = "5";
		String secondStringNumber = "10";
		Sumator sumator = new Sumator();

		LOGGER.info("Integer result: " + Integer.toString(sumator.sum(firstIntNumber, secondIntNumber))
				+ "\nFloat result: " + Float.toString(sumator.sum(firstFloatNumber, secondFloatNumber))
				+ "\nString result: " + sumator.sum(firstStringNumber, secondStringNumber) + "\nBigDecimal result: "
				+ sumator.sum(BigDecimal.ONE, BigDecimal.TEN) + "\nBigInteger result: "
				+ sumator.sum(BigInteger.ONE, BigInteger.TEN));

	}
}