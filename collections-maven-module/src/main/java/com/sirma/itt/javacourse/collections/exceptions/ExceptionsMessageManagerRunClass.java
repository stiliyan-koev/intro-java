package com.sirma.itt.javacourse.collections.exceptions;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.itt.javacourse.utilities.ConsoleReader;

/**
 * Run class for {@link ExceptionsMessageManager}.
 * 
 * @author Stiliyan Koev
 */
public class ExceptionsMessageManagerRunClass {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * Private constructor.
	 */
	private ExceptionsMessageManagerRunClass() {

	}

	/**
	 * Main entry point class.
	 * 
	 * @param args
	 *            - String arguments.
	 */
	public static void main(String[] args) {
		ExceptionsMessageManager exceptionManager = new ExceptionsMessageManager();
		LOGGER.info("Menu:" + System.lineSeparator() + "1 - Add exception message" + System.lineSeparator()
				+ "2 - Add exception message using code" + System.lineSeparator() + "3 - Print message"
				+ System.lineSeparator() + "4 - Separate message" + System.lineSeparator());

		int choice = 0;
		while (choice != 5) {
			LOGGER.info("Type in choice: ");
			choice = ConsoleReader.readInt();
			switch (choice) {
			case 1:
				LOGGER.info("Type in your message: " + System.lineSeparator());
				exceptionManager.addExceptionMessage(ConsoleReader.read());
				break;

			case 2:
				LOGGER.info("Type in your message code: " + System.lineSeparator());
				exceptionManager.addExceptionMessageUsingCode(ConsoleReader.read());
				break;

			case 3:
				LOGGER.info(exceptionManager.getMessage());
				break;

			case 4:
				LOGGER.info("Type in your message combination: ");
				String messageCombination = ConsoleReader.read();
				LOGGER.info(exceptionManager.getMessages(messageCombination).toString());
				break;

			default:
				break;
			}
		}
	}
}
