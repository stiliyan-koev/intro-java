package com.sirma.itt.javacourse.networkinggui.reverse.utilities;

import com.sirma.itt.javacourse.networkinggui.reverse.client.ClientGUI;
import com.sirma.itt.javacourse.networkinggui.reverse.server.ServerGUI;

/**
 * Main entry class for fifth task.
 * 
 * @author Stiliyan Koev
 */
public class Main {
	/**
	 * Main entry point.
	 * 
	 * @param args
	 *            - String arguments.
	 */
	public static void main(String[] args) {
		new ServerGUI(0);
		new ClientGUI(0);
	}
}
