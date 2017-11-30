package com.sirma.itt.javacourse.networkinggui.clients.information.clients;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Clients.
 * 
 * @author Stiliyan Koev
 */
public class Clients extends Thread {
	static AtomicInteger id = new AtomicInteger(0);
	private ObjectOutputStream out;

	/**
	 * Constructor.
	 */
	public Clients() {
		id.incrementAndGet();
	}

	/**
	 * Getter for id.
	 * 
	 * @return - id.
	 */
	public static int getID() {
		return id.get();
	}

	/**
	 * Sends welcome mesasge to exact client.
	 * 
	 * @param out
	 *            - OutputStream to the exact client.
	 * @throws IOException
	 *             - Input/Output exception may occur.
	 */
	public void sendWelcomeMessageToExactClient(ObjectOutputStream out) throws IOException {
		this.out = out;
		out.writeObject("Hi. ID: " + id.toString());
	}

	/**
	 * Sends message to all clients.
	 * 
	 * @param message
	 *            - the message to be send.
	 * @throws IOException
	 *             - Input/Output exception may occur.
	 */
	public void sendMessageToClient(String message) throws IOException {
		out.writeObject(message);
	}
}
