package com.sirma.itt.javacourse.networkinggui.reverse.server;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * GUI for Server
 * 
 * @author Stiliyan Koev
 */
public class ServerGUI extends JFrame {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField = new JTextField(null, 20);
	private Server server;

	public ServerGUI(int port) {
		super("Server");
		JPanel panel = new JPanel();
		panel.add(textField);

		this.setSize(250, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		this.setContentPane(panel);
		server = new Server(this, port);
	}

	/**
	 * Getter for server code.
	 * 
	 * @return - Server server
	 */
	public Server getServerCode() {
		return this.server;
	}

	/**
	 * Setter for text in field.
	 * 
	 * @param text
	 *            - Text to be set.
	 */
	public void setTextInTextField(String text) {
		textField.setText(text);
	}

	/**
	 * Entry point.
	 * 
	 * @param args
	 *            - String arguments.
	 */
	public static void main(String[] args) {
		new ServerGUI(0);
	}

}
