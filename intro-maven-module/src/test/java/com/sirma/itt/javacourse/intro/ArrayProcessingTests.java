package com.sirma.itt.javacourse.intro;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.sirma.itt.javacourse.intro.arraytasks.ArrayProcessing;
/**
 * JUnit tests of {@link ArrayProcessing class}.
 * 
 * @author Stiliyan Koev
 */
public class ArrayProcessingTests {

	/**
	 * Testing the method that returns the minimal element.
	 */
	@Test
	public void testMinElement() {
		int[] array = { 5, 6, 2, 3, 5 };

		int expected = 2;
		int actual = ArrayProcessing.getMinElementIndex(array);
		assertEquals(expected, actual);
	}

	/**
	 * Testing the method that returns the minimal element, only with zeros.
	 */
	@Test
	public void testMinElementWithZeros() {
		int[] array = { 0, 0, 0, 0, 0 };
		int expected = 0;
		int actual = ArrayProcessing.getMinElementIndex(array);
		assertEquals(expected, actual);
	}

	/**
	 * Testing the method that returns the minimal element, with negative numbers.
	 */
	@Test
	public void testMinElementWithNegativeElements() {
		int[] array = { -1, -2, -3, -4, -5 };
		int expected = 4;
		int actual = ArrayProcessing.getMinElementIndex(array);
		assertEquals(expected, actual);
	}

	/**
	 * Testing the sum method with regular numbers.
	 */
	@Test
	public void testSum() {
		int[] array = { 1, 2, 3, 5, 10 };
		int expected = 21;
		int actual = ArrayProcessing.sum(array);
		assertEquals(expected, actual);
	}

	/**
	 * Testing the sum method with negative numbers.
	 */
	@Test
	public void testSumElementWithNegativeElements() {
		int[] array = { -1, -2, -3, -4, -5 };
		int expected = -15;
		int actual = ArrayProcessing.sum(array);
		assertEquals(expected, actual);
	}

	/**
	 * Testing the sum method with negative and zero elements.
	 */
	@Test
	public void testSumWithNegativeAndZeroElements() {
		int[] array = { -1, 1, 0, 2, -2 };
		int expected = 0;
		int actual = ArrayProcessing.sum(array);
		assertEquals(expected, actual);
	}

	/**
	 * Testing the contiguous sub array with regular numbers.
	 */
	@Test
	public void testCountSubArray() {
		int[] array = { 1, 2, 3, -4, 5 };
		int expected = 6;
		int actual = ArrayProcessing.contSubArray(array);
		assertEquals(expected, actual);
	}

	/**
	 * Second test of contiguous sub array with regular numbers.
	 */
	@Test
	public void testCountSubArray2() {
		int[] array = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int expected = 6;
		int actual = ArrayProcessing.contSubArray(array);
		assertEquals(expected, actual);
	}
}
