package com.sirma.itt.javacourse.exceptions;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Test;

import com.sirma.itt.javacourse.exceptions.sumator.Sumator;

/**
 * Tests for Sumator.
 * 
 * @author Stiliyan Koev
 */
public class SumatorTests {
	Sumator sumator = new Sumator();

	/**
	 * Testing if we give string arguments not only with numbers but with
	 * letters.
	 */
	@Test(expected = NumberFormatException.class)
	public void test() {
		sumator.sum("123a", "2");
	}

	/**
	 * Test for normal parameters.
	 */
	@Test
	public void normalNumbersTest() {
		assertEquals(15, sumator.sum(10, 5));
		assertEquals(15.0f, sumator.sum(10.0f, 5.0f), 0.1);
		assertEquals("15", sumator.sum("10", "5"));
		assertEquals(new BigDecimal(15), sumator.sum(new BigDecimal(10), new BigDecimal(5)));
		assertEquals(new BigInteger("15"), sumator.sum(new BigInteger("10"), new BigInteger("5")));
	}
}
