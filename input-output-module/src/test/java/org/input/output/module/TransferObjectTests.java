package org.input.output.module;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import com.sirma.itt.javacourse.input_output.reverse_text_file.ReverseTextFile;
import com.sirma.itt.javacourse.input_output.transfer_object.TransferObject;

/**
 * JUnit tests for {@link TransferObject}.
 * 
 * @author Stiliyan Koev
 */
public class TransferObjectTests {
	/**
	 * Testing a byte transfer. The "in.txt" file contains: Hello brother how
	 * are you ?
	 * 
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException {

		FileInputStream in = new FileInputStream("target/byteTransfer/tests/in.txt");
		FileOutputStream out = new FileOutputStream("target/byteTransfer/tests/out.txt");

		TransferObject byter = new TransferObject(in, out);
		int transfered = byter.transfer(15, 5);
		assertEquals(transfered, 15);

		BufferedReader input = new BufferedReader(new FileReader("target/byteTransfer/tests/out.txt/"));

		String actual = ReverseTextFile.readInputFromFile(input).toString();

		assertEquals(" brother how ar\n", actual);
	}

}
