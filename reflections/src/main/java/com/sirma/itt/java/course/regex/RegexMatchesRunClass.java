package com.sirma.itt.java.course.regex;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * RunClass for Regex match task.
 * 
 * @author Stiliyan Koev
 */
public class RegexMatchesRunClass {
	/**
	 * Private constructor.
	 */
	private RegexMatchesRunClass() {

	}

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * Entry main method.
	 * 
	 * @param args
	 *            - String arguments
	 */
	public static void main(String[] args) {
		IBAN_Validator validator = new IBAN_Validator();
		LOGGER.info("Type in all the IBAN's: ");
		StringBuilder input = new StringBuilder();
		input.append(validator.readIBANs());
		LOGGER.info(RegexUtilites.applyRegexForIBANs(input).toString());

	}
}
