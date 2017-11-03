package com.sirma.itt.java.course.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ApplyRegex is a class who has a regex pattern and applies it to the whole
 * given input as a string.
 * 
 * @author Stiliyan Koev
 */
public class RegexUtilites {
	public static final String IBAN_REGEX = "((?<=<iban>)BG\\d{2})([\\d\\w\\s]+)((?<![\\d\\w]))*(?=\\d{4}</iban>)";
	public static final Pattern IBAN_REGEX_PATTERN = Pattern.compile(IBAN_REGEX);
	public static final String IBAN_REPLACE = "****";

	public static final String EMAIL_REGEX = "[a-z0-9\\._-]+@[a-z0-9\\.-]+\\.[a-z]*";
	public static final Pattern EMAIL_REGEX_PATTERN = Pattern.compile(EMAIL_REGEX);

	/**
	 * Private constructor.
	 */
	private RegexUtilites() {

	}

	/**
	 * First it has an input of IBANS which are separated by \n. When the regex
	 * find a match it replace it with "****", only for IBANS.
	 * 
	 * @param input
	 *            - All of the IBANS splitted by newline character.
	 * @return - Return the IBANS, but if there is a Bulgarian one, it is
	 *         replaced by "****" except its last 4 digits.
	 */
	public static StringBuilder applyRegexForIBANs(StringBuilder input) {
		String[] inputToArray = input.toString().split(System.lineSeparator());
		StringBuilder replacedInput = new StringBuilder();
		for (int i = 0; i < inputToArray.length; i++) {

			Matcher matcher = IBAN_REGEX_PATTERN.matcher(inputToArray[i]);
			replacedInput.append(matcher.replaceAll(IBAN_REPLACE) + System.lineSeparator());
		}
		return replacedInput;
	}

	/**
	 * Validates email using regex.
	 * 
	 * @param email
	 *            - email to be validated.
	 * @return - True if email is within the rules, false if it is incorrect.
	 */
	public static boolean validateEmail(String email) {
		Matcher emailMatcher = EMAIL_REGEX_PATTERN.matcher(email);
		return emailMatcher.matches();
	}
}
