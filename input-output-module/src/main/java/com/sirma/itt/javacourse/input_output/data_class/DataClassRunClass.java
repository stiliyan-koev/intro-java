package com.sirma.itt.javacourse.input_output.data_class;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.itt.javacourse.input_output.console_to_file.ConsoleToFile;
import com.sirma.itt.javacourse.utilities.ConsoleReader;

public class DataClassRunClass {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * Main entry point showing the result of execution of the code.
	 * 
	 * @param args
	 *            - String arguments.
	 * @throws IOException
	 *             - Input/Output exception may occur.
	 */
	public static void main(String[] args) {
		DataClass objectReadWrite = new DataClass();
		LOGGER.info("Type in the name of the file you want to save in: ");
		String userFile = ConsoleToFile.validateFileName(ConsoleReader.read());

		LOGGER.info("Writing and then reading a Date() object to/from file");
		try {
			objectReadWrite.saveObject(userFile, new Date());
			Object retriever = objectReadWrite.getObject(userFile);
			if (retriever instanceof Date) {
				LOGGER.info(((Date) retriever).toString() + System.lineSeparator());
			} else {
				LOGGER.info("Not found ! ");
			}
			LOGGER.info("Writing and then reading a Int() object to/fropm output.ser file");
			objectReadWrite.saveObject(userFile, 123456);

			LOGGER.info("" + objectReadWrite.getObject(userFile));
		} catch (IOException e) {
			LOGGER.error("Input/Output error occured.", e);
		}
	}
}