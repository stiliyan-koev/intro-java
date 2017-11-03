package com.sirma.itt.javacourse.privatefelds;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Run class for Private Fields and Methods task.
 * 
 * @author Stiliyan Koev
 */
public class PrivateFieldsRunClass {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * Private fields
	 */
	private PrivateFieldsRunClass() {

	}

	/**
	 * An entry man method for {@PrivateFieldsRunClass}.
	 * 
	 * @param args
	 *            - Some string arguments.
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException-
	 *             Throws an exception if a problem occur with the invoke
	 *             function.
	 * @throws NoSuchMethodException
	 *             - Throws an exception if there is No such field to access.
	 */
	public static void main(String[] args) throws InstantiationException, ClassNotFoundException {

		University unv = new University();
		unv.setPrivateString("This is a private string !");
		unv.setPrivateNumber(15);
		unv.setStudentName("Stiliyan Koev");
		unv.setFacultyNumber(146512);
		unv.setStudentCourse(4);

		PrivateFields fields = new PrivateFields();
		String[] methodsNameArray = { "getStudentName", "getFacultyNumber", "getStudentCourse" };

		LOGGER.info("Accessing private fields: ");
		fields.getPrivateFieldValue("privateString", University.class);
		fields.getPrivateFieldValue("privateNumber", University.class);
		LOGGER.info("\nAccessing private methods: ");
		fields.getPrivateMethodValue(methodsNameArray, University.class);

	}
}
