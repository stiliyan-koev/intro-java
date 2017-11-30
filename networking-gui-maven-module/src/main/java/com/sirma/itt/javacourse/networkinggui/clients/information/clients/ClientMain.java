package com.sirma.itt.javacourse.networkinggui.clients.information.clients;

import java.io.IOException;

import com.sirma.itt.javacourse.networkinggui.clients.information.client.ClientGUI;

/**
 * Main class for fourth task Client code.
 * 
 * @author Stiliyan Koev.
 */
public class ClientMain {
	/**
	 * Main class, entry point.
	 * 
	 * @param args
	 *            - String arguments.
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		new ClientGUI();
		new ClientGUI();
	}
}
