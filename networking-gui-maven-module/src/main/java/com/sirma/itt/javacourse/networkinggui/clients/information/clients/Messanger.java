package com.sirma.itt.javacourse.networkinggui.clients.information.clients;

import java.io.IOException;
import java.util.List;

import com.sirma.itt.javacourse.utilities.ConsoleWriter;

/**
 * Messager for sending messages to clients.
 * 
 * @author Stiliyan Koev.
 */
public class Messanger extends Thread {
	private List<Clients> clients;

	/**
	 * Constructor
	 * 
	 * @param clients
	 *            - List of clients already connected.
	 */
	public Messanger(List<Clients> clients) {
		this.clients = clients;
		this.start();
	}

	@Override
	public void run() {
		synchronized (this) {
			try {
				welcomeMessage();
			} catch (IOException ex) {
				ConsoleWriter.write("Exception occured !" + ex.getMessage());
			}
		}
	}

	/**
	 * Sends welcome message to the clients.
	 * 
	 * @throws IOException
	 *             - IOexception may occur.
	 */
	public void welcomeMessage() throws IOException {
		for (Clients clientProfile : clients) {
			clientProfile.sendMessageToClient("Client with ID: " + Clients.id + " connected !");
		}
	}
}
