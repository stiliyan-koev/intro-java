package com.sirma.itt.javacourse.intro;

import org.junit.Test;

import com.sirma.itt.javacourse.intro.utils.RandomStringsWithGivenLength;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RandomgStringTests {

	/**
	 * Testing does the strings sequences are with the size that they must be.
	 */
	@Test
	public void testTheLengthOfSequences() {
		char[] chars = RandomStringsWithGivenLength.fillCharDec();
		int[] sizes = { 5, 5, 7, 9, 10 };
		int arrayCount = 7;
		String[] sequence = RandomStringsWithGivenLength.generateRandomNumber(sizes, chars,arrayCount);
		for (int i = 0; i < sizes.length; i++) {
			assertEquals(sizes[i], sequence[i].length());
		}
	}

	/**
	 * Checking does the chars array has the proper characters in it.
	 * Range:
	 * 48 - 58  -> 0 ... 9
	 * 64 - 94  -> A ... Z
	 * 97 - 122 -> a ... z 
	 */
	@Test
	public void testTheCharacters() {
		char[] chars = RandomStringsWithGivenLength.fillCharDec();
		for (int i = 0; i < chars.length; i++) {
			int expected = (int) chars[i];
			assertTrue((48 <= expected && expected <= 58) || (65 <= expected && expected <= 91)
					|| (97 <= expected && expected <= 122));
			}
	}

}
