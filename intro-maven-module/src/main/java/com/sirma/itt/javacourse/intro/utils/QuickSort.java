
package com.sirma.itt.javacourse.intro.utils;

/**
 * Code for QuickSort.
 * 
 * @author Stiliyan Koev
 */
public final class QuickSort {
	/**
	 * Private constructor of QuickSort class prevents the default
	 * parameter-less constructor from being used elsewhere.
	 */

	private QuickSort() {

	}

	/**
	 * QuickSorting with recursion.
	 * 
	 * @param list
	 *            - the list of numbers that have to be sorted.
	 * @param left
	 *            - the first from the left side UNSORTED item.
	 * @param right
	 *            - the last from the right side UNSORTED item.
	 * @return - returns the sorted list.
	 */
	public static int[] quickSort(int[] list, int left, int right) {
		if (left < right) {
			int p = partition(list, left, right);
			quickSort(list, left, p - 1);
			quickSort(list, p + 1, right);
		}
		return list;
	}

	/**
	 * Finding the unsorted items.
	 * 
	 * @param list
	 *            - the list of numbers that have to be sorted.
	 * @param left
	 *            - the first from the left side UNSORTED item.
	 * @param right
	 *            - the last from the right side UNSORTED item.
	 *
	 * @return - the pivot
	 */
	public static int partition(int[] list, int left, int right) {
		int pivot = left;
		for (int n = pivot + 1; n <= right; n++) {
			if (list[n] < list[pivot]) {
				swap(list, n, pivot + 1);
				swap(list, pivot, pivot + 1);
				pivot++;
			}
		}
		return pivot;
	}

	/**
	 * Swapping the two found numbers.
	 * 
	 * @param list
	 *            - the list of numbers that have to be sorted.
	 * @param indexOne
	 *            - the number bigger than the pivot.
	 * @param indexTwo
	 *            - the number less than the pivot.
	 */
	private static void swap(int[] list, int indexOne, int indexTwo) {
		int temp = list[indexOne];
		list[indexOne] = list[indexTwo];
		list[indexTwo] = temp;
	}

}
