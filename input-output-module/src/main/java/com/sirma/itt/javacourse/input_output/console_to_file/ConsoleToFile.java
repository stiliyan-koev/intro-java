package com.sirma.itt.javacourse.input_output.console_to_file;

import java.lang.invoke.MethodHandles;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.itt.javacourse.utilities.ConsoleReader;
import com.sirma.itt.javacourse.utilities.RegexUtilites;

/**
 * Console to File task.
 * 
 * @author Stiliyan Koev.
 */
public class ConsoleToFile {
	public static final Scanner SC = new Scanner(System.in);
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * Reads user input until the user type in just a '.' on a single line. The
	 * input is stored and returned as StringBuilder.
	 * 
	 * @return - Returns the user input, without the last '.', as a
	 *         StringBuilder.
	 */
	public static StringBuilder userConsoleInputToString() {
		StringBuilder input = new StringBuilder();
		LOGGER.info("Type in your text: " + System.lineSeparator());
		String line = SC.nextLine();

		while (line.length() > 1 || line.charAt(0) != '.') {
			input.append(line + System.lineSeparator());
			line = SC.nextLine();
		}

		return input;
	}

	/**
	 * Validates the file name given by the user. The file name must contains
	 * only uppercase and/or lowercase letters, numbers and '_' symbol. And to
	 * end with extension .txt
	 * 
	 * @param fileName
	 *            - The file name typed in by the user, which has to be
	 *            validated.
	 * @return - The verified file name.
	 */
	public static String validateFileName(String fileName) {
		while (RegexUtilites.validateFileName(fileName) == false) {
			LOGGER.info("Wrong file name ! It could contain letters, numbers, space and _ . Please type it again: ");
			fileName = ConsoleReader.read();
		}
		if (RegexUtilites.validateTxtFileNameExtension(fileName)) {
			fileName = fileName + ".txt";
		}
		return fileName;
	}
}