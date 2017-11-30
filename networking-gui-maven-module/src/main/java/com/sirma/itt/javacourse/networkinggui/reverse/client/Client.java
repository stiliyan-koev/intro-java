package com.sirma.itt.javacourse.networkinggui.reverse.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.sirma.itt.javacourse.utilities.ConsoleWriter;
import com.sirma.itt.javacourse.utilities.NetworkUtil;

/**
 * Client for fifth task.
 * 
 * @author Stiliyan Koev
 */
public class Client extends Thread {

	private ClientGUI clientGUI;
	private Socket client;
	private ObjectOutputStream writeToServer;
	private Object lock = new Object();
	private int portToConnect = 0;

	/**
	 * Constructor
	 * 
	 * @param gui
	 *            - Graphical User Interface of Client.
	 * @param port
	 *            - Port to use for connection. If given port is 0, the program
	 *            looks for free port by itself.
	 */
	public Client(ClientGUI gui, int port) {
		super("Client");
		this.clientGUI = gui;
		this.portToConnect = port;
	}

	@Override
	public void run() {
		String message = "";
		synchronized (lock) {
			try (Socket client = connectToServer();
					InputStream inFromServer = client.getInputStream();
					ObjectInputStream objectInput = new ObjectInputStream(inFromServer);) {
				readWelcomeMessage(objectInput);
				do {
					try {
						lock.wait();
					} catch (InterruptedException e) {
					}
					message = sendMessageForReversing();
					if (!message.equals(".")) {
						getAndPrintReversedMessage(objectInput);
					}

				} while (!(".".equals(message)));
				closeClient();
			} catch (IOException | ClassNotFoundException e) {
			}
		}
	}

	/**
	 * Establish connection to server socket.
	 * 
	 * @return - The socket with connection.
	 */
	public Socket connectToServer() {
		ConsoleWriter.write("Connecting");
		try {
			client = new Socket("localhost", NetworkUtil.getInstance().findPortForClient("localhost", portToConnect));
		} catch (IOException e) {
			ConsoleWriter.getLogger().warn("IO exception occured !" + e);
		}
		return client;
	}

	/**
	 * Gets the reversed message from Server (Communicator) and prints it in
	 * textArea.
	 * 
	 * @param objectInput
	 *            - The input stream.
	 * @throws ClassNotFoundException
	 *             - may occur.
	 * @throws IOException
	 *             - may occur.
	 */
	public void getAndPrintReversedMessage(ObjectInputStream objectInput) throws ClassNotFoundException, IOException {
		String message = (String) objectInput.readObject();
		clientGUI.setTextInTextField(message);
		clientGUI.setTextToTextArea(message);
	}

	/**
	 * Sends message to be reversed.
	 * 
	 * @throws IOException
	 *             - may occur.
	 */
	public String sendMessageForReversing() throws IOException {
		String message = clientGUI.getTextFromTextField();
		sendTextMessageToServer(message);
		return message;
	}

	/**
	 * Reads the welcome message sent from Server.
	 * 
	 * @param objectInput
	 *            - Input stream.
	 * @throws ClassNotFoundException
	 *             - may occur.
	 * @throws IOException
	 *             - may occur.
	 */
	public void readWelcomeMessage(ObjectInputStream objectInput) throws ClassNotFoundException, IOException {
		String message = (String) objectInput.readObject(); // reads_welcome_message
		clientGUI.setTextInTextField(message);
	}

	/**
	 * Send message to server.
	 * 
	 * @param message
	 *            - the message.
	 * @throws IOException
	 *             - may occur.
	 */
	public void sendTextMessageToServer(String message) throws IOException {
		if (writeToServer == null) {
			OutputStream outToServer = client.getOutputStream();
			writeToServer = new ObjectOutputStream(outToServer);
			writeToServer.writeObject(message);
		} else {
			writeToServer.writeObject(message);
		}
	}

	/**
	 * Notifying the reader that there is message to be read.
	 */
	public void notifyTheReader() {
		synchronized (lock) {
			lock.notify();
		}
	}

	/**
	 * Closing the client.
	 */
	public void closeClient() {
		try {
			client.close();
			clientGUI.dispose();
			clientGUI.setVisible(false);
		} catch (IOException e) {
			ConsoleWriter.getLogger().warn("IO exception occured !" + e);
		}
	}
}
