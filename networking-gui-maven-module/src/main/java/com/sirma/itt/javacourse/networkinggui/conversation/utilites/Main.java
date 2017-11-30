package com.sirma.itt.javacourse.networkinggui.conversation.utilites;

import java.io.IOException;

import com.sirma.itt.javacourse.networkinggui.conversation.client.ClientCode;
import com.sirma.itt.javacourse.networkinggui.conversation.server.ServerGUI;

/**
 * Main class for Conversation between client and server task.
 * 
 * @author Stiliyan Koev.
 */
public class Main {
	public static void main(String[] args) throws IOException, InterruptedException {
		new ServerGUI();
		new ClientCode();
		new ClientCode();
	}
}
