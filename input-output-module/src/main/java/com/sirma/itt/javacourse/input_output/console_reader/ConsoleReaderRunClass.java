package com.sirma.itt.javacourse.input_output.console_reader;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.itt.javacourse.utilities.ConsoleReader;

/**
 * Run class for {@link ConsoleReader}.
 * 
 * @author Stiliyan Koev.
 */
public class ConsoleReaderRunClass {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * Main entry class for {@link ConsoleReader}.
	 * 
	 * @param args
	 *            - String arguments.
	 * @throws IOException
	 *             - Input-Output Exception might be thrown.
	 */
	public static void main(String[] args) throws IOException {

		LOGGER.info("Type in your choice of what you want to read: 1 - String" + System.lineSeparator() + "2 - Char"
				+ System.lineSeparator() + "3 - Integer" + System.lineSeparator() + "4 - Float");
		int choice = ConsoleReader.readInt();

		switch (choice) {
		case 1:
			LOGGER.info("Type in your String input: ");
			LOGGER.info(ConsoleReader.read());
			LOGGER.info("This was your input");
			break;
		case 2:
			LOGGER.info("Type in your char input: ");
			LOGGER.info(Character.toString(ConsoleReader.readChar()));
			LOGGER.info("This was your input");
			break;
		case 3:
			LOGGER.info("Type in your Integer input: ");
			LOGGER.info(Integer.toString(ConsoleReader.readInt()));
			LOGGER.info("This was your input");
			break;
		case 4:
			LOGGER.info("Type in your Float input: ");
			LOGGER.info(Float.toString(ConsoleReader.readFloat()));
			LOGGER.info("This was your input");
			break;
		default:
			break;
		}
	}
}
