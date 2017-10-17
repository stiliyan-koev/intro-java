package com.sirma.itt.javacourse.intro.arraytasks;

/**
 * 
 * 
 * @author Stiliyan Koev
 */
public final class FindingTheArraysMedian {
	/**
	 * Private constructor of FindingTheArraysMedianr class prevents the default
	 * parameter-less constructor from being used elsewhere.
	 */
	private FindingTheArraysMedian() {

	}

	/**
	 * Finding the median with summing both of the sides: left and right of the
	 * median. By comparing the differences it finds the least difference and
	 * keep the index of the median.
	 * 
	 * @param numbers
	 *            - array with numbers.
	 * @param size
	 *            - size of the array.
	 * @return - returning the index of median.
	 */
	public static int findMedian(int[] numbers, int size) {
		int difference;
		int minDifference;
		int sumLeft;
		int sumRight = 0;
		int median = 0;
		sumLeft = numbers[0];
		for (int i = 2; i < size; i++) {
			sumRight = sumRight + numbers[i];
		}

		minDifference = Math.abs(sumLeft - sumRight);

		for (int i = 2; i < size - 1; i++) {
			sumLeft = sumLeft + numbers[i - 1];
			sumRight = sumRight - numbers[i];

			difference = Math.abs(sumRight - sumLeft);

			if (difference < minDifference) {
				minDifference = difference;
				median = i + 1;
			} else {
				break;
			}
		}
		return median;
	}
}
