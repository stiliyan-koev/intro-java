package com.sirma.itt.javacourse.networkinggui.transmitter.client;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * GUI for Client code.
 * 
 * @author Stiliyan Koev
 */
public class ClientGUI extends JFrame {
	private static final long serialVersionUID = -785470986668982863L;
	private Client client;
	private JTextField textField = new JTextField(null, 20);
	private JButton buttonSendMesssage = new JButton("Send");
	private JTextArea textArea = new JTextArea(20, 20);

	/**
	 * Constructor.\
	 * 
	 * @param port
	 *            - Port to use for connection. If given port is 0, the program
	 *            looks for free port by itself.
	 */
	public ClientGUI(int port) {
		super("Client");
		JPanel panel = new JPanel();

		panel.add(textField);
		panel.add(textArea);
		panel.add(buttonSendMesssage);

		this.setSize(500, 450);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		Dimension dim = new Dimension(20, 30);
		textArea.setPreferredSize(dim);
		this.setContentPane(panel);
		client = new Client(this, 0);
	}

	/**
	 * Main entry point.
	 * 
	 * @param args
	 *            - String arguments.
	 */
	public static void main(String[] args) {
		new ClientGUI(0).getClientCode().start();
	}

	/**
	 * Getter for Client code.
	 * 
	 * @return - Client client.
	 */
	public Client getClientCode() {
		return this.client;
	}

	/**
	 * Set text in text field.
	 * 
	 * @param message
	 *            - the text to be set.
	 */
	public void setTextInTextField(String message) {
		textField.setText(message);
	}

	/**
	 * Gets text from textField.
	 * 
	 * @return - the text as String.
	 */
	public String getTextFromTextField() {
		return textField.getText();
	}

	/**
	 * Getter for JTextArea.
	 * 
	 * @return - JTextArea textArea.
	 */
	public JTextArea getTextArea() {
		return this.textArea;
	}

	/**
	 * Sets message in textArea. If there is already a message it appends it to
	 * the new one.
	 * 
	 * @param message
	 *            - message to be set.
	 */
	public void setTextToTextArea(String message) {
		if (textArea.getText().length() != 0) {
			textArea.setText(textArea.getText() + System.lineSeparator() + message);
		} else {
			textArea.setText(message);
		}
	}
}