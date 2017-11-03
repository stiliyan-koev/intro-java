package com.sirma.itt.javacourse.reflannotregex;

import static org.junit.Assert.*;
import org.junit.Test;
import com.sirma.itt.javacourse.instantiate.Car;

/**
 * JUnit tests for {@InstantiateClassByNameRunClass}
 * 
 * @author Stiliyan Koev.
 */
public class InstantiateClassByNameTests {

	/**
	 * Testing instantiation by name and: getting the super class, getting the superclass simple name and getting all of
	 * the interfaces implemented and also testing its methods.
	 * 
	 * @throws InstantiationException
	 *             - Exception thrown when an instantiation problem occur.
	 * @throws IllegalAccessException
	 *             - Exception thrown when an access problem occur.
	 */
	@Test
	public void test() throws InstantiationException, IllegalAccessException {
		Car bmw = Car.class.newInstance();

		assertEquals("class com.sirma.itt.javacourse.instantiate.Vehicles", bmw.getClass().getSuperclass().toString());

		assertEquals("Vehicles", bmw.getClass().getSuperclass().getSimpleName().toString());

		Class<?>[] interfacesArray = bmw.getClass().getSuperclass().getInterfaces();
		String[] interfaceArray = new String[interfacesArray.length];
		interfaceArray[0] = "interface com.sirma.itt.javacourse.instantiate.Engine";

		for (Class<?> interfaces : interfacesArray) {
			assertEquals(interfaceArray[0], interfaces.toString());
		}

		try {
			bmw.startTheEngine();
			bmw.revvingTheEngine();
			bmw.gearUp();
			bmw.gearDown();

		} catch (Exception e) {

		}
	}

}
