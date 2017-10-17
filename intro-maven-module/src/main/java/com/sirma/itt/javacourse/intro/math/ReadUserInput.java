package com.sirma.itt.javacourse.intro.math;

import java.util.Scanner;

/**
 * Class reading user input from console and passing it as a String.
 * 
 * @author Stiliyan Koev
 */
public class ReadUserInput {
	/**
	 * Private constructor for utility class.
	 */
	ReadUserInput() {
	}

	private static final Scanner SCANNER = new Scanner(System.in);

	/**
	 * Reading from console.
	 * 
	 * @return - returns the input as String.
	 */
	public static String readString() {
		return SCANNER.nextLine();
	}

	/**
	 * Reading from console.
	 * 
	 * @return - returns the input as Integer.
	 */
	public static int readInt() {
		return SCANNER.nextInt();
	}

	/**
	 * Reading from console.
	 * 
	 * @return - returns the input as float.
	 */
	public static float readFloat() {
		return SCANNER.nextFloat();
	}
}
