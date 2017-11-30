package org.input.output.module;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Date;

import org.junit.Test;

import com.sirma.itt.javacourse.input_output.data_class.DataClass;

/**
 * JUnit tests for {@link DataClass}.
 * 
 * @author Stiliyan Koev
 */
public class DataClassTests {

	/**
	 * Testing writing and reading an Objects: - Integer(123),Char('#') and
	 * Date().
	 * 
	 * @throws IOException
	 *             - Input/Output exception may occur.
	 */
	@Test
	public void test2() throws IOException {
		DataClass dataClass = new DataClass();
		dataClass.saveObject("outputTest.txt", 123);
		assertEquals(123, dataClass.getObject("outputTest.txt"));

		dataClass.saveObject("outputTest.txt", '#');
		assertEquals('#', dataClass.getObject("outputTest.txt"));

		Object date = new Date();
		dataClass.saveObject("outputTest.txt", date);
		assertEquals(date, dataClass.getObject("outputTest.txt"));
	}
}
