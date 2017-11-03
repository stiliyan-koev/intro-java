package com.sirma.itt.javacourse.email.validator;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.itt.java.course.regex.RegexUtilites;
import com.sirma.itt.javacourse.utilities.ConsoleReader;

/**
 * Email validator checking the requirements given from SirmaITT.
 * 
 * @author User
 */
public class EmailValidator {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * Private constructor
	 */
	public EmailValidator() {

	}

	/**
	 * A class that is valdiating the email.
	 */
	public void checkEmail() {
		LOGGER.info("Type in email: ");
		String email = ConsoleReader.read();
		if (validateEmail(email)) {
			LOGGER.info("The email: " + email + " is correct");
		} else {
			LOGGER.info("The email: " + email + " is not correct");
		}
	}

	/**
	 * Validates email with regex.
	 * 
	 * @param email
	 *            - given email by user.
	 * @return - True or false, email is correct or not correct.
	 */
	public boolean validateEmail(String email) {
		return RegexUtilites.validateEmail(email);
	}

}
