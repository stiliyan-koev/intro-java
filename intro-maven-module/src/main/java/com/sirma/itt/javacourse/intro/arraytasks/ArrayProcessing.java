package com.sirma.itt.javacourse.intro.arraytasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * @author Stiliyan Koev
 */
public class ArrayProcessing {
	private static final Logger LOGGER = LoggerFactory.getLogger(ArrayProcessing.class);

	/**
	 * Finding the least element in the array.
	 * 
	 * @param array
	 *            - Array with numbers input by the user.
	 * @return - returns the position of the least element in the array.
	 */
	public static int getMinElementIndex(int[] array) {
		int min = Integer.MAX_VALUE;
		int position = 0;
		for (int i = 0; i < array.length; i++) {

			if (array[i] < min) {
				min = array[i];
				position = i;
			}
		}
		return position;
	}

	/**
	 * Summing all of the elements in the array.
	 * 
	 * @param array
	 *            - Array with numbers input by the user.
	 * @return - returns the result of summing.
	 */
	public static int sum(int[] array) {

		int result = 0;

		for (int i = 0; i < array.length; i++) {
			result = result + array[i];

		}
		return result;

	}

	/**
	 * Printing the array by Loggers.
	 * 
	 * @param array
	 *            - Array with numbers input by the user.
	 */
	void print(int[] array, int size) {
		for (int i = 0; i < size; i++) {
			LOGGER.info(Integer.toString(array[i]));
		}
	}

	/**
	 * Finding the position of median.
	 * 
	 * @param array
	 *            - Array with numbers input by the user.
	 * @return - returning the index of median.
	 * 
	 */
	public static int contSubArray(int[] array) {
		int sum = 0;
		int maxSum = 0;
		int next = 2;

		for (int i = 0; i < array.length; i++) {
			sum = 0;
			for (int j = i; j < array.length; j++) {
				if ((sum < sum + array[j]) || next > 0) {
					sum = sum + array[j];
					next--;
				} else {
					if (sum > maxSum) {
						maxSum = sum;
					}
					next = 2;
					break;
				}
			}
		}
		return maxSum;
	}
}
