package com.sirma.itt.javacourse.intro.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.itt.javacourse.intro.math.ReadUserInput;

/**
 * Run class for {@link QuickSort}.
 * 
 * @author StiliyanKoev
 */
public final class QuickSortRunClass {
	private static final Logger LOGGER = LoggerFactory.getLogger(QuickSortRunClass.class);

	/**
	 * Private constructor for utility class.
	 */
	private QuickSortRunClass() {

	}

	/**
	 * Filling array.
	 * 
	 * @param list
	 *            - array that has to be filled.
	 * @return - returns filled array.
	 */
	public static int[] fillArray(int[] list) {
		LOGGER.info("Please type in only 10 numbers !");

		for (int i = 0; i < 10; i++) {
			LOGGER.info("Type in next number: ");
			list[i] = ReadUserInput.readInt();
		}
		return list;
	}

	/**
	 * Main entry point to the program that runs QuickSort.
	 * 
	 * @param args
	 *            - input arguments
	 */
	public static void main(String[] args) {
		int[] array = new int[10];
		array = fillArray(array);
		int[] sorted = QuickSort.quickSort(array, 0, array.length - 1);
		for (int i = 0; i < sorted.length; i++) {
			LOGGER.info(Integer.toString(sorted[i]));
		}
	}
}
