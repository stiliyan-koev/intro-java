package com.sirma.itt.javacourse.input_output.transfer_object;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Transfer Object task.
 * 
 * @author Stiliyan Koev
 */
public class TransferObject {
	public FileInputStream in = null;
	public FileOutputStream out = null;
	public static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * Default constructor.
	 */
	public TransferObject() {

	}

	/**
	 * Consctructor with two parameters (FileInputStream in, FileOutputStream
	 * out).
	 * 
	 * @param in
	 *            - FileInputStream given by user. It contains information about
	 *            from which file the code is going to read.
	 * @param out
	 *            - FileOutputStream given by user. It contains information
	 *            about to which file the code is giong to write.
	 */
	public TransferObject(FileInputStream in, FileOutputStream out) {
		this.in = in;
		this.out = out;
	}

	/**
	 * Transfering bytes one by one.
	 * 
	 * @param numberOfBytes
	 *            - A number given by user, telling how many bytes to transfer.
	 * @param offset
	 *            - A number given by user, telling how many bytes to be skipped
	 *            from the beginning.
	 * @return - Returns a number of the total transferred bytes.
	 * @throws IOException
	 *             - Input/Output exception may occur.
	 */
	public int transfer(int numberOfBytes, int offset) {
		int counter = 0;
		int byteCounter = 0;
		int c;
		try {
			while ((c = in.read()) != -1) {
				counter++;
				if (counter > offset && counter <= offset + numberOfBytes) {
					out.write(c);
					byteCounter++;
				}

			}
		} catch (IOException e) {
			LOGGER.error("Input/Output exception occured.", e);

		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				LOGGER.error("Input/Output exception occured.", e);
			}
		}

		return byteCounter;
	}
}