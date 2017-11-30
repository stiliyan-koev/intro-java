package com.sirma.itt.javacourse.networkinggui.clients.information.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.sirma.itt.javacourse.networkinggui.clients.information.clients.Clients;
import com.sirma.itt.javacourse.networkinggui.clients.information.clients.Messanger;
import com.sirma.itt.javacourse.utilities.ConsoleWriter;
import com.sirma.itt.javacourse.utilities.NetworkUtil;

/**
 * Presents server for fourth task.
 * 
 * @author Stiliyan Koev.
 */
public class Server extends Thread {
	private ServerSocket serverSocket;
	private ServerGUI serverGUI;
	private Socket client;
	private List<Clients> listWithClients = new ArrayList<Clients>();
	private boolean serverRunning = true;

	/**
	 * Constructor.
	 * 
	 * @param serverGUI
	 *            - Server Graphical User Interface
	 * @throws IOException
	 *             - may occur
	 */
	public Server(ServerGUI serverGUI) throws IOException {
		this.serverSocket = NetworkUtil.getInstance().createServer(0, "localhost");
		this.serverGUI = serverGUI;
		this.start();
	}

	/**
	 * 
	 * @param serverGUI
	 *            - Server Graphical User Interface.
	 * @param port
	 *            - Port to use for connection. If given port is 0, the program
	 *            looks for free port by itself.
	 * @throws IOException
	 *             - may occur.
	 *
	 *
	 */
	public Server(ServerGUI serverGUI, int port) throws IOException {
		this.serverSocket = NetworkUtil.getInstance().createServer(port, "localhost");
		this.serverGUI = serverGUI;
		this.start();
	}

	@Override
	public void run() {
		while (!serverSocket.isClosed() || serverRunning) {
			synchronized (this) {
				ConsoleWriter.write("Waiting for client on port " + serverSocket.getLocalPort() + "...");
				client = establishConnection(serverSocket);
				serverGUI.setTextInTextField("User connected !");
				sendIDToClients();
			}
		}
	}

	/**
	 * Sends ID to connected client on OutputStream.
	 */
	public void sendIDToClients() {
		OutputStream out;
		try {
			out = client.getOutputStream();
			ObjectOutputStream obj = new ObjectOutputStream(out);
			obj.flush();
			Clients newClient = new Clients();
			if (listWithClients.size() > 0) {
				new Messanger(listWithClients);
				this.wait(100);
			}

			listWithClients.add(newClient);
			newClient.sendWelcomeMessageToExactClient(obj);
		} catch (IOException | InterruptedException e) {
			ConsoleWriter.getLogger().warn("IO exception or InterruptedException occured !" + e);
		}

	}

	/**
	 * Trying to accept() a socket with timeout of 50ms. The loops does not stop
	 * until socket is connected, server stopped or exception being thrown.
	 * 
	 * @param serverSocket
	 *            - Server that accept the socket.
	 * @return - Socket.
	 */
	public Socket establishConnection(ServerSocket serverSocket) {
		Socket client = null;
		do {
			synchronized (this) {
				if (!serverRunning) {
					closeServer();
					break;
				}
				try {
					serverSocket.setSoTimeout(50);
					client = serverSocket.accept();
				} catch (IOException e) {
					ConsoleWriter.getLogger().warn("IO Exception occured !" + e);
				}
			}

		} while (client == null);
		return client;

	}

	/**
	 * Setter for serverRunning.
	 * 
	 * @param option
	 *            - true for running, false for being stopped.
	 */
	public void setServerRunning(boolean option) {
		this.serverRunning = option;
	}

	/**
	 * Closes the server.
	 */
	public void closeServer() {
		try {
			serverRunning = false;
			if (client != null) {
				client.close();
			}
			serverGUI.setVisible(false);
		} catch (IOException e) {
			ConsoleWriter.getLogger().warn("IO exception occured !" + e);
		}
	}
}