package com.sirma.itt.javacourse.privatefelds;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.itt.javacourse.utilities.ConsoleWriter;

/**
 * Private Fields task.
 * 
 * @author Stiliyan Koev
 */
public class PrivateFields {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * Public fields
	 */
	public PrivateFields() {

	}

	/**
	 * A method that is accessing private fields and gets their values.
	 * 
	 * @param <T>
	 * 
	 * @param fieldName
	 *            - The name of the private field which value we want to get.
	 * @param newClass
	 *            - The class of the private field to access.
	 * @throws NoSuchFieldException
	 *             - Throws an exception if there is No such field to access.
	 * @throws IllegalAccessException
	 *             - Throws an exception if a problem with the access occur.
	 * @throws InstantiationException
	 *             - Throws an exception if a problem with the instantiation
	 *             occur.
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 * 
	 */
	public <T> void getPrivateFieldValue(String fieldName, Class<T> newClass) throws InstantiationException {
		Object classInstance;
		try {
			classInstance = newClass.newInstance();
			Field privateStringField = newClass.getDeclaredField(fieldName);

			if (Modifier.isPrivate(privateStringField.getModifiers()) || !privateStringField.isAccessible()) {
				privateStringField.setAccessible(true);
			}
			LOGGER.info(privateStringField.get(classInstance).toString());
		} catch (IllegalAccessException e) {
			ConsoleWriter.write("IllegalAccessException occured !" + e);
		} catch (NoSuchFieldException e) {
			ConsoleWriter.write("NoSuchFieldException occured !" + e);
		} catch (SecurityException e) {
			ConsoleWriter.write("SecurityException occured !" + e);
		}

	}

	/**
	 * A method that is accessing private methods and gets their values.
	 * 
	 * @param methods
	 *            - methods to access.
	 * @param theClass
	 *            - the class which methods to access.
	 * 
	 * @throws NoSuchMethodException
	 *             - Throws an exception if there is No such field to access.
	 * @throws IllegalAccessException
	 *             - Throws an exception if a problem with the access occur.
	 * @throws InvocationTargetException
	 *             - Throws an exception if a problem occur with the invoke
	 *             function.
	 * @throws InstantiationException
	 */
	public <T> void getPrivateMethodValue(String[] methods, Class<T> theClass) throws InstantiationException {

		Object classInstance;
		try {
			classInstance = theClass.newInstance();
			for (int i = 0; i < methods.length; i++) {
				Method privateMethod = University.class.getDeclaredMethod(methods[i]);
				if (Modifier.isPrivate(privateMethod.getModifiers()) || !privateMethod.isAccessible()) {
					privateMethod.setAccessible(true);
				}
				LOGGER.info(privateMethod.invoke(classInstance).toString());

			}
		} catch (IllegalAccessException e) {
			ConsoleWriter.write("IllegalAccessException occured !" + e);
		} catch (NoSuchMethodException e) {
			ConsoleWriter.write("NoSuchMethodException occured !" + e);
		} catch (SecurityException e) {
			ConsoleWriter.write("SecurityException occured !" + e);
		} catch (IllegalArgumentException e) {
			ConsoleWriter.write("IllegalArgumentException occured !" + e);
		} catch (InvocationTargetException e) {
			ConsoleWriter.write("InvocationTargetException occured !" + e);
		}

	}
}
