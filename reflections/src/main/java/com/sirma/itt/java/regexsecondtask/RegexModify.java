package com.sirma.itt.java.regexsecondtask;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class apply the Regex pattern and replace the matches with "<x\>".
 * 
 * @author Stiliyan Koev.
 */
public class RegexModify {
	public static final String REGEX = "<x>[^>]*</x>";
	public static final Pattern REGEX_PATTERN = Pattern.compile(REGEX);
	public static final String REPLACE = "<x/>";

	/**
	 * Public constructor.
	 */
	public RegexModify() {

	}

	/**
	 * Applies the Regex pattern and replace the matches with "<x\>".
	 * 
	 * @param text
	 *            - Inputed text that has to be searched and replaced by REGEX.
	 * @return - The text with its replacement of the matches.
	 */
	public String applyRegex(StringBuilder text) {
		Matcher matcher = REGEX_PATTERN.matcher(text);
		return matcher.replaceAll(REPLACE);
	}
}
