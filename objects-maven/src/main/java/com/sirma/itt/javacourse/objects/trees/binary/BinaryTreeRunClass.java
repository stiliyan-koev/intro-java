package com.sirma.itt.javacourse.objects.trees.binary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.itt.javacourse.intro.math.ReadUserInput;

/**
 * Run class for @BinaryTree.
 * 
 * @author Stiliyan Koev
 */
public final class BinaryTreeRunClass {
	private static final Logger LOGGER = LoggerFactory.getLogger(BinaryTreeRunClass.class);

	/**
	 * Private constructor for {@BinaryTreeRunClass}
	 */
	private BinaryTreeRunClass() {

	}

	/**
	 * Run class for {@link BinaryTree}.
	 * 
	 * @param args
	 *            -Some arguments.
	 */
	public static final void main(String[] args) {
		LOGGER.info("How many numbers you will type in: ");
		int numbersCounter = ReadUserInput.readInt();
		LOGGER.info("Type in what type of Binary Tree you would like to have: 1-Integer, 2-Float");
		int choice = ReadUserInput.readInt();
		Boolean numberAlreadyIn;
		switch (choice) {
		case 1:
			BinaryTree<Integer> intTree = new BinaryTree<Integer>();
			LOGGER.info("Type in INTEGER root number: ");
			int intRoot = ReadUserInput.readInt();
			intTree.setRoot(intRoot);

			for (int i = 1; i < numbersCounter; i++) {
				LOGGER.info("Type in INTEGER number: ");
				numberAlreadyIn = intTree.addNewNumber(intTree.getRoot(), ReadUserInput.readInt());
				if (numberAlreadyIn) {
					i--;
				}
			}
			LOGGER.info("You inserted successful {} numbers", numbersCounter);
			break;

		case 2:
			BinaryTree<Float> floatTree = new BinaryTree<Float>();
			LOGGER.info("Type in FLOAT root number: ");
			float floatRoot = ReadUserInput.readFloat();
			floatTree.setRoot(floatRoot);

			for (int i = 1; i < numbersCounter; i++) {
				LOGGER.info("Type in FLOAT number: ");
				numberAlreadyIn = floatTree.addNewNumber(floatTree.getRoot(), ReadUserInput.readFloat());
				if (numberAlreadyIn) {
					i--;
				}
			}
			LOGGER.info("You inserted successful {} numbers", numbersCounter);
			break;

		default:
			break;
		}

	}

}
