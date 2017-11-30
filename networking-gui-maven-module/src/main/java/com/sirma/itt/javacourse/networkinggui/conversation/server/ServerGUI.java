package com.sirma.itt.javacourse.networkinggui.conversation.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sirma.itt.javacourse.utilities.ConsoleWriter;

/**
 * GUI for server for third task.
 * 
 * @author Stiliyan Koev
 */
public class ServerGUI extends JFrame {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField = new JTextField(null, 20);
	private JButton buttonStartServer = new JButton("Start");
	private JButton buttonStopServer = new JButton("Stop Server");
	private ServerCode server;

	/**
	 * Constructor.
	 * 
	 * @throws IOException
	 *             - may occur.
	 */
	public ServerGUI() {
		super("Server");

		JPanel panel = new JPanel();
		panel.add(textField);
		panel.add(buttonStartServer);
		panel.add(buttonStopServer);
		buttonStopServer.addActionListener(new Action());
		buttonStartServer.addActionListener(new Action());
		this.setContentPane(panel);
		try {
			server = new ServerCode(this);
		} catch (IOException e) {
			ConsoleWriter.write("Exception occured !" + e.getMessage());
		}
	}

	/**
	 * Constructor.
	 * 
	 * @throws IOException
	 *             - may occur.
	 */
	public ServerGUI(int port) {
		super("Server");

		JPanel panel = new JPanel();
		panel.add(textField);
		panel.add(buttonStartServer);
		panel.add(buttonStopServer);
		buttonStopServer.addActionListener(new Action());
		buttonStartServer.addActionListener(new Action());
		this.setContentPane(panel);
		try {
			server = new ServerCode(this, port);
		} catch (IOException e) {

			ConsoleWriter.write("Exception occured !" + e.getMessage());
		}
	}

	/**
	 * Setting a textField to show "User connected" message.
	 */
	public void setConnected() {
		textField.setText("User connected !");
	}

	/**
	 * Set text field in text.
	 * 
	 * @param info
	 *            - text to be set.
	 */
	public void setTextInTextField(String info) {
		textField.setText(info);
	}

	/**
	 * Getter for Server code.
	 * 
	 * @return - ServerCode server
	 */
	public ServerCode getServerCode() {
		return this.server;
	}

	/**
	 * Action listener for buttons being pressed.
	 * 
	 * @author Stiliyan Koev.
	 */
	public class Action implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton clicked = (JButton) e.getSource();
			if (clicked == buttonStartServer) {
				server.start();
			} else if (clicked == buttonStopServer) {
				server.setServerRunning(false);
			}
		}
	}

	/**
	 * Main class.
	 * 
	 * @param args
	 *            - String arguments.
	 */
	public static void main(String[] args) {
		new ServerGUI();
	}
}
