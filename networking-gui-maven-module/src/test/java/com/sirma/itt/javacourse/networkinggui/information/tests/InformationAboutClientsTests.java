package com.sirma.itt.javacourse.networkinggui.information.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.sirma.itt.javacourse.networkinggui.clients.information.client.ClientGUI;
import com.sirma.itt.javacourse.networkinggui.clients.information.server.ServerGUI;

/**
 * Tests for fourth task.
 * 
 * @author Stiliyan Koev.
 */
public class InformationAboutClientsTests {
	/**
	 * Simple test on running.
	 * 
	 * @throws IOException
	 *             - may occur.
	 * @throws InterruptedException
	 *             - may occur.
	 */
	@Test
	public void test() throws IOException, InterruptedException {
		ServerGUI server = new ServerGUI(7003);
		ClientGUI client = new ClientGUI(7003);
		client.getClientCodeInstance().start();

		TimeUnit.SECONDS.sleep(2);
		assertEquals("Hi. ID: 2", client.getTextField().getText());

		TimeUnit.SECONDS.sleep(2);
		ClientGUI clientTwo = new ClientGUI();
		clientTwo.getClientCodeInstance().start();
		TimeUnit.SECONDS.sleep(5);
		assertEquals("Hi. ID: 3", clientTwo.getTextField().getText());
		assertEquals("Client with ID: 3 connected !", client.getTextField().getText());
		server.getServerCode().setServerRunning(false);
	}

}
