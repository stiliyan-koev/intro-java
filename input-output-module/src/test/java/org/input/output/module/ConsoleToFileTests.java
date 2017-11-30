package org.input.output.module;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.javacourse.input_output.console_to_file.ConsoleToFile;

/**
 * JUnit tests for {@link ConsoleToFile}.
 * 
 * @author Stiliyan Koev
 */
public class ConsoleToFileTests {

	/**
	 * Test with correct file name.
	 */
	@Test
	public void correctFileNameWithoutNumbers() {
		String input = "textFile.txt";
		String result = ConsoleToFile.validateFileName(input);
		assertEquals("textFile.txt", result);
	}

	/**
	 * Test with correct file name, but having number.
	 */
	@Test
	public void correctFileNameWithNumbers() {
		String input = "textFile1.txt";
		String result = ConsoleToFile.validateFileName(input);
		assertEquals("textFile1.txt", result);
	}

	/**
	 * Test with correct file name, but having number and a '_'.
	 */
	@Test
	public void correctFileNameWithSlashAndNumbers() {
		String input = "text1_1File1.txt";
		String result = ConsoleToFile.validateFileName(input);
		assertEquals("text1_1File1.txt", result);
	}

	/**
	 * Test with correct file name with upper case, numbers and '_'.
	 */
	@Test
	public void correctFileNameWithSlashAndUpperCase() {
		String input = "TEXT1_1FILE1.txt";
		String result = ConsoleToFile.validateFileName(input);
		assertEquals("TEXT1_1FILE1.txt", result);
	}

	/**
	 * Test with correct file name, but without .txt extension.
	 */
	@Test
	public void testAddingTxtExtension() {
		String input = "text_file";
		String result = ConsoleToFile.validateFileName(input);
		assertEquals("text_file.txt", result);
	}
}
