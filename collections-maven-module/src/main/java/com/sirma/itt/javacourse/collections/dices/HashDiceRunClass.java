package com.sirma.itt.javacourse.collections.dices;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.itt.javacourse.utilities.ConsoleReader;

/**
 * RunClass for {@link HashDice}.
 * 
 * @author Stiliyan Koev
 */
public class HashDiceRunClass {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * Private constructor.
	 */
	private HashDiceRunClass() {

	}

	/**
	 * Main entry point class.
	 * 
	 * @param args
	 *            - String arguments.
	 */
	public static void main(String[] args) {
		HashDice dices = new HashDice();
		LOGGER.info("Type in how many sides per dice You want: ");
		int sides = ConsoleReader.validatePositiveIntNumber();
		LOGGER.info("Type in your how many times you want to throw the dices: ");
		int amountOfThrowing = ConsoleReader.validatePositiveIntNumber();
		dices.makeStatistic(sides, amountOfThrowing);
	}
}
