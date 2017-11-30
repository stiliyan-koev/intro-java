package org.input.output.module;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import com.sirma.itt.javacourse.input_output.directory_browser.DirectoryBrowser;

/**
 * JUnit tests for {@link DirectoryBrowser}.
 * 
 * @author Stiliyan Koev.
 */
public class DirectoryBrowserTests {
	/**
	 * Testing isFile(file) returns correct boolean answers for a file and
	 * directory.
	 */
	@Test
	public void testIsFileOrLocation() {
		String fileDirectory = "target/directoryBrowser/first text file.txt";
		String justDirectory = "target/directoryBrowser/";

		File directoryToAccess = new File(fileDirectory);
		assertEquals(DirectoryBrowser.isFile(directoryToAccess), true);

		directoryToAccess = new File(justDirectory);
		assertEquals(DirectoryBrowser.isFile(directoryToAccess), false);
	}

}
