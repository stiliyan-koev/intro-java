package com.sirma.itt.javacourse.exceptions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.javacourse.exceptions.arraywithargumentstask.ArrayEmptyException;
import com.sirma.itt.javacourse.exceptions.arraywithargumentstask.ArrayFullException;
import com.sirma.itt.javacourse.exceptions.arraywithargumentstask.ArrayWithArguments;
import com.sirma.itt.javacourse.exceptions.notinrange.CheckInRange;

/**
 * JUnit tests for {@link CheckInRange}
 * 
 * @author Stiliyan Koev
 */
public class ListWithArgumentsTests {
	static public ArrayWithArguments array = new ArrayWithArguments(5);

	/**
	 * Tester to test the array.Add(Obj X) with 5 numbers. Then checking each
	 * position with expected number.
	 * 
	 * @throws ArrayFullException
	 *             - If the array is full and we try to add one more elements it
	 *             throws an exception.
	 */
	@Test
	public void testingAdd() throws ArrayFullException {
		array.add(1);
		array.add(2.5f);
		array.add("3");
		array.add('#');
		array.add(5);

		assertEquals(1, array.getIndexAt(0));
		assertEquals(2.5f, array.getIndexAt(1));
		assertEquals("3", array.getIndexAt(2));
		assertEquals('#', array.getIndexAt(3));
		assertEquals(5, array.getIndexAt(4));
	}

	/**
	 * Testing array.Remove().
	 * 
	 * @throws ArrayEmptyException
	 *             - If the array is empty and we try to delete one element it
	 *             throws exception.
	 */
	@Test
	public void testingRemove() throws ArrayEmptyException {
		array.remove();
		array.remove();
		array.remove();
		array.remove();
		array.remove();

		assertEquals(null, array.getIndexAt(4));
		assertEquals(null, array.getIndexAt(3));
		assertEquals(null, array.getIndexAt(2));
		assertEquals(null, array.getIndexAt(1));
		assertEquals(null, array.getIndexAt(0));
	}

	/**
	 * Testing Full array Exception.
	 * 
	 * @throws ArrayFullException
	 *             - If the array is full and we try to add one more elements it
	 *             throws an exception.
	 */
	@Test(expected = ArrayFullException.class)
	public void testForFullArray() throws ArrayFullException {
		array.add(1);
		array.add(2);
		array.add(3);
		array.add(4);
		array.add(5);
		array.add(6);
	}

	/**
	 * Testing Empty array Exception.
	 * 
	 * @throws ArrayEmptyException
	 *             - If the array is empty and we try to delete one element it
	 *             throws exception.
	 */
	@Test(expected = ArrayEmptyException.class)
	public void testForEmptyArray() throws ArrayEmptyException {
		array.remove();
	}
}