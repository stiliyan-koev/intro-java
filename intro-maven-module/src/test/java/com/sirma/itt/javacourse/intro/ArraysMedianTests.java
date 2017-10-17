package com.sirma.itt.javacourse.intro;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.javacourse.intro.arraytasks.FindingTheArraysMedian;

/**
 * JUnit tests of {@link FindingTheArraysMedian class}.
 * 
 * @author Stiliyan Koev
 */
public class ArraysMedianTests {

	/**
	 * Test with example given by Sirma ITT.
	 */
	@Test
	public void arrayMedianTestFromSirma1() {
		int size = 5;
		int[] array = { 1, 2, 3, 4, 5 };
		int actual = FindingTheArraysMedian.findMedian(array, size);
		int expected = 4;
		assertEquals(expected, actual);
	}

	/**
	 * Test with second example given by Sirma ITT.
	 */
	@Test
	public void arrayMedianTestFromSirma2() {
		int size = 6;
		int[] array = { 4, 5, 99, -1, 5, 6 };
		int actual = FindingTheArraysMedian.findMedian(array, size);
		int expected = 3;
		assertEquals(expected, actual);
	}
}
