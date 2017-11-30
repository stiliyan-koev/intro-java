package com.sirma.itt.javacourse.networkinggui.download.agent.utilites;

import javax.swing.JFrame;

import com.sirma.itt.javacourse.networkinggui.download.agent.client.ClientGUI;
import com.sirma.itt.javacourse.networkinggui.download.agent.server.ServerGUI;

/**
 * Main class for Download Agent task.
 * 
 * @author Stiliyan Koev.
 */
public class Main {
	/**
	 * Entry class.
	 * 
	 * @param args
	 *            - String arguments.
	 * @throws Exception
	 *             - exception may occur.
	 */
	public static void main(String[] args) throws Exception {
		// "http://images.anandtech.com/doci/5434/X79%20Extreme9Box_575px.jpg",
		// "D:\\image2.jpg");
		ServerGUI srv = new ServerGUI();

		ClientGUI clientGui = new ClientGUI(srv.getServerCurrentPort());

		clientGui.setSize(250, 400);
		clientGui.setVisible(true);
		clientGui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		clientGui.setResizable(false);

	}
}
