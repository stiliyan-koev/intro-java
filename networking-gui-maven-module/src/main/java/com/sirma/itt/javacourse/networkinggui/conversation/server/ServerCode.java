package com.sirma.itt.javacourse.networkinggui.conversation.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.swing.JFrame;

import com.sirma.itt.javacourse.utilities.ConsoleWriter;
import com.sirma.itt.javacourse.utilities.NetworkUtil;

/**
 * Server code for third task.
 * 
 * @author Stiliyan Koev
 */
public class ServerCode extends Thread {
	private ServerSocket serverSocket;
	private ServerGUI gui;
	private Socket server;
	private DataOutputStream out;
	private boolean serverRunning = true;

	/**
	 * Constructor with GUI.
	 * 
	 * @param gui
	 *            - The GUI of Server.
	 * @throws IOException
	 *             - Input/Output exception may occur.
	 */
	public ServerCode(ServerGUI gui) throws IOException {
		this.serverSocket = NetworkUtil.getInstance().createServer(0, "localhost");
		this.gui = gui;
		gui.setSize(250, 400);
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setResizable(false);
	}

	/**
	 * 
	 * @param gui
	 *            - The GUI of Server.
	 * @param port
	 *            - Port to use for connection. If given port is 0, the program
	 *            looks for free port by itself.
	 * @throws IOException
	 *             - Input/Output exception may occur.
	 */
	public ServerCode(ServerGUI gui, int port) throws IOException {
		this.serverSocket = NetworkUtil.getInstance().createServer(port, "localhost");
		this.gui = gui;
		gui.setSize(250, 400);
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setResizable(false);
	}

	@Override
	public void run() {
		gui.setTextInTextField("Server started !");
		while (serverRunning || !serverSocket.isClosed()) {
			synchronized (this) {
				ConsoleWriter.write("Waiting for client on port " + serverSocket.getLocalPort() + "...");
				server = establishConnection(serverSocket);
				if (server != null) {
					if (server.isConnected()) {
						ConsoleWriter.write("Just connected to " + server.getRemoteSocketAddress());
						gui.setConnected();
					}
					sendMessageToClient();
				}
			}
		}
	}

	/**
	 * Close the server.
	 */
	public synchronized void closeServer() {
		try {
			serverRunning = false;
			out.writeUTF("Server was stopped !");
			serverSocket.close();
			server.close();
			gui.dispose();
		} catch (IOException e) {
			ConsoleWriter.write("I/O exception occured !" + e);
		}
	}

	/**
	 * Sending message to client socket.
	 */
	public void sendMessageToClient() {
		try {
			out = new DataOutputStream(server.getOutputStream());
			Date date = new Date();
			gui.setTextInTextField("Sending Hello message and date");
			out.writeUTF("Hello !" + date.toString());
			gui.setTextInTextField("Message sent !");
		} catch (IOException e) {
			ConsoleWriter.write("I/O exception occured !" + e);
		}
	}

	/**
	 * Set a boolean showing when the server is working.
	 * 
	 * @param status
	 *            - True to work, false to stop it.
	 */
	public void setServerRunning(boolean status) {
		this.serverRunning = status;
	}

	/**
	 * Establish connection if there is socket to be accepted. It has Timeout of
	 * 50 ms, so it could be interrupted by Stop Server button.
	 * 
	 * @param serverSocket
	 *            - The server.
	 * @return - A socket with connection.
	 */
	public Socket establishConnection(ServerSocket serverSocket) {
		Socket client = null;
		do {
			if (!serverRunning) {
				closeServer();
				break;
			}
			synchronized (this) {
				try {
					serverSocket.setSoTimeout(50);
					client = serverSocket.accept();
				} catch (IOException e) {
					ConsoleWriter.write("I/O exception occured !" + e);
				}
			}
		} while (client == null);
		return client;
	}
}