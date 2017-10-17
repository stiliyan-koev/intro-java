package com.sirma.itt.javacourse.intro;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.sirma.itt.javacourse.intro.utils.QuickSort;

/**
 * JUnit tests for {@QuickSort}.
 * 
 * @author Stiliyan Koev
 */
public class QuickSortTests {

	/**
	 * Test with regular numbers.
	 */
	@Test
	public void firstTest() {
		int[] array = { 0, 5, 7, 1, 2, 7, 2, 1, 20, 13 };
		int[] actual = QuickSort.quickSort(array, 0, array.length - 1);
		int[] expected = { 0, 1, 1, 2, 2, 5, 7, 7, 13, 20 };
		assertArrayEquals(expected, actual);
	}

	/**
	 * Second test with regular numbers.
	 */
	@Test
	public void secondTest() {
		int[] array = { 0, 15, 37, 41, 2, 17, 22, 5, 24, 13 };
		int[] actual = QuickSort.quickSort(array, 0, array.length - 1);
		int[] expected = { 0, 2, 5, 13, 15, 17, 22, 24, 37, 41 };
		assertArrayEquals(expected, actual);
	}

	/**
	 * Test with negative numbers.
	 */
	@Test
	public void testWithNegativeNumbers() {
		int[] array = { -2, -6, -1, -4, -10, -3, -7, -5, -8, -9 };
		int[] actual = QuickSort.quickSort(array, 0, array.length - 1);
		int[] expected = { -10, -9, -8, -7, -6, -5, -4, -3, -2, -1 };
		assertArrayEquals(expected, actual);
	}
}
