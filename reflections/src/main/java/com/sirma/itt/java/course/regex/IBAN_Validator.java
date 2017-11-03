package com.sirma.itt.java.course.regex;

import com.sirma.itt.javacourse.utilities.ConsoleReader;

/**
 * A class made to read all of the IBANs and separate them with
 * System.lineSeparator().
 * 
 * @author Stiliyan Koev
 */
public class IBAN_Validator {
	public static final String CLOSE_TAG = "</bankAccounts>";

	/**
	 * Public constructor.
	 */
	public IBAN_Validator() {

	}

	/**
	 * A method made to read all of the IBANs and separate them with
	 * System.lineSeparator().
	 * 
	 * @return - All of the IBANs separated by System.lineSeparator().
	 */
	public static StringBuilder readIBANs() {
		StringBuilder input = new StringBuilder();
		String currentLine = "";
		do {
			currentLine = ConsoleReader.read();
			input.append(currentLine);
			input.append(System.lineSeparator());
		} while (!CLOSE_TAG.equals(currentLine));
		return input;
	}
}
