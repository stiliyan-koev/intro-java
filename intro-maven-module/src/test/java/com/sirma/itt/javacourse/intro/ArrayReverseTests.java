package com.sirma.itt.javacourse.intro;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.sirma.itt.javacourse.intro.arraytasks.ArrayReverse;

/**
 * JUnit tests of {@link ArrayReverse class}.
 * 
 * @author Stiliyan Koev
 */
public class ArrayReverseTests {

	/**
	 * Testing the ArrayReverse method with positive regular numbers.
	 */
	@Test
	public void testWithNormalNumbers() {
		int[] array = { 1, 2, 3, 4, 5 };
		int[] swapped = { 5, 4, 3, 2, 1 };
		int[] actual = ArrayReverse.arraySwapping(array, 5);
		assertArrayEquals(actual, swapped);
	}

	/**
	 * Testing the ArrayReverse method with negative numbers.
	 */
	@Test
	public void testWithNegativeNumbers() {
		int[] array = { -11, -12, -13, -14, -15 };
		int[] swapped = { -15, -14, -13, -12, -11 };
		int[] actual = ArrayReverse.arraySwapping(array, 5);
		assertArrayEquals(actual, swapped);
	}

}
