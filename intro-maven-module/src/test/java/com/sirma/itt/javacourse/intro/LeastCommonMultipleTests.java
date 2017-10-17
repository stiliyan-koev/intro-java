package com.sirma.itt.javacourse.intro;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.javacourse.intro.math.LeastCommonMultiple;

/**
 * JUnit tests of {@link LeastCommonMultiple} class.
 * 
 * @author Stiliyan Koev
 */
public class LeastCommonMultipleTests {

	/**
	 * Testing with two numbers.
	 */
	@Test
	public void gCDTwoNumbers() {
		int actual = LeastCommonMultiple.greatestCommonDivisor(27, 60);
		int expected = 3;
		assertEquals(expected, actual);
	}

	/**
	 * Testing with the same numbers as in the first test, but swapped.
	 */
	@Test
	public void gCDTwoNumbersSwapped() {
		int actual = LeastCommonMultiple.greatestCommonDivisor(60, 27);
		int expected = 3;
		assertEquals(expected, actual);
	}

	/**
	 * Testing with two zero numbers.
	 */
	@Test
	public void testOfTwoNulls() {
		int actual = LeastCommonMultiple.greatestCommonDivisor(0, 0);
		int expected = 0;
		assertEquals(expected, actual);
	}

	/**
	 * Testing with two numbers. The 3rd number is their Least common multiple.
	 */
	@Test
	public void testLCMTwoNumbers() {
		int actual = LeastCommonMultiple.leastCommonMultiple(27, 60, 3);
		int expected = 540;
		assertEquals(expected, actual);
	}

	/**
	 * Second test with two numbers which doesn't have least common multiple.The 3rd number is their Least common
	 * multiple equals to 1.
	 */
	@Test
	public void testGCDTwoNumbers2() {
		int actual = LeastCommonMultiple.leastCommonMultiple(21, 19, 1);
		int expected = 399;
		assertEquals(expected, actual);
	}

	/**
	 * Testing with two negative numbers. The test should return exception.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void leastCommonMultipleTwoNegativeNumbers() {
		LeastCommonMultiple.greatestCommonDivisor(-27, -60);
	}

}
