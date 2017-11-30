package com.sirma.itt.javacourse.networkinggui.reverse.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.sirma.itt.javacourse.networkinggui.reverse.utilities.Communicator;
import com.sirma.itt.javacourse.utilities.ConsoleWriter;
import com.sirma.itt.javacourse.utilities.NetworkUtil;

/**
 * Server for fifth task.
 * 
 * @author Stiliyan Koev.
 */
public class Server extends Thread {
	private ServerSocket serverSocket;
	private ServerGUI serverGUI;
	private Socket client;
	private OutputStream out;
	private ObjectOutputStream obj;

	/**
	 * Constructor.
	 *
	 * @param gui
	 *            - GUI for Server.
	 * @param port
	 *            - Port to use for connection. If given port is 0, the program
	 *            looks for free port by itself.
	 */
	public Server(ServerGUI gui, int port) {
		this.serverSocket = NetworkUtil.getInstance().createServer(port, "localhost");
		this.serverGUI = gui;
		this.start();
	}

	@Override
	public void run() {
		while (!serverSocket.isClosed()) {
			synchronized (this) {
				ConsoleWriter.write("Waiting to connect");
				client = establishConnection(serverSocket);
				serverGUI.setTextInTextField("User connected");

				try {
					out = client.getOutputStream();
					obj = new ObjectOutputStream(out);
					obj.writeObject("Welcome !");
					new Communicator(client, out, obj).start();
					obj.flush();
				} catch (IOException e) {
					ConsoleWriter.getLogger().warn("IO exception occured !" + e);
				}

			}
		}
		try {
			serverSocket.close();
			serverGUI.dispose();
			client.close();
		} catch (IOException e) {

			ConsoleWriter.write("Exception occured !" + e.getMessage());
		}

	}

	public synchronized void closeServer() {
		try {
			serverSocket.close();
			client.close();
			serverGUI.dispose();
		} catch (IOException e) {
			ConsoleWriter.write("I/O exception occured !" + e);
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
				try {
					serverSocket.setSoTimeout(50);
					client = serverSocket.accept();
				} catch (IOException e) {

				}
			}

		} while (client == null);
		return client;
	}
}
