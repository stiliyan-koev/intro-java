package com.sirma.itt.javacourse.input_output.directory_browser;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.itt.javacourse.utilities.ConsoleReader;

/**
 * This class is checking is the path entered by the user, leads to a file or a
 * directory. If it is a directory - it prints all the files and folders within
 * it.
 * 
 * @author Stiliyan Koev.
 */
public class DirectoryBrowser {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * If the isFile(File) function return true, this means the path is pointing
	 * a file. So the LOGGER is printing "It is a file", else if it false, this
	 * means the path is leading to a directory and the "for loop" prints every
	 * file and folder within the directory.
	 * 
	 * @param path
	 *            - Path entered by the user, represented as String.
	 */
	public void listContent(String path) {
		File directoryToAccess = new File(path);
		if (isFile(directoryToAccess)) {
			LOGGER.info("The path u entered is pointing a file !");
		} else {
			LOGGER.info("The path you entered is pointing a directory and it contains: ");

			Path dir = Paths.get(directoryToAccess.getPath());
			try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
				for (Path file : stream) {
					LOGGER.info(file.getFileName().toString() + System.lineSeparator());
				}
			} catch (IOException e) {
				LOGGER.error("Probably you entered something that which os not a file nor a directory location !", e);

			}
		}
	}

	/**
	 * This checks is the path leading to a file or to a directory. If it is a
	 * file it returns true, if it is a directory it returns false.
	 * 
	 * @param pointingPath
	 *            - The path entered by the user.
	 * @return - True - for file; False - for directory.
	 */
	public boolean isFile(File pointingPath) {
		if (pointingPath.exists() && pointingPath.isFile()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Getting the path entered by the user.
	 * 
	 * @return - String representing the path.
	 */
	public String getUserDirectory() {
		LOGGER.info("Type in the full or short path of your directory: ");
		return ConsoleReader.read();
	}
}
