package com.sirma.itt.javacourse.networkinggui.conversation.client;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClientGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField = new JTextField(null, 20);

	/**
	 * Constructor.
	 */
	public ClientGUI() {
		super("Client");
		JPanel panel = new JPanel();
		panel.add(textField);
		this.setContentPane(panel);

		this.setSize(250, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);

	}

	/**
	 * Setting text in textField.
	 * 
	 * @param info
	 *            - text to be shown.
	 */
	public void setTextInTextField(String info) {
		textField.setText(info);
	}

	/**
	 * Gets the text from textField.
	 * 
	 * @return - text from textField as String.
	 */
	public String getTextFromTextField() {
		return textField.getText();
	}
}
