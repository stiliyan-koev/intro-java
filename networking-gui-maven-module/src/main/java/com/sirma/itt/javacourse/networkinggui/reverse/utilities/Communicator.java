package com.sirma.itt.javacourse.networkinggui.reverse.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.sirma.itt.javacourse.networkinggui.reverse.memento.Originator;
import com.sirma.itt.javacourse.utilities.ConsoleWriter;

/**
 * Communicator class which task is to take the messages from client and to pass
 * them back, but reversed.
 * 
 * @author Stiliyan Koev
 */
public class Communicator extends Thread {
	private ObjectOutputStream obj;
	private ObjectInputStream objReader;
	private Socket client;

	/**
	 * Constructor.
	 * 
	 * @param client
	 *            - Client from which receve and sends messages.
	 * @param out
	 *            - OutputStream.
	 * @param obj
	 *            - ObjectOutputStream.
	 */
	public Communicator(Socket client, OutputStream out, ObjectOutputStream obj) {
		this.obj = obj;
		this.client = client;
	}

	@Override
	public void run() {
		Originator memento = Originator.getInstance();
		while (!client.isClosed()) {
			try {
				String message = readClientMessage();
				if (!".".equals(message)) {
					writeRevеrsedMessage(message, memento);
				}
			} catch (IOException | ClassNotFoundException e) {
				ConsoleWriter.getLogger().warn("IO Exception occured or client was closed !" + e);
				break;
			}
		}
		super.run();
	}

	/**
	 * Read the message from client.
	 * 
	 * @return - the message as String.
	 * @throws ClassNotFoundException
	 *             - may occur.
	 * @throws IOException
	 *             - may occur.
	 */
	public String readClientMessage() throws ClassNotFoundException, IOException {
		if (objReader == null) {
			InputStream in = client.getInputStream();
			objReader = new ObjectInputStream(in);
		}
		return (String) objReader.readObject();

	}

	/**
	 * Reversing the message and sends it back to client.
	 * 
	 * @param message
	 *            - The message.
	 * @param memento
	 *            - Instance of Memento design pattern.
	 * @throws IOException
	 *             - may occur.
	 */
	public void writeRevеrsedMessage(String message, Originator memento) throws IOException {
		if (!message.equals(null)) {
			memento.addToMemento(message);
			StringBuilder reverser = new StringBuilder(message);
			String wholeMessage = "The reverse of<" + message + "> is <" + reverser.reverse().toString() + ">";
			obj.writeObject(wholeMessage);
		}
	}
}
