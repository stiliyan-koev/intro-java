package com.sirma.itt.javacourse.reflannotregex;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import com.sirma.itt.javacourse.privatefelds.University;

public class PrivateFieldsTests {
	public static University university = new University();

	/**
	 * Testing does the code can access properly a private fields.
	 * 
	 * @throws NoSuchFieldException-
	 *             Throws an exception if there is No such field to access.
	 * @throws SecurityException
	 *             - Thrown by the security manager to indicate a security violation
	 * @throws IllegalArgumentException
	 *             - Thrown by the security manager to indicate a security violation
	 * @throws IllegalAccessException
	 *             * - Throws an exception if a problem with the access occur.
	 */
	@Test
	public void testPrivateFields()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		university.setPrivateString("This is a private string !");
		university.setPrivateNumber(15);

		Field privateStringField = University.class.getDeclaredField("privateString");
		privateStringField.setAccessible(true);
		assertEquals(privateStringField.get(university).toString(), "This is a private string !");

		privateStringField = University.class.getDeclaredField("privateNumber");
		privateStringField.setAccessible(true);
		assertEquals(privateStringField.get(university).toString(), "15");

	}

	/**
	 * Testing does the code can access properly a private methods.
	 * 
	 * @throws NoSuchFieldException-
	 *             Throws an exception if there is No such field to access.
	 * @throws SecurityException
	 *             - Thrown by the security manager to indicate a security violation
	 * @throws IllegalArgumentException
	 *             - Thrown by the security manager to indicate a security violation
	 * @throws IllegalAccessException
	 *             * - Throws an exception if a problem with the access occur.
	 * @throws InvocationTargetException
	 *             - InvocationTargetException is a checked exception that wraps an exception thrown by an invoked
	 *             method or constructor.
	 */
	@Test
	public void testPrivateMethods() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		university.setStudentName("Stiliyan Koev");
		university.setFacultyNumber(146512);
		university.setStudentCourse(4);

		Method privateStringMethod = University.class.getDeclaredMethod("getStudentName");
		privateStringMethod.setAccessible(true);
		assertEquals(privateStringMethod.invoke(university).toString(), "Stiliyan Koev");

		privateStringMethod = University.class.getDeclaredMethod("getFacultyNumber");
		privateStringMethod.setAccessible(true);
		assertEquals(privateStringMethod.invoke(university).toString(), "146512");

		privateStringMethod = University.class.getDeclaredMethod("getStudentCourse");
		privateStringMethod.setAccessible(true);
		assertEquals(privateStringMethod.invoke(university).toString(), "4");

	}

}
