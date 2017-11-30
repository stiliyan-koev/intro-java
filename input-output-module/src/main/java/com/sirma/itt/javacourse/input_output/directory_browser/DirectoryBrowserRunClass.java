package com.sirma.itt.javacourse.input_output.directory_browser;

public class DirectoryBrowserRunClass {
	/**
	 * Main entry point for {@link DirectoryBrowser} class.
	 * 
	 * @param args
	 *            - String arguments.
	 */
	public static void main(String[] args) {
		DirectoryBrowser directoryBrowser = new DirectoryBrowser();
		String directory = directoryBrowser.getUserDirectory();
		directoryBrowser.listContent(directory);
	}
}
