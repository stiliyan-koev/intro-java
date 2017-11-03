package com.sirma.itt.javacourse.exceptions.notinrange;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.itt.javacourse.intro.math.ReadUserInput;

/**
 * Checking if the given number is within the range of 1-100. If not it throws
 * exception.
 * 
 * @author Stiliyan Koev.
 */
public class CheckInRange {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * Public constructor
	 */
	public CheckInRange() {

	}

	/**
	 * Reading and checking is the number between range of 0 and 100.
	 * 
	 * @param number
	 *            - number given by user.
	 * @throws NotInRangeException
	 */
	public void read(int number) {
		if (number < 0 || number > 100) {
			throw new NotInRangeException();
		}
	}

	/**
	 * Main method.
	 * 
	 * @param args
	 *            - string arguments
	 * @throws NotInRangeException
	 */
	public void main(String[] args) {
		try {
			read(ReadUserInput.readInt());
		} catch (NotInRangeException e) {
			LOGGER.info("Your number is not wihin the range of 1-100" + e);
		}
	}
}
