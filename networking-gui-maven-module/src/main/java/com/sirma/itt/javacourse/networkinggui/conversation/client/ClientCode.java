package com.sirma.itt.javacourse.networkinggui.conversation.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import com.sirma.itt.javacourse.utilities.ConsoleWriter;
import com.sirma.itt.javacourse.utilities.NetworkUtil;

/**
 * Client Code for third task.
 * 
 * @author Stiliyan Koev
 */
public class ClientCode extends Thread {
	private ClientGUI clientGUI;

	/**
	 * Constructor.
	 * 
	 * @throws InterruptedException
	 *             - Interrupted exception may occur.
	 */
	public ClientCode() throws InterruptedException {
		clientGUI = new ClientGUI();
		connectToServer("localhost", NetworkUtil.getInstance().findPortForClient("localhost", 0));
	}

	/**
	 * Constructor.
	 * 
	 * @param port
	 *            - Port to use for connection. If given port is 0, the program
	 *            looks for free port by itself.
	 * 
	 * @throws InterruptedException-
	 *             Interrupted exception may occur.
	 */
	public ClientCode(int port) throws InterruptedException {
		clientGUI = new ClientGUI();
		connectToServer("localhost", NetworkUtil.getInstance().findPortForClient("localhost", port));
	}

	/**
	 * Connecting to server.
	 * 
	 * @param ip
	 *            - IP to be connected to.
	 * @param port
	 *            - Port to be connected to.
	 * @return - true if connection was successful.
	 * @throws InterruptedException
	 */
	public void connectToServer(String ip, int port) throws InterruptedException {
		ConsoleWriter.write("Connecting to " + "localhost" + " on port " + port);
		Socket client = null;
		try {
			client = new Socket(ip, port);
			ConsoleWriter.write("Just connected to " + client.getRemoteSocketAddress());
			String message = getMessageFromServer(client);
			sendMessageToConsole(message);
			clientGUI.setTextInTextField(message);
			if (!client.isConnected()) {
				clientGUI.setTextInTextField("Server was stopped !");
			}
			synchronized (this) {
				this.wait(2000);
			}
			client.close();
			clientGUI.dispose();

		} catch (IOException ex) {
			ConsoleWriter.write("I/O exception occured !" + ex);
		}
		try {
			client.close();
			clientGUI.dispose();
		} catch (IOException e) {
			ConsoleWriter.write("Exception occured !" + e.getMessage());
		}

	}

	/**
	 * Getting message from server.
	 * 
	 * @param client
	 *            - Client whos receiving message.
	 * @return - The message as String.
	 */
	public String getMessageFromServer(Socket client) {
		String message = "";
		try (InputStream inFromServer = client.getInputStream();
				DataInputStream in = new DataInputStream(inFromServer);) {
			message = in.readUTF();
		} catch (IOException e) {
		}
		return message;
	}

	/**
	 * Sending the message to console.
	 * 
	 * @param message
	 *            - The message.
	 */
	public void sendMessageToConsole(String message) {
		clientGUI.setTextInTextField(message);
		clientGUI.setTextInTextField("Sending message to console !");
		ConsoleWriter.write(message);
	}

	/**
	 * Getter for ClientGUI.
	 * 
	 * @return - ClientGUI clientGUI
	 */
	public ClientGUI getClientGUI() {
		return this.clientGUI;
	}

	/**
	 * Entry class for ClientCode.
	 * 
	 * @param args
	 *            - String arguments.
	 * @throws InterruptedException
	 *             - Interrupted exception may occur.
	 */
	public static void main(String[] args) throws InterruptedException {
		new ClientCode();
	}
}
