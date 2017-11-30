package com.sirma.itt.javacourse.networkinggui.clients.information.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClientGUI extends JFrame {
	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L; // read
	private Client client;
	private JPanel panel;
	private JTextField textField = new JTextField(null, 20);
	private JButton buttonConnectToServer = new JButton("Connect");

	/**
	 * Constructor.
	 */
	public ClientGUI() {
		super("Client");
		panel = new JPanel();
		buttonConnectToServer.addActionListener(new Action());
		panel.add(buttonConnectToServer);
		panel.add(textField);
		this.setContentPane(panel);

		this.setSize(250, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		this.setResizable(false);
		this.client = new Client(this);
	}

	/**
	 * Constructor.
	 * 
	 * @param port
	 *            - Port to use for connection. If given port is 0, the program
	 *            looks for free port by iteslf.
	 */
	public ClientGUI(int port) {
		super("Client");
		panel = new JPanel();
		buttonConnectToServer.addActionListener(new Action());
		panel.add(buttonConnectToServer);
		panel.add(textField);
		this.setContentPane(panel);

		this.setSize(250, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		this.setResizable(false);
		this.client = new Client(this, port);
	}

	@Override
	public void dispose() {
		this.setVisible(false);
		super.dispose();
	}

	/**
	 * Setting text in text field.
	 * 
	 * @param info
	 */
	public void setTextInTextField(String info) {
		textField.setText(info);
	}

	/**
	 * Getter for textField.
	 * 
	 * @return - JTextField textField
	 */
	public JTextField getTextField() {
		return this.textField;
	}

	/**
	 * Gets ClientCode clientCode.
	 * 
	 * @return - ClientCode clientCode.
	 */
	public Client getClientCodeInstance() {
		return this.client;
	}

	/**
	 * Entry point.
	 * 
	 * @param args
	 *            - String arguments
	 */
	public static void main(String[] args) {
		new ClientGUI();
	}

	/**
	 * ActionListener for buttons.
	 * 
	 * @author Stiliyan Koev.
	 */
	public class Action implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton clicked = (JButton) e.getSource();
			if (clicked == buttonConnectToServer) {
				client.start();
			}
		}
	}
}
