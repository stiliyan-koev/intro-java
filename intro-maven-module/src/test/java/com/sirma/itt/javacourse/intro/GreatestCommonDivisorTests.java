package com.sirma.itt.javacourse.intro;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.javacourse.intro.math.GreatestCommonDivisor;

/**
 * JUnit tests of {@link GreatestCommonDivisor} class.
 * 
 * @author Stiliyan Koev
 */
public class GreatestCommonDivisorTests {

	/**
	 * Test with two numbers.
	 */
	@Test
	public void testOfTwoNumbers() {
		int actual = GreatestCommonDivisor.findGCD(36, 54);
		int expected = 18;
		assertEquals(expected, actual);
	}

	/**
	 * Test with another two numbers.
	 */
	@Test
	public void testOfTwoNumbersSwapped() {
		int actual = GreatestCommonDivisor.findGCD(54, 36);
		int expected = 18;
		assertEquals(expected, actual);
	}

	/**
	 * Test with two numbers equals to zero.
	 */
	@Test
	public void testOfTwoNulls() {
		int actual = GreatestCommonDivisor.findGCD(0, 0);
		int expected = 0;
		assertEquals(expected, actual);
	}

	/**
	 * Test with two negative numbers. The test must and does return exception.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void gCDTwoZeroNumbers() {
		GreatestCommonDivisor.findGCD(-5, -10);
	}

	/**
	 * Testing a switch numbers. The first one always should be bigger than the
	 * second one.
	 */
	@Test
	public void testOfSwitchingNumbers() {
		int[] actual = GreatestCommonDivisor.switchAandB(2, 5);
		assertEquals(5, actual[0]);
		assertEquals(2, actual[1]);
	}

}
