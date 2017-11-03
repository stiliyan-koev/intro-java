package com.sirma.itt.javacourse.instantiate;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A run class for Instantiate a Class By Name task.
 * 
 * @author Stiliyan Koev.
 */
public class InstantiateClassByNameRunClass {
	/**
	 * Private constructor
	 */
	private InstantiateClassByNameRunClass() {

	}

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * Entry Main class for {@InstantiateClassByNameRunClass}.
	 * 
	 * @param args
	 *            - Some string arguments.
	 * @throws InstantiationException
	 *             - Throws an exception if a problem occurs while instantiating
	 *             a class by name.
	 * @throws IllegalAccessException
	 *             - Throws an exception if an Illegal Access occurs.
	 * @throws ClassNotFoundException
	 *             - Throws an exception if the class that we want to
	 *             instantiate by name is not found.
	 */
	public static void main(String[] args) {
		try {
			Class<?> car = Class.forName("com.sirma.itt.javacourse.instantiate.Car");
			Car mercedes = (Car) car.newInstance();
			Class<?>[] interfacesArray = mercedes.getClass().getSuperclass().getInterfaces();
			LOGGER.info(mercedes.getClass().getSuperclass().toString());
			LOGGER.info("And the simple name: " + mercedes.getClass().getSuperclass().getSimpleName());
			for (Class<?> interfaces : interfacesArray) {
				LOGGER.info(interfaces.toString());
			}
			mercedes.startTheEngine();
			mercedes.revvingTheEngine();
			mercedes.gearUp();
			mercedes.gearDown();
		} catch (InstantiationException ie) {
			LOGGER.error("InstantiationException occured !", ie);
		} catch (IllegalAccessException iae) {
			LOGGER.error("IllegalAccessException occured !", iae);
		} catch (ClassNotFoundException cnfe) {
			LOGGER.error("ClassNotFoundException occured !", cnfe);
		}

	}

}
