
package com.sirma.itt.javacourse.exceptions.arraywithargumentstask;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A class representing an array of Objects. It has it's length, and
 * currentPosition. {@param currentPosition} is used for add() and remove()
 * methods.
 * 
 * @author Stiliyan Koev
 */
public class ArrayWithArguments {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	private Object[] arrayWithObjects;
	private int currentPosition = 0;

	/**
	 * Increasing {@param currentPosition} value when a new Object is added to
	 * our array.
	 */
	public void increaseCurrPos() {
		currentPosition++;
	}

	/**
	 * Decreasing {@param currentPosition} value when the last Object is removed
	 * from our array.
	 */
	public void decreaseCurrPos() {
		currentPosition--;
	}

	/**
	 * Constructor for our ListWithArguments.
	 * 
	 * @param lenght
	 *            - the length given by user.
	 */
	public ArrayWithArguments(int lenght) {
		arrayWithObjects = new Object[lenght];
	}

	/**
	 * Adding new Object to the array.
	 * 
	 * @param obj
	 *            - the Object that has to be added.
	 * @throws ArrayFullException
	 */
	public void add(Object obj) throws ArrayFullException {
		increaseCurrPos();
		if (currentPosition == arrayWithObjects.length + 1) {
			decreaseCurrPos();

			throw new ArrayFullException("The array is full !");

		} else {
			decreaseCurrPos();
			arrayWithObjects[currentPosition] = obj;
			increaseCurrPos();
		}
	}

	/**
	 * Removing the last Object from the array.
	 * 
	 * @throws ArrayEmptyException
	 */
	public void remove() throws ArrayEmptyException {
		if (currentPosition == 0) {

			throw new ArrayEmptyException();

		} else {
			arrayWithObjects[currentPosition - 1] = null;
			decreaseCurrPos();
		}
	}

	/**
	 * Returns the Object at asked index. Gonna use it only for JUnit tests.
	 * 
	 * @param position
	 *            - The Object in which position we want to see.
	 * @return - the Object in the position given by user.
	 */
	public Object getIndexAt(int position) {
		return arrayWithObjects[position];
	}

	/**
	 * Printing all elements in the array.
	 */
	public void printAllElements() {
		StringBuilder theArray = new StringBuilder();
		for (int i = 0; i < currentPosition; i++) {
			theArray.append(arrayWithObjects[i]);
			theArray.append(" ");
		}
		LOGGER.info(theArray.toString());
	}
}