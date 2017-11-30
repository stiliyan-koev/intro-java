package com.sirma.itt.javacourse.input_output.reverse_text_file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.itt.javacourse.input_output.console_to_file.ConsoleToFile;
import com.sirma.itt.javacourse.utilities.ConsoleReader;

public class ReverseTextFile {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * This class is getting the two names of the files from the user - the
	 * input and output files. When they are validated correct, it proceed to
	 * opening and creating the two files. Then it begins with
	 * reading-reversing-writing.
	 * 
	 * @throws IOException
	 *             - Input/output exception may occur.
	 */
	public static void performReadReverseAndWrite() {
		LOGGER.info("Type in the name of input file: ");
		String inputFileName = getFileName();

		LOGGER.info("Type in the name of output file: ");
		String outputFileName = getFileName();
		try (BufferedReader input = new BufferedReader(new FileReader("target/reverseText/" + inputFileName));
				BufferedWriter output = new BufferedWriter(new FileWriter("target/reverseText/" + outputFileName));) {

			output.write(readInputFromFile(input).reverse().toString());
		} catch (IOException ioe) {
			LOGGER.info("Input/Output exception occured.", ioe);
		}
	}

	/**
	 * This block of code is reading the user input, and thanks to a code from a
	 * previous task {@link ConsoleToFile} it validates the name of it. When it
	 * is validated it is passed as a correct file name.
	 * 
	 * @return - Validated name of a file as a String.
	 */
	public static String getFileName() {
		return ConsoleToFile.validateFileName(ConsoleReader.read());
	}

	/**
	 * Reading the text from the input file. The whole text is appended to a
	 * StringBuilder.
	 * 
	 * @param input
	 *            - The opened input text file.
	 * @return - The whole input from the text as a StringBuilder.
	 * @throws IOException
	 *             - Input/Output exception may occur.
	 */
	public static StringBuilder readInputFromFile(BufferedReader input) {
		StringBuilder wholeInput = new StringBuilder();
		try {
			String line = input.readLine();
			do {
				wholeInput.append(line + '\n');
				line = input.readLine();

			} while (line != null);
		} catch (IOException e) {
			LOGGER.error("Input/Output exception occured.");
		}
		return wholeInput;
	}
}