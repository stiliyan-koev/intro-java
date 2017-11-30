package com.sirma.itt.javacourse.networkinggui.transmitter.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sirma.itt.javacourse.networkinggui.transmitter.mediator.Mediator;

/**
 * GUI for Server sixth task.
 * 
 * @author Stiliyan Koev.
 */
public class ServerGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField textField = new JTextField(null, 20);
	private JButton buttonSendMessageToMulticast = new JButton("Multicast message");
	private Server server;

	/**
	 * Constructor.
	 */
	public ServerGUI(int port) {
		super("Server");
		JPanel panel = new JPanel();
		panel.add(textField);
		buttonSendMessageToMulticast.addActionListener(new Action());
		panel.add(buttonSendMessageToMulticast);
		this.setSize(250, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		this.setContentPane(panel);
		this.server = new Server(this, port);
	}

	/**
	 * Set text in text field.
	 * 
	 * @param text
	 *            - the text to be set.
	 */
	public synchronized void setTextInTextField(String text) {
		textField.setText(text);
	}

	/**
	 * Entry class.
	 * 
	 * @param args
	 *            - String arguments.
	 */
	public static void main(String[] args) {
		new ServerGUI(0);
	}

	/**
	 * Starting new {@link Mediator}.
	 */
	public void startMediator() {
		Mediator mediator = new Mediator(ServerGUI.this);
		mediator.run();
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
			if (clicked == buttonSendMessageToMulticast) {
				startMediator();
			}
		}
	}

	public Server getServerCode() {
		return server;
	}
}
