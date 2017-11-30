package com.sirma.itt.javacourse.networkinggui.clients.information.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sirma.itt.javacourse.utilities.ConsoleWriter;

/**
 * GUI for server.
 * 
 * @author Stiliyan Koev.
 */
public class ServerGUI extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JTextField textField = new JTextField(null, 20);
	private JButton buttonStopServer = new JButton("Stop Server");
	private Server server;

	/**
	 * Constructor.
	 * 
	 */
	public ServerGUI() {
		super("Server");
		panel = new JPanel();
		panel.add(textField);
		panel.add(buttonStopServer);
		buttonStopServer.addActionListener(new Action());

		this.setSize(250, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);

		this.setContentPane(panel);
		try {
			server = new Server(this);
		} catch (IOException e) {
			ConsoleWriter.write(e.getMessage());
		}
	}

	/**
	 * Constructor.
	 * 
	 * @param port
	 *            - Port to use for connection. If given port is 0, the program
	 *            looks for free port by itself.
	 */
	public ServerGUI(int port) {
		super("Server");
		panel = new JPanel();
		panel.add(textField);
		panel.add(buttonStopServer);
		buttonStopServer.addActionListener(new Action());

		this.setSize(250, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);

		this.setContentPane(panel);
		try {
			server = new Server(this, port);
		} catch (IOException e) {
			ConsoleWriter.write(e.getMessage());
		}
	}

	/**
	 * Set text in textfield.
	 * 
	 * @param info
	 *            - Message to be set.
	 */
	public void setTextInTextField(String info) {
		textField.setText(info);
	}

	/**
	 * Getter for serverCode.
	 * 
	 * @return - ServerCode serverCode
	 */
	public Server getServerCode() {
		return this.server;
	}

	/**
	 * Entry point.
	 * 
	 * @param args
	 *            - String arguments.
	 * @throws IOException
	 *             - may occur.
	 */
	public static void main(String[] args) throws IOException {
		new ServerGUI();
	}

	/**
	 * ActionListener for buttons.
	 * 
	 * @author Stiliyan Koev
	 */
	public class Action implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton clicked = (JButton) e.getSource();
			if (clicked == buttonStopServer) {
				server.setServerRunning(false);
			}
		}
	}
}
