package com.sirma.itt.java.regexsecondtask;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.itt.javacourse.utilities.ConsoleReader;

/**
 * RunClass for {RegexModify}, the second task for REGEX with <x> '</x>' tags.
 * 
 * @author Stiliyan Koev.
 */
public class RunClass {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * Private constructor.
	 */
	private RunClass() {

	}

	/**
	 * Main entry method.
	 * 
	 * @param args
	 *            - String arguments.
	 */
	public static void main(String[] args) {
		RegexModify modify = new RegexModify();
		LOGGER.info("Type in text: ");
		LOGGER.info(System.lineSeparator() + modify.applyRegex(ConsoleReader.readMultipleLine()));
	}
}
