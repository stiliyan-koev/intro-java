package com.sirma.itt.javacourse.instantiate;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A class Vehicles superclass of Car, implementing the "gearbox" from Engine interface.
 * 
 * @author Stiliyan Koev
 */
public class Vehicles implements Engine {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * Implemented abstract class from {@Engine} interface. It is just printing the sound of engine when it is started.
	 * 
	 */
	@Override
	public void startTheEngine() {
		LOGGER.info("Vrom vrom vrom vrom");
	}

	/**
	 * Implemented abstract class from {@Engine} interface. It is just printing the sound of engine when it is revved.
	 * {@inheritDoc}
	 */
	@Override
	public void revvingTheEngine() {
		LOGGER.info("Vrooooooooooooooooom don don don don don");
	}
}
