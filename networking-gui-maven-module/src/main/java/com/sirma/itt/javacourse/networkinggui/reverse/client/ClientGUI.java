package com.sirma.itt.javacourse.networkinggui.reverse.client;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sirma.itt.javacourse.networkinggui.reverse.memento.Originator;

/**
 * GUI for Client.
 * 
 * @author Stiliyan Koev.
 */
public class ClientGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private Client client;
	private JPanel panel;
	private JTextField textField = new JTextField(null, 20);
	private JButton buttonSendMesssage = new JButton("Send");
	private JButton buttonRecieveMessage = new JButton("Recieve");
	private JTextArea textArea = new JTextArea(20, 30);
	private boolean textFieldFocused = false;

	/**
	 * Constructor.
	 * 
	 * @param port
	 *            - Port to use for connection. If given port is 0, the program
	 *            looks for free port by itself.
	 */
	public ClientGUI(int port) {
		super("Client");
		panel = new JPanel();
		textField.addFocusListener(new Focus());
		textField.addKeyListener(new Keys());
		panel.add(textField);
		panel.add(textArea);
		buttonSendMesssage.addActionListener(new Action());
		panel.add(buttonSendMesssage);
		Dimension dim = new Dimension(20, 30);
		textArea.setPreferredSize(dim);
		this.setSize(500, 450);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		this.setContentPane(panel);
		client = new Client(this, port);
		client.start();
	}

	/**
	 * Main entry point.
	 * 
	 * @param args
	 *            - String arguments.
	 */
	public static void main(String[] args) {
		new ClientGUI(0);
	}

	/**
	 * Getter for Client code.
	 * 
	 * @return - Client client
	 */
	public Client getClientCode() {
		return this.client;
	}

	/**
	 * Setter for text in textField.
	 * 
	 * @param message
	 *            - Message to be set.
	 */
	public void setTextInTextField(String message) {
		textField.setText(message);
	}

	/**
	 * Gets text from textField.
	 * 
	 * @return - String text.
	 */
	public String getTextFromTextField() {
		return textField.getText();
	}

	/**
	 * Setter for text in textArea.
	 * 
	 */
	public void setTextToTextArea(String message) {
		textArea.setText(textArea.getText() + System.lineSeparator() + message);
	}

	/**
	 * Ation listener for buttons pressed.
	 * 
	 * @author Stiliyan Koev
	 */
	public class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton clicked = (JButton) e.getSource();
			if (clicked == buttonSendMesssage) {
				client.notifyTheReader();
			} else if (clicked == buttonRecieveMessage) {

			}
		}
	}

	/**
	 * KeyListener for keys being pressed.
	 * 
	 * @author Stiliyan Koev
	 */
	public class Keys implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {

			int keyCode = e.getKeyCode();
			if (textFieldFocused && keyCode == KeyEvent.VK_UP) {
				String message = Originator.getInstance().getPreviousMessage();
				setTextInTextField(message);
			} else if (textFieldFocused && keyCode == KeyEvent.VK_DOWN) {
				String message = Originator.getInstance().getNextMessage();
				setTextInTextField(message);
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}
	}

	/**
	 * Focus listner for fields being focused.
	 * 
	 * @author Stiliyan Koev
	 */
	public class Focus implements FocusListener {
		@Override
		public void focusGained(FocusEvent e) {
			JTextField focused = (JTextField) e.getSource();
			if (focused == textField) {
				textFieldFocused = true;
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
			JTextField focused = (JTextField) e.getSource();
			if (focused == textField) {
				textFieldFocused = false;
			}
		}
	}
}
