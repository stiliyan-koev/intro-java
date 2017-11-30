/*
 * public void saveObject(String path, UserDefinedObject o) - запазва параметъра "o" в указания чрез path файл. Ако такъв файл не съществува - първо бива създаден.
   public UserDefinedObject getObject(String path) - прочита от указания чрез path файл инстанция на класа UserDefinedObject и я връща като резултат. Ако няма такъв файл - хвърля IOException.
 */
package com.sirma.itt.javacourse.input_output.data_class;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A class who writes and reads objects to a file.
 * 
 * @author Stiliyan Koev
 */
public class DataClass {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * A class writing the object to a file with given path from the user.
	 * 
	 * @param fileName
	 *            - The directory location given by the user.
	 * @param o
	 *            - An object given by the user.
	 * @throws IOException
	 *             - Input/Output exception may occur.
	 */
	public void saveObject(String fileName, Object o) throws IOException {
		if (doesFileExists(fileName)) {
			try (FileOutputStream fileOutput = new FileOutputStream(fileName);
					ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);) {

				objectOutput.writeObject(o);
			}
		} else {
			File directory = new File("target/DataClass");
			directory.mkdirs();
			File fileToSave = new File(directory, fileName);
			fileToSave.createNewFile();
			saveObject(fileName, o);
		}
	}

	/**
	 * A class reading an object from file.
	 * 
	 * @param path
	 *            - The location of file.
	 * @return - The read object.
	 */
	public Object getObject(String fileName) {
		if (doesFileExists(fileName)) {
			try (FileInputStream fileInput = new FileInputStream(fileName);
					ObjectInputStream objectInput = new ObjectInputStream(fileInput);) {

				return objectInput.readObject();

			} catch (IOException | ClassNotFoundException e) {
				LOGGER.error("Input/Output exception occured", e);
			}
		} else {
			LOGGER.info("File not found !");
		}
		return null;
	}

	/**
	 * Validates does the file exists and to be not a directory.
	 * 
	 * @param path
	 *            - Directory to the file.
	 * @return - True or False.
	 */
	public static boolean doesFileExists(String path) {
		File fileToWrite = new File("target/DataClass/" + path);

		if (fileToWrite.exists() && !fileToWrite.isDirectory()) {
			return true;
		} else {
			return false;
		}
	}
}