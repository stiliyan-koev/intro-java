package com.sirma.itt.javacourse.collections.dices;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HashDice task.
 * 
 * @author Stiliyan Koev.
 */
public class HashDice {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * Generates (rolls dices) a random number in the range of [1,M] twice. It
	 * saves the combination in a single string. The way it saves the
	 * combinations is always the lesser first and the greater dice second.
	 * Example: If first dice roll 5 and second is 2 it will return "2, 5".
	 * 
	 * @param m
	 *            - m sides of the dices.
	 * @return - returns a combination of both dices points.
	 */
	public String rollDice(int m) {
		Random rand = new Random();
		int firstDice = rand.nextInt(m) + 1;
		int secondDice = rand.nextInt(m) + 1;

		if (firstDice <= secondDice) {
			return (firstDice) + "," + (secondDice);
		} else {
			return (secondDice) + "," + (firstDice);
		}
	}

	/**
	 * Creates a HashMap<D,T> which stores the combinations with their threw. D
	 * stands for "dice combinations" and T for "when those combinations were
	 * threw".
	 * 
	 * @param m
	 *            - m sides of the dices.
	 * @param n
	 *            - n times the dices will be rolled.
	 * @return - Returns a Map representing a statistic of the thrown sides and
	 *         at which number of throwing they were in a combination.
	 */
	public Map<String, String> makeStatistic(int m, int n) {
		Map<String, String> threwStatistics = new HashMap<String, String>();
		String diceCombination = "";
		for (int i = 1; i <= n; i++) {
			diceCombination = rollDice(m);
			if (threwStatistics.containsKey(diceCombination)) {
				threwStatistics.put(diceCombination, threwStatistics.get(diceCombination) + ", " + Integer.toString(i));
			} else {
				threwStatistics.put(diceCombination, Integer.toString(i));
			}
		}
		printStatistics(threwStatistics);
		return threwStatistics;
	}

	/**
	 * Formatted printing for the statistics.
	 * 
	 * @param threwStatistics
	 *            - Contains all the data about the dice combinations.
	 */
	public void printStatistics(Map<String, String> threwStatistics) {
		for (Map.Entry<String, String> entry : threwStatistics.entrySet()) {
			String dices = entry.getKey() + ", " + entry.getValue();
			String firstDice = dices.substring(0, 1);
			String secondDice = dices.substring(2, 3);

			LOGGER.info("The combination: {} {} was threw at: {}", firstDice, secondDice,
					threwStatistics.get(dices.subSequence(0, 3)));
		}
	}
}
