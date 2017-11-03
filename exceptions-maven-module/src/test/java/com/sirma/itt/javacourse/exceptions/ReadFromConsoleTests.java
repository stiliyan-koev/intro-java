package com.sirma.itt.javacourse.exceptions;

import org.junit.Assert;
import org.junit.Test;

import com.sirma.itt.javacourse.exceptions.notinrange.CheckInRange;
import com.sirma.itt.javacourse.exceptions.notinrange.NotInRangeException;

/**
 * 
 * 
 * @author Stiliyan Koev
 */
public class ReadFromConsoleTests {
	private CheckInRange checkInRange = new CheckInRange();

	/**
	 * Test if the number is negative.
	 * 
	 * @throws NotInRangeException
	 */
	@Test(expected = NotInRangeException.class)
	public void testOutOfRange() throws NotInRangeException {
		checkInRange.read(-1);
		Assert.fail("Should not pass !");
	}

	/**
	 * Test if the number is not in range.
	 */
	@Test(expected = NotInRangeException.class)
	public void exTest() throws NotInRangeException {
		checkInRange.read(110);
		Assert.fail("Should not pass !");
	}

	/**
	 * Test if in it range (prints nothing).
	 */
	@Test
	public void testInRange() throws NotInRangeException {
		checkInRange.read(10);
	}

}
