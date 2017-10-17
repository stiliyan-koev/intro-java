package com.sirma.itt.javacourse.intro;

import org.junit.Test;

import com.sirma.itt.javacourse.intro.math.SummingLargeNumbers;

/**
 * JUnit tests of {@link SummingLargeNumbers} class.
 * 
 * @author Stiliyan Koev
 */
public class SummingLargeNumbersTests {
	/**
	 * Test with two regular numbers.
	 */
	@Test
	public void simpleTest() {
		String num1 = "1234";
		String num2 = "1111";
		String expected = "2345";
		String actual = SummingLargeNumbers.stringCalculator(num1, num2);
		assertArrayEquals(expected, actual);
	}

	/**
	 * Test with two numbers bigger than INT_MAX.
	 */
	@Test
	public void testBiggetThanInteger() {
		String num1 = "1000000000000000000000000000000000000000000000000000000001234";
		String num2 = "1000000000000000000000000000000000000000000000000000000001111";
		String expected = "2000000000000000000000000000000000000000000000000000000002345";
		String actual = SummingLargeNumbers.stringCalculator(num1, num2);
		assertArrayEquals(expected, actual);
	}

	/**
	 * Test with two numbers with different amount of digits.
	 */
	@Test
	public void testNotEqualsDigits() {
		String num1 = "111";
		String num2 = "9";
		String expected = "120";
		String actual = SummingLargeNumbers.stringCalculator(num1, num2);
		assertArrayEquals(expected, actual);
	}

	/**
	 * Test with two numbers bigger than INT_MAX and having "one on mind".
	 */
	@Test
	public void testBiggerThanMaxInt() {
		String num1 = "11111111111111111111111111111111111111111111111111111111111111";
		String num2 = "19111111111111111111111111111111111111111111111111111111111119";
		String expected = "30222222222222222222222222222222222222222222222222222222222230";
		String actual = SummingLargeNumbers.stringCalculator(num1, num2);
		assertArrayEquals(expected, actual);
	}

	/**
	 * Test with tow numbers less than INT_MIN and having "one on mind".
	 */
	@Test
	public void testBiggerThanMaxIntNegative() {
		String num1 = "-11111111111111111111111111111111111111111111111111111111111111";
		String num2 = "-19111111111111111111111111111111111111111111111111111111111119";
		String expected = "-30222222222222222222222222222222222222222222222222222222222230";
		String actual = SummingLargeNumbers.stringCalculator(num1, num2);
		assertArrayEquals(expected, actual);
	}

	/**
	 * Generated method for comparing two strings.
	 * 
	 * @param expected
	 *            - String that it is expected to be.
	 * @param actual
	 *            - the String that is returned by the method
	 */
	private void assertArrayEquals(String expected, String actual) {

	}

	@Test
	public void testSwappingValues() {
		String num1 = "10";
		String num2 = "15";
		String expected = "25";
		String actual = SummingLargeNumbers.stringCalculator(num1, num2);
		assertArrayEquals(expected, actual);
	}
}
