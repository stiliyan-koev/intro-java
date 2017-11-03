package com.sirma.itt.javacourse.reflannotregex;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.java.regexsecondtask.RegexModify;

public class SecondRegexMatchesTests {

	/**
	 * Test by given example in Java Course.
	 */
	@Test
	public void test() {
		RegexModify modify = new RegexModify();
		StringBuilder text = new StringBuilder();
		text.append("<x><b></b><x>Hello world</x>\n" + "<b>sdfsdf</b><x>Good\n"
				+ "morning</x><x>69</x><x>sdfsdfsdf</x>\n" + "</x>");

		String actual = modify.applyRegex(text).toString();
		String expected = "<x><b></b><x/>\n<b>sdfsdf</b><x/><x/><x/>\n</x>";
		assertEquals(expected, actual);

	}

}
