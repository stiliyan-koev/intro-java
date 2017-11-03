package com.sirma.itt.javacourse.email.validator;

/**
 * Run class for {@EmailValidator}.
 * 
 * @author Stiliyan Koev.
 */
public class EmailRunClass {
	/**
	 * Private constructor
	 */
	private EmailRunClass() {

	}

	/**
	 * Main entry class.
	 * 
	 * @param args
	 *            - String arguments/
	 */
	public static void main(String[] args) {
		new EmailValidator().checkEmail();
	}
}
