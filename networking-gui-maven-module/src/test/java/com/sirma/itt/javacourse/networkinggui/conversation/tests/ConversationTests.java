package com.sirma.itt.javacourse.networkinggui.conversation.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.sirma.itt.javacourse.networkinggui.conversation.client.ClientCode;
import com.sirma.itt.javacourse.networkinggui.conversation.server.ServerGUI;

public class ConversationTests {
	/**
	 * Testing Conversation task.
	 * 
	 * @throws IOException
	 *             - may occur.
	 * @throws InterruptedException
	 *             - may occur.
	 */
	@Test
	public void test() throws IOException, InterruptedException {
		ServerGUI server = new ServerGUI(7001);

		server.getServerCode().start();
		TimeUnit.SECONDS.sleep(1);

		ClientCode client = new ClientCode(7001);
		String expected = "Hello !" + new Date().toString().substring(0, 16);
		assertEquals(expected, client.getClientGUI().getTextFromTextField().substring(0, 23));

		TimeUnit.SECONDS.sleep(1);

		ClientCode clientTwo = new ClientCode(7001);
		String expectedSecondTest = "Hello !" + new Date().toString().substring(0, 16);
		assertEquals(expectedSecondTest, clientTwo.getClientGUI().getTextFromTextField().substring(0, 23));

		TimeUnit.SECONDS.sleep(2);
		server.getServerCode().setServerRunning(false);
		client.getClientGUI().dispose();

		TimeUnit.SECONDS.sleep(2);

	}
}
