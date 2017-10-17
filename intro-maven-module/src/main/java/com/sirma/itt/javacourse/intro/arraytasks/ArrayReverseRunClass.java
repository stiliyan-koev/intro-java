package com.sirma.itt.javacourse.intro.arraytasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.itt.javacourse.intro.math.ReadUserInput;

/**
 * Run class for {@link ArrayReverse}.
 * 
 * @author Stiliyan Koev
 */
public final class ArrayReverseRunClass {
	private static final Logger LOGGER = LoggerFactory.getLogger(ArrayReverseRunClass.class);

	/**
	 * Private constructor for utility class.
	 */
	private ArrayReverseRunClass() {
	}

	/**
	 * Taking the size from the user.
	 * 
	 * @return - gives back the size to the variable.
	 */
	public static int getSize() {
		LOGGER.info("Type in Array size: ");
		return ReadUserInput.readInt();
	}

	/**
	 * Main entry point to the program that runs {@link ArrayReverse}.
	 * 
	 * @param args
	 *            - input arguments
	 */
	public static void main(String[] args) {
		int[] numbers = new int[100];
		LOGGER.info("Type in size: ");
		int size = getSize();
		numbers = ArrayReverse.fillArray(numbers, size);
		numbers = ArrayReverse.arraySwapping(numbers, size);
		ArrayReverse print = new ArrayReverse();
		print.printSwappedArray(numbers);
	}
}
