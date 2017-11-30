package com.sirma.itt.javacourse.input_output.transfer_object;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.itt.javacourse.utilities.ConsoleReader;

public class TransferObjectRunClass {
	public static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public static void main(String[] args) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;

		try {
			in = new FileInputStream("target/byteTransfer/in.txt");
			out = new FileOutputStream("target/byteTransfer/out.txt");
			TransferObject byter = new TransferObject(in, out);
			LOGGER.info("Type in the number of bytes you want to transfer: ");
			int numOfBytes = ConsoleReader.readInt();
			LOGGER.info("Type in the number of offset: ");
			int offset = ConsoleReader.readInt();
			byter.transfer(numOfBytes, offset);

		} catch (IOException ioe) {
			LOGGER.error("Input/Output exception occured.", ioe);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (Exception e) {
				LOGGER.error("Input/Output exception occured.", e);
			}
		}
	}
}