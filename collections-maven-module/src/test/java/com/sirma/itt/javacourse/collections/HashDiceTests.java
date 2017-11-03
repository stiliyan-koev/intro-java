package com.sirma.itt.javacourse.collections;

import org.junit.Test;

import com.sirma.itt.javacourse.collections.dices.HashDice;

/**
 * Tests for {@link HashDice}.
 * 
 * @author Stiliyan Koev
 */
public class HashDiceTests {
	/**
	 * Simple run of the program.
	 */
	@Test
	public void test() {
		HashDice dices = new HashDice();
		dices.makeStatistic(5, 5);
	}

}
