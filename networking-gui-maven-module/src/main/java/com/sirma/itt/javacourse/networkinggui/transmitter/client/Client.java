package com.sirma.itt.javacourse.networkinggui.transmitter.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;

import com.sirma.itt.javacourse.utilities.ConsoleWriter;
import com.sirma.itt.javacourse.utilities.NetworkUtil;

/**
 * Client code for sixth task.
 * 
 * @author Stiliyan Koev
 */
public class Client extends Thread {
	private ClientGUI clientGUI;
	private Socket client;
	private Object lock = new Object();
	private String multicastIP = "";
	private int portToUse = 0;

	/**
	 * Constructor.
	 * 
	 * @param gui
	 *            - GUI for Client.
	 * @param port
	 *            - Port to use for connection. If given port is 0, the program
	 *            looks for free port by itself.
	 */
	public Client(ClientGUI gui, int port) {
		super("Client");
		this.clientGUI = gui;
		this.portToUse = port;
	}

	@Override
	public void run() {
		synchronized (lock) {
			ConsoleWriter.write("Connecting");
			try {
				client = new Socket("localhost", NetworkUtil.getInstance().findPortForClient("localhost", portToUse));
			} catch (IOException e) {
				ConsoleWriter.getLogger().warn("IO exception occured !" + e);
			}

			multicastIP = getMulticastAddressFromServer();
			setUpMulticastRecieving(multicastIP);

			while (client.isClosed()) {
				String infoRecievedFromPacket = getInformationFromMulticast(multicastIP);
				clientGUI.setTextToTextArea(infoRecievedFromPacket);
				try {
					lock.wait(100);
				} catch (InterruptedException e) {
					ConsoleWriter.getLogger().warn("InterruptedException occured !" + e);
				}
			}
		}
	}

	/**
	 * Sets the textfields to inform the user to which port is the client
	 * listening to.
	 * 
	 * @param multicastIP
	 *            - The multicastIP that the client is listening to.
	 */
	public void setUpMulticastRecieving(String multicastIP) {
		clientGUI.setTextInTextField("I am listening to: " + multicastIP);
		ConsoleWriter.write("I am listening to multicast now");
	}

	/**
	 * Gets the sent information from the server on the multicast address.
	 * 
	 * @param multicastIP
	 *            - The multicast address.
	 * @return - The information recieved as String.
	 */
	public String getInformationFromMulticast(String multicastIP) {
		MulticastSocket multicastSocket;
		DatagramPacket pack = null;
		try {
			multicastSocket = new MulticastSocket(5000);
			multicastSocket.joinGroup(InetAddress.getByName(multicastIP));
			byte[] buf = new byte[1024];
			pack = new DatagramPacket(buf, buf.length);
			multicastSocket.receive(pack);
		} catch (IOException e) {
			ConsoleWriter.getLogger().warn("IOException occured !" + e);
		}

		return new String(pack.getData());
	}

	/**
	 * Recieving the multicast address from server.
	 * 
	 * @return - The multicast address as String.
	 */
	public String getMulticastAddressFromServer() {
		String multicastIP = null;
		try (InputStream inFromServer = client.getInputStream();
				ObjectInputStream objectInput = new ObjectInputStream(inFromServer);) {

			multicastIP = (String) objectInput.readObject();
		} catch (IOException | ClassNotFoundException e) {
			ConsoleWriter.getLogger().warn("IOException occured !" + e);
		}
		return multicastIP;
	}

	/**
	 * Closing the client.
	 */
	public void closeClient() {
		try {
			client.close();
			clientGUI.setVisible(false);
		} catch (IOException e) {
			ConsoleWriter.getLogger().warn("IOException occured !" + e);
		}
	}

	/**
	 * Getter for multicastIP.
	 * 
	 * @return - String multicastIP.
	 */
	public String getMulticastIP() {
		return multicastIP;
	}

	/**
	 * Setter for multicastIP.
	 * 
	 * @param multicastIP
	 *            - the multicastIP
	 */
	public void setMulticastIP(String multicastIP) {
		this.multicastIP = multicastIP;
	}

	/**
	 * Getter for Client code.
	 * 
	 * @return - Client client.
	 */
	public Socket getClientSocket() {
		return this.client;
	}

	/**
	 * Setter for client Socket.
	 * 
	 * @param port
	 *            - The port to listen to.
	 */
	public void setClientSocket(int port) {
		try {
			client = new Socket("localhost", port);
		} catch (IOException e) {
			ConsoleWriter.getLogger().warn("IO exception occured !" + e);
		}
	}
}
