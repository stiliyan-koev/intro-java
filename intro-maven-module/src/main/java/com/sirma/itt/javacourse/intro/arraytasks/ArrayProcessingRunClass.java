package com.sirma.itt.javacourse.intro.arraytasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.itt.javacourse.intro.math.ReadUserInput;

/**
 * Run class for {@link ArrayProcessing}.
 * 
 * @author Stiliyan Koev
 */
public final class ArrayProcessingRunClass {
	private static final Logger LOGGER = LoggerFactory.getLogger(ArrayProcessingRunClass.class);

	/**
	 * Private constructor for utility class.
	 */
	private ArrayProcessingRunClass() {
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
	public static int[] fillArray(int[] array) {
		for (int x = 0; x < array.length; x = x + 1) {
			LOGGER.info("Type in a number for your array: ");
			array[x] = ReadUserInput.readInt();
		}
		return array;
	}

	/**
	 * Main entry point to the program that runs {@link ArrayProcessing}.
	 * 
	 * @param args
	 *            - input arguments
	 */
	public static void main(String[] args) {
		int[] myIntArray = new int[100];
		myIntArray = fillArray(myIntArray);
		int startPos = ArrayProcessing.contSubArray(myIntArray);
		int index = ArrayProcessing.getMinElementIndex(myIntArray);

		LOGGER.info(Integer.toString(startPos));
		LOGGER.info(Integer.toString(index));
	}
}
