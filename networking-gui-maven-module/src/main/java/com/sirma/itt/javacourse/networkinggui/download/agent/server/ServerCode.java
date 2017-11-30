package com.sirma.itt.javacourse.networkinggui.download.agent.server;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;

import com.sirma.itt.javacourse.networkinggui.download.agent.client.ClientGUI;
import com.sirma.itt.javacourse.utilities.ConsoleWriter;
import com.sirma.itt.javacourse.utilities.NetworkUtil;

/**
 * Server code for second task.
 * 
 * @author Stiliyan Koev
 */
public class ServerCode extends Thread {
	private ServerSocket serverSocket;
	private ServerGUI gui;

	/**
	 * Parameterless constructor.
	 * 
	 * @param gui
	 *            - Graphical User Interface of Server.
	 * @throws IOException
	 *             - IO exception may occur.
	 */
	public ServerCode(ServerGUI gui) throws IOException {
		this.serverSocket = NetworkUtil.getInstance().createServer(0, "localhost");
		this.gui = gui;
		Thread t = this;
		t.start();
	}

	/**
	 * Parameterless constructor.
	 * 
	 * @param gui
	 *            - Graphical User Interface of Server.
	 * @param port
	 *            - Port to use for connection. If given port is 0, the program
	 *            looks for free port by itself.
	 * @throws IOException
	 *             - IO exception may occur.
	 */
	public ServerCode(ServerGUI gui, int port) throws IOException {
		this.serverSocket = NetworkUtil.getInstance().createServer(port, "localhost");
		this.gui = gui;
		Thread t = this;
		t.start();
	}

	@Override
	public void run() {
		Socket server;

		try {
			ConsoleWriter.write("Waiting for client on port " + serverSocket.getLocalPort() + "...");
			server = serverSocket.accept();
			if (server.isConnected()) {
				ConsoleWriter.write("Just connected to " + server.getRemoteSocketAddress());
				gui.setTextInTextFieldForConnected();
			}
		} catch (SocketTimeoutException s) {
			ConsoleWriter.write("Socket timed out!");
		} catch (IOException e) {
			ConsoleWriter.write("Exception occured !" + e.getMessage());
		}
	}

	/**
	 * Downloading a file and saving to directory.
	 * 
	 * @param mURL
	 *            - URL leading to the file in web.
	 * @param ofile
	 *            - where to be saved.
	 * @throws IOException
	 *             - may occur.
	 *
	 */
	public static void download(String mURL, String ofile) throws IOException {
		InputStream in = null;
		FileOutputStream out = null;
		try {
			URL url = new URL(mURL);
			URLConnection urlConnection = url.openConnection();
			in = urlConnection.getInputStream();
			out = new FileOutputStream(ofile);
			int size = urlConnection.getContentLength();
			int check;
			byte[] oneKiloByteArray = new byte[1024];
			int loopingTimes = size / 1024;
			while ((check = in.read(oneKiloByteArray)) != -1) {
				out.write(oneKiloByteArray, 0, check);
				ClientGUI.setProgressBar(100 / loopingTimes);
			}
			ClientGUI.setProgressBar(100);
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
	}

	/**
	 * Getter for the port being used by server.
	 * 
	 * @return - The port as int.
	 */
	public int getServerUsingPort() {
		return serverSocket.getLocalPort();
	}
}
