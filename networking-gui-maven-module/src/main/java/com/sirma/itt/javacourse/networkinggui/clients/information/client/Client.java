package com.sirma.itt.javacourse.networkinggui.clients.information.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

import com.sirma.itt.javacourse.utilities.ConsoleWriter;
import com.sirma.itt.javacourse.utilities.NetworkUtil;

/**
 * Client presentation for fourth task.
 * 
 * @author Stiliyan Koev
 */
public class Client extends Thread {
	private ClientGUI clientGUI;
	private int portToUse = 0;

	/**
	 * Constructor.
	 * 
	 * @param gui
	 *            - Graphical User Interface.
	 */
	public Client(ClientGUI gui) {
		this.clientGUI = gui;
	}

	/**
	 * Constructor.
	 * 
	 * @param gui
	 *            - Graphical User Interface.
	 * @param port
	 *            - Port to use for connection. If given port is 0, the program
	 *            looks for free port by iteslf.
	 */

	public Client(ClientGUI gui, int port) {
		this.clientGUI = gui;
		this.portToUse = port;
	}

	@Override
	public void run() {
		synchronized (this) {
			Socket client = null;
			ConsoleWriter.write("Connecting");
			client = connectToServer(client, portToUse);

			try (InputStream inFromServer = client.getInputStream();
					ObjectInputStream objectInput = new ObjectInputStream(inFromServer)) {
				readFirstMessageFromServer(objectInput);
				startEndlessLoopForReading(client, objectInput);

			} catch (IOException | ClassNotFoundException e) {
				ConsoleWriter.getLogger().warn("Exception occured !" + e);
				serverStopped();
			}

		}
	}

	/**
	 * Reads the first message, which is welcome message.
	 * 
	 * @param objectInput
	 *            - InputStream for data transfer.
	 * @throws ClassNotFoundException
	 *             - may occur.
	 * @throws IOException
	 *             - may occur.
	 */
	public void readFirstMessageFromServer(ObjectInputStream objectInput) throws ClassNotFoundException, IOException {
		String message = (String) objectInput.readObject(); // reads ID
		clientGUI.setTextInTextField(message);
	}

	/**
	 * Starts an endless loop for reading messages.
	 * 
	 * @param client
	 *            - The client who's receiving messages.
	 * @param objectInput
	 *            - InputStream for data transfer.
	 * @throws ClassNotFoundException
	 *             - may occur.
	 * @throws IOException
	 *             - may occur.
	 */
	public void startEndlessLoopForReading(Socket client, ObjectInputStream objectInput)
			throws ClassNotFoundException, IOException {

		while (client.isConnected()) {
			String message = (String) objectInput.readObject();
			ConsoleWriter.write(message);
			clientGUI.setTextInTextField(message);
		}

	}

	/**
	 * Dispose the client when server is stopped.
	 */
	public void serverStopped() {
		clientGUI.setTextInTextField("Server was stopped !");
		clientGUI.dispose();
	}

	/**
	 * 
	 * @param client
	 * @return
	 */
	public Socket connectToServer(Socket client, int port) {

		try {
			client = new Socket("localhost", NetworkUtil.getInstance().findPortForClient("localhost", port));
		} catch (IOException e) {
			ConsoleWriter.getLogger().warn("IO Exception occured !" + e);
		}
		ConsoleWriter.write("Just connected to " + client.getRemoteSocketAddress());
		return client;
	}

}