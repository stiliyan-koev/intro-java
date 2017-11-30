package com.sirma.itt.javacourse.networkinggui.download.agent.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import com.sirma.itt.javacourse.utilities.ConsoleWriter;

/**
 * Client socket.
 * 
 * @author Stiliyan Koev.
 */
public class ClientCode {
	private DataOutputStream out;

	/**
	 * Connecting to server.
	 * 
	 * @param ip
	 *            - IP address to connect to.
	 * @param port
	 *            - to which port to connect.
	 * @return - true if the connection was successfull, false if not.
	 */
	public boolean connectToServer(String ip, int port) {
		Socket client;
		OutputStream outToServer;
		ConsoleWriter.write("Connecting to " + "localhost" + " on port " + port);
		try {
			client = new Socket(ip, port);
			ConsoleWriter.write("Just connected to " + client.getRemoteSocketAddress());
			outToServer = client.getOutputStream();
			out = new DataOutputStream(outToServer);
			return true;

		} catch (IOException ex) {
			ConsoleWriter.getLogger().warn("I/O exception occured !" + ex);
			return false;
		}
	}

	/**
	 * Set download URL.
	 * 
	 * @param url
	 *            - The url to be downloaded from.
	 * @throws IOException
	 *             - Input/Output exception may occur.
	 */
	public void setDownloadURL(String url) throws IOException {
		out.writeUTF(url);
	}
}
