package com.sirma.itt.javacourse.networkinggui.download.agent.server;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * GUI for server.
 * 
 * @author Stiliyan Koev.
 */
public class ServerGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txt = new JTextField(null, 20);
	ServerCode server;

	/**
	 * Constructor.
	 * 
	 * @throws IOException
	 *             - IO exception may occur.
	 */
	public ServerGUI() throws IOException {
		super("Server");

		this.setSize(250, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);

		JPanel panel = new JPanel();
		panel.add(txt);
		this.setContentPane(panel);
		server = new ServerCode(this);
	}

	/**
	 * Constructor.
	 * 
	 * @param port
	 *            - Port to use for connection. If given port is 0, the program
	 *            looks for free port by itself.
	 * @throws IOException
	 *             - IO exception may occur.
	 */
	public ServerGUI(int port) throws IOException {
		super("Server");

		this.setSize(250, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);

		JPanel panel = new JPanel();
		panel.add(txt);
		this.setContentPane(panel);
		server = new ServerCode(this, port);
	}

	/**
	 * Setter for textField when user is connected.
	 */
	public void setTextInTextFieldForConnected() {
		txt.setText("User connected !");
	}

	public int getServerCurrentPort() {
		return server.getServerUsingPort();
	}

	public ServerCode getServerCode() {
		return server;
	}
}
