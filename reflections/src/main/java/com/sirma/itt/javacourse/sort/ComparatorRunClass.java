package com.sirma.itt.javacourse.sort;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Run class for @CustomComparator.
 * 
 * @author Stiliyan Koev.
 */
public class ComparatorRunClass {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * Private fields
	 */
	private ComparatorRunClass() {

	}

	/**
	 * Entry class.
	 * 
	 * @param args
	 *            - String arguments.
	 */
	public static void main(String[] args) {

		List<Human> list = new ArrayList<>();

		list.add(new Father("Asen"));
		list.add(new Mother("Mariq"));
		list.add(new Child("Ivancho"));
		LOGGER.info(list.toString());

		Collections.sort(list, new CustomComparator());

		LOGGER.info(list.toString());

	}
}
