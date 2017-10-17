package com.sirma.itt.javacourse.intro.arraytasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.itt.javacourse.intro.math.ReadUserInput;

/**
 * Run class for {@link FindingTheArraysMedian}.
 * 
 * @author Stiliyan Koev
 */
public final class ArrayMedianRunClass {
	private static final Logger LOGGER = LoggerFactory.getLogger(ArrayMedianRunClass.class);

	/**
	 * Private constructor for utility class.
	 */
	private ArrayMedianRunClass() {
	}

	/**
	 * Filling the array with elements which are input by the user.
	 * 
	 * @param array
	 *            - Array with numbers input by the user.
	 * @param size
	 *            - size of the array given by the user.
	 * @return - returns filled with elements array.
	 */
	public static int[] fillArray(int[] array, int size) {
		for (int x = 0; x < size; x = x + 1) {
			array[x] = ReadUserInput.readInt();
		}
		return array;
	}

	/**
	 * Main entry point to the program that runs {@link FindingTheArraysMedian}.
	 * 
	 * @param args
	 *            - input arguments
	 */
	public static void main(String[] args) {
		LOGGER.info("Type in array size: ");
		int arraySize = ReadUserInput.readInt();
		int[] arrayNumbers = new int[arraySize];
		int size = ReadUserInput.readInt();
		arrayNumbers = fillArray(arrayNumbers, size);

		int median = FindingTheArraysMedian.findMedian(arrayNumbers, size);
		LOGGER.info(Integer.toString(median));

	}
}
