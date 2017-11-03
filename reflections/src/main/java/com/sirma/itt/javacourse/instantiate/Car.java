package com.sirma.itt.javacourse.instantiate;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A class representing a gearbox of a Car.
 * 
 * @author Stiliyan Koev.
 */
public class Car extends Vehicles {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * This method is just printing "Changed the gear up", nothing more.
	 */
	public void gearUp() {
		LOGGER.info("Changed the gear up");
	}

	/**
	 * This method is just printing "Changed the gear down", nothing more.
	 */
	public void gearDown() {
		LOGGER.info("Changed the gear down");
	}
}
