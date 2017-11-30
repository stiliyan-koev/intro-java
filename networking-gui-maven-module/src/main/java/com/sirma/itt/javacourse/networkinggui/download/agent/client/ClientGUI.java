package com.sirma.itt.javacourse.networkinggui.download.agent.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import com.sirma.itt.javacourse.networkinggui.download.agent.server.ServerCode;
import com.sirma.itt.javacourse.utilities.ConsoleWriter;

/**
 * GUI for Client.
 * 
 * @author Stiliyan Koev.
 */
public class ClientGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField urlTextField;
	private JTextField directoryField;
	private JTextField connectedStatusField;
	private JButton connectToserverButton = new JButton("Connect"), sendUrlButton = new JButton("Send URL"),
			sendDirectoryButton = new JButton("Send Directory & Download");
	private JPanel panel;
	private Dimension dimension;
	public ClientCode client;
	public String url = "", directory = "";
	private static JProgressBar progressBar;
	private int serverPort;
	public static double staticNumber = 0;

	/**
	 * Constructor.
	 * 
	 * @param port
	 *            - to which port should the socket listen.
	 * @throws IOException
	 *             - Input/Output exception may occur.
	 */
	public ClientGUI(int port) throws IOException {
		super("Client");
		this.serverPort = port;
		urlTextField = new JTextField("Insert URL here", 20);
		directoryField = new JTextField("Insert directory here", 20);
		connectedStatusField = new JTextField("Not connected", 20);
		urlTextField.addFocusListener(new Focus());
		directoryField.addFocusListener(new Focus());
		panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.add(urlTextField);
		panel.add(directoryField);
		dimension = new Dimension(200, 50);

		connectToserverButton.setPreferredSize(dimension);
		connectToserverButton.addActionListener(new Action());

		panel.add(connectToserverButton);

		sendUrlButton.setPreferredSize(dimension);
		sendUrlButton.addActionListener(new Action());
		panel.add(sendUrlButton);

		sendDirectoryButton.setPreferredSize(dimension);
		sendDirectoryButton.addActionListener(new Action());
		panel.add(sendDirectoryButton);

		progressBar = new JProgressBar();
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		panel.add(progressBar);

		connectedStatusField.setBackground(Color.RED);
		panel.add(connectedStatusField);

		this.setContentPane(panel);
		client = new ClientCode();
	}

	/**
	 * Setter for progress bar.
	 * 
	 * @param progress
	 *            - amount of downloaded part.
	 */
	public static void setProgressBar(double progress) {
		if (progressBar.getValue() + progress > 100) {
			progressBar.setValue(100);
		} else {
			progressBar.setValue(progressBar.getValue() + (int) progress);
			progressBar.setStringPainted(true);
		}
	}

	public ClientCode getClient() {
		return client;
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
			if (clicked == sendUrlButton) {
				try {
					url = urlTextField.getText();
					client.setDownloadURL(url);

				} catch (IOException ex) {
					ConsoleWriter.getLogger().warn("I/O exception occured !");
				}

			} else if (clicked == sendDirectoryButton) {
				try {
					directory = directoryField.getText();
					ServerCode.download(url, directory);
				} catch (Exception ex) {
					ConsoleWriter.getLogger().warn("Exception occured !" + ex);
				}

			} else if (clicked == connectToserverButton) {
				if (client.connectToServer("localhost", serverPort)) {
					connectedStatusField.setBackground(Color.GREEN);
					connectedStatusField.setText("Connected");
				}
			}
		}

	}

	/**
	 * Focus listener for fields.
	 * 
	 * @author Stiliyan Koev.
	 */
	public class Focus implements FocusListener {
		@Override
		public void focusGained(FocusEvent e) {
			JTextField focused = (JTextField) e.getSource();
			if (focused == urlTextField && "Insert URL here".equals(urlTextField.getText())) {
				urlTextField.setText("");
			} else if (focused == directoryField && "Insert directory here".equals(directoryField.getText())) {
				directoryField.setText("");
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
		}
	}
}
