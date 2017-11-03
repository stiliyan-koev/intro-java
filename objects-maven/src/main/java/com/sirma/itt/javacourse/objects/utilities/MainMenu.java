package com.sirma.itt.javacourse.objects.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.itt.javacourse.intro.math.ReadUserInput;
import com.sirma.itt.javacourse.objects.sumator.SumatorRunClass;
import com.sirma.itt.javacourse.objects.trees.binary.BinaryTreeRunClass;
import com.sirma.itt.javacourse.objects.trees.heterogeneous.HeterogeneousTreeRunClass;
import com.sirma.itt.javacourse.objects.trees.homogeneous.HomogeneousTreeRunClass;

/**
 * Console menu including all tasks from Objects java as choices.
 * 
 * @author Stiliyan Koev.
 */
public class MainMenu {
	/**
	 * Private constructor
	 */
	private MainMenu() {

	}

	private static final Logger LOGGER = LoggerFactory.getLogger(MainMenu.class);

	/**
	 * Main entry class.
	 * 
	 * @param args
	 *            - String arguments.
	 */
	public static void main(String[] args) {
		LOGGER.info(" \n1. Sumator \n 2.Homogeneous tree \n 3.Binary tree\n 4.Heterogeneous tree\n 5. Exit \n");
		LOGGER.info("Please type in your choice: ");
		int choice = ReadUserInput.readInt();

		switch (choice) {
		case 1:
			SumatorRunClass.main(args);
			break;

		case 2:
			HomogeneousTreeRunClass.main(args);
			break;

		case 3:
			BinaryTreeRunClass.main(args);
			break;

		case 4:
			HeterogeneousTreeRunClass.main(args);
			break;
		case 5:
			break;

		default:
			break;
		}
	}
}
