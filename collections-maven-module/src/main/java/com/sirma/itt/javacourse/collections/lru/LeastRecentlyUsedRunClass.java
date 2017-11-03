package com.sirma.itt.javacourse.collections.lru;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.itt.javacourse.utilities.ConsoleReader;

/**
 * Run class for {@link LeastRecentlyUsed}.
 * 
 * @author Stiliyan Koev
 */
public class LeastRecentlyUsedRunClass {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * Private constructor
	 */
	private LeastRecentlyUsedRunClass() {

	}

	/**
	 * Main entry point class.
	 * 
	 * @param args
	 *            - String arguments.
	 */
	public static void main(String[] args) {
		LOGGER.info("Type in what size of cache you want to use ?");
		LRUcache cache = new LRUcache(ConsoleReader.validatePositiveIntNumber());
		Object[] numbers = { 2, 3, 4, 2, 1, 3, 7, 5, 4, 3 };

		LOGGER.info("1 - Use user input");
		LOGGER.info("2 - Use developer input");
		LOGGER.info("3 - Add element");
		LOGGER.info("4 - Print");
		LOGGER.info("Type in your choice: ");
		int choice = ConsoleReader.validatePositiveIntNumber();
		while (choice > 4) {
			LOGGER.info("Type in your choice: ");
			choice = ConsoleReader.validatePositiveIntNumber();
		}
		switch (choice) {
		case 1:
			cache.userNumbers();
			break;
		case 2:
			LOGGER.info("You will use these numbers: 2, 3, 4, 2, 1, 3, 7, 5, 4, 3");
			cache.leastRecentlyUsed(numbers);
			LOGGER.info(cache.toString());
			break;
		case 3:
			LOGGER.info("Type in an element: ");
			cache.addElement(ConsoleReader.read());
			break;
		case 4:
			LOGGER.info(cache.toString());
			break;

		default:
			break;
		}

	}
}
