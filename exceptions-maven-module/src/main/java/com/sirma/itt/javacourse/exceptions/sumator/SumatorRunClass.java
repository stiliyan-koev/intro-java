package com.sirma.itt.javacourse.exceptions.sumator;

import java.lang.invoke.MethodHandles;
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
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

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
		int intA = 1;
		int intB = 10;
		float floatA = 1.0f;
		float floatB = 10.0f;
		String strA = "1a";
		String strB = "10";
		Sumator sumator = new Sumator();
		LOGGER.info("CAUTION: As string numbers we will have '10' and '1a'. Watch carefull.");
		LOGGER.info(
				"Integer result: {}\nFloat result: {} \nString result: {} \nBigDecimal result: {} \nBigInteger result: {}",
				Integer.toString(sumator.sum(intA, intB)), Float.toString(sumator.sum(floatA, floatB)),
				sumator.sum(strA, strB), sumator.sum(BigDecimal.TEN, BigDecimal.ONE).toString(),
				sumator.sum(BigInteger.ONE, BigInteger.TEN).toString());
	}
}