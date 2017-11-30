package com.sirma.itt.javacourse.networkinggui.transmitter.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.sirma.itt.javacourse.networkinggui.transmitter.mediator.Mediator;
import com.sirma.itt.javacourse.utilities.ConsoleWriter;
import com.sirma.itt.javacourse.utilities.NetworkUtil;

/**
 * Server code for sixth task.
 * 
 * @author Stiliyan Koev.
 */
public class Server extends Thread {
	private ServerSocket serverSocket;
	private ServerGUI serverGUI;

	/**
	 * Constructor.
	 * 
	 * @param gui
	 *            - GUI of Server.
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
				Socket client = establishConnection(serverSocket);
				serverGUI.setTextInTextField("User connected");
				sendToClientRandomAddress(client);
			}
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
					ConsoleWriter.getLogger().warn("IOException occured !" + e);
				}
			}

		} while (client == null);
		return client;
	}

	/**
	 * Sending to the client random chosen multicast address.
	 * 
	 * @param client
	 *            - The client to recieve the multicast address.
	 */
	public void sendToClientRandomAddress(Socket client) {
		try (OutputStream out = client.getOutputStream(); ObjectOutputStream obj = new ObjectOutputStream(out);) {
			String ip = new Mediator(serverGUI).chooseRandomMulticastChannel();
			obj.writeObject(ip);
		} catch (IOException e) {
			ConsoleWriter.getLogger().warn("IOException occured !" + e);
		}
	}

	/**
	 * Getter for Server Socket.
	 * 
	 * @return - ServerSocket serverSocket
	 */
	public ServerSocket getServerSocket() {
		return this.serverSocket;
	}
}
