package com.sirma.itt.javacourse.input_output.console_to_file;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.itt.javacourse.utilities.ConsoleReader;

/**
 * Run class for {@link ConsoleToFile} class.
 * 
 * @author Stiliyan Koev
 */
public class ConsoleToFileRunClass {
	public static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * Main entry point for {@link ConsoleToFileRunClass}.
	 * 
	 * @param args
	 *            - String arguments.
	 * @throws IOException
	 *             - Input/Output exception may occur during execution.
	 */
	public static void main(String[] args) {
		File directory = new File("target/consoleToFile");
		ConsoleToFile consoleToFile = new ConsoleToFile();
		String fileName = consoleToFile.validateFileName(ConsoleReader.read());
		DataOutputStream out = null;
		directory.mkdirs();
		try {
			File tempFile = new File(directory, fileName);
			tempFile.createNewFile();
			out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
			out.writeUTF(ConsoleToFile.userConsoleInputToString().toString());

		} catch (IOException ioex) {
			LOGGER.error("Input/Output error occured.", ioex);
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				LOGGER.error("Input/Output error occured.", e);
			}
		}
	}
}
