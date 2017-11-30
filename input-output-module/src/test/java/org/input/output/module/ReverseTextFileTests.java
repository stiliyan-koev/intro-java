package org.input.output.module;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.invoke.MethodHandles;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.itt.javacourse.input_output.reverse_text_file.ReverseTextFile;

/**
 * JUnit tests for {@link ReverseTextFile}.
 * 
 * @author Stiliyan Koev
 */
public class ReverseTextFileTests {
	public static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * Testing does the code reads, reverse and writes correctly.
	 * 
	 * @throws IOException
	 *             - Input/Output exception may occur.
	 */
	@Test
	public void test() throws IOException {
		String[] actual = null;
		try (BufferedReader INPUT = new BufferedReader(new FileReader("target/reverseText/tests/inputReverseTest.txt"));
				BufferedWriter OUTPUT = new BufferedWriter(
						new FileWriter("target/reverseText/tests/outputReverseTest.txt"));) {

			OUTPUT.write(ReverseTextFile.readInputFromFile(INPUT).reverse().toString());
			OUTPUT.close();
			actual = ReverseTextFile
					.readInputFromFile(
							new BufferedReader(new FileReader("target/reverseText/tests/outputReverseTest.txt")))
					.toString().split("\n");
		} catch (IOException e) {
			LOGGER.error("I/O error occured !", e);
		}

		assertEquals(actual[1], "654");
		assertEquals(actual[2], "3<");
		assertEquals(actual[3], "? uoy");
		assertEquals(actual[4], "era woh yeH");
		assertEquals(actual[5], "321");

	}

}
