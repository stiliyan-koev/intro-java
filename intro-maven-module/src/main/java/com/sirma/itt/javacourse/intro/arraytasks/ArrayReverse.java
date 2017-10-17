package com.sirma.itt.javacourse.intro.arraytasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.itt.javacourse.intro.math.ReadUserInput;

/**
 * 
 * 
 * @author Stiliyan Koev
 */
public class ArrayReverse {
	private static final Logger LOGGER = LoggerFactory.getLogger(ArrayReverse.class);

	/**
	 * * This is swapping the positions of array.
	 * 
	 * @param numbers
	 *            - array of numbers.
	 * 
	 * @param size
	 *            - size of array.
	 * @return - returns reversed array.
	 */
	public static int[] arraySwapping(int[] numbers, int size) {
		int back = size - 1;
		int temp;
		for (int i = 0; i < size / 2; i++) {

			temp = numbers[i];
			numbers[i] = numbers[back];
			numbers[back] = temp;
			back--;
		}
		return numbers;
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
	 * Giving the elements one by one to the Loggers to be printed.
	 * 
	 * @param reversedArray
	 *            - reversed array.
	 */
	public void printSwappedArray(int[] reversedArray) {
		for (int i = 0; i < reversedArray.length; i++) {
			LOGGER.info(Integer.toString(reversedArray[i]));
		}
	}
}
