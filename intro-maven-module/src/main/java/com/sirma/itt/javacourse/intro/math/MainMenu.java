package com.sirma.itt.javacourse.intro.math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.itt.javacourse.intro.arraytasks.ArrayMedianRunClass;
import com.sirma.itt.javacourse.intro.arraytasks.ArrayProcessingRunClass;
import com.sirma.itt.javacourse.intro.arraytasks.ArrayReverseRunClass;
import com.sirma.itt.javacourse.intro.utils.HangmanRunClass;
import com.sirma.itt.javacourse.intro.utils.QuickSortRunClass;

/**
 * Class presenting a menu in console.
 * 
 * @author Stiliyan Koev.
 */
public class MainMenu {
	private static final Logger LOGGER = LoggerFactory.getLogger(MainMenu.class);

	/**
	 * Private constructor for utility class.
	 */
	private MainMenu() {
	}

	/**
	 * Main entry class.
	 * 
	 * @param args
	 *            - String arguments.
	 */
	public static void main(String[] args) {
		LOGGER.info("\n1. Run Greatest Common Divisor\n" + "2. Run Least Common Multiple\n"
				+ "3. Run Array Processing\n" + "4. Run Finding the array's median\n" + "5. Run Array Sorting\n"
				+ "6. Run Array reverse\n" + "7. Run Summing Large Numbers\n" + "8. Run Hangman Game" + "9. Exit");
		LOGGER.info("Type in your choice: ");

		int choice = ReadUserInput.readInt();

		switch (choice) {
		case 1:
			GreatestCommonDivisorRunClass.main(args);
			break;

		case 2:
			LeastCommonMultipleRunClass.main(args);
			break;

		case 3:
			ArrayProcessingRunClass.main(args);
			break;

		case 4:
			ArrayMedianRunClass.main(args);
			break;

		case 5:
			QuickSortRunClass.main(args);
			break;

		case 6:
			ArrayReverseRunClass.main(args);
			break;

		case 7:
			SummingLargeNumbersRunClass.main(args);
			break;

		case 8:
			HangmanRunClass.main(args);
			break;

		case 9:
			break;

		default:
			break;
		}
	}
}
