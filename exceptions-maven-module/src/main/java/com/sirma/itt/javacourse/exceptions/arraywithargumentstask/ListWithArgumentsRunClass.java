package com.sirma.itt.javacourse.exceptions.arraywithargumentstask;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.itt.javacourse.intro.math.ReadUserInput;
import com.sirma.itt.javacourse.utilities.ConsoleReader;

/**
 * RunClass for {@ArrayWithARguments}.
 * 
 * @author Stiliyan Koev
 */
public class ListWithArgumentsRunClass {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * Private constructor.
	 */
	private ListWithArgumentsRunClass() {

	}

	/**
	 * Main method for {@ArrayWithArgumentsRunClass}.
	 * 
	 * @param args
	 *            - some string arguments.
	 * @throws ArrayFullException
	 *             - If the array is full and we try to add one more elements it
	 *             throws an exception.
	 * @throws ArrayEmptyException
	 *             - If the array is empty and we try to delete one element it
	 */
	public static void main(String[] args) throws ArrayFullException, ArrayEmptyException {
		ArrayWithArguments argumentsArray = new ArrayWithArguments(4);
		int option = 0;
		while (option != 4) {
			LOGGER.info("Choose and type in an option: \n1 - Add an object\n 2 - Delete last object\n "
					+ "3 - Print all Arguments in the array\n 4- Exit");
			option = ReadUserInput.readInt();

			switch (option) {
			case 1:
				LOGGER.info("Type what object do you want to enter: \n1 - Int\n 2 - Float\n 3 - String\n 4 - Char\n");
				int secondOption = ReadUserInput.readInt();
				switch (secondOption) {
				case 1:
					argumentsArray.add(ConsoleReader.readInt());
					ConsoleReader.read();
					break;
				case 2:
					argumentsArray.add(ConsoleReader.readFloat());
					ConsoleReader.read();
					break;

				case 3:
					argumentsArray.add(ConsoleReader.read());
					break;

				case 4:
					argumentsArray.add(ConsoleReader.readChar());
					ConsoleReader.read();
					break;

				default:
					break;
				}
				break;

			case 2:
				argumentsArray.remove();
				break;

			case 3:
				argumentsArray.printAllElements();
				break;

			default:
				break;
			}
		}
	}
}