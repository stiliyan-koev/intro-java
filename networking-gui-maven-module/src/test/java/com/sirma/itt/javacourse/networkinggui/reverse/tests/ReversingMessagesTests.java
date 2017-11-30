package com.sirma.itt.javacourse.networkinggui.reverse.tests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.sirma.itt.javacourse.networkinggui.reverse.client.ClientGUI;
import com.sirma.itt.javacourse.networkinggui.reverse.memento.Originator;
import com.sirma.itt.javacourse.networkinggui.reverse.server.ServerGUI;

/**
 * JUnit tests for fifth task.
 * 
 * @author Stiliyan Koev
 */
public class ReversingMessagesTests {
	/**
	 * Tests with one message.
	 * 
	 * @throws InterruptedException
	 *             - may occur.
	 */
	@Test
	public void testOneReverse() throws InterruptedException {
		ServerGUI server = new ServerGUI(7004);
		TimeUnit.SECONDS.sleep(5);
		ClientGUI client = new ClientGUI(7004);
		TimeUnit.SECONDS.sleep(5);
		assertEquals("Welcome !", client.getTextFromTextField());
		client.getClientCode().notifyTheReader();
		TimeUnit.SECONDS.sleep(5);
		assertEquals("The reverse of<Welcome !> is <! emocleW>", client.getTextFromTextField());

		testNewMessage(client);

		testOriginatorForMessages();
		client.getClientCode().closeClient();
		server.dispose();
	}

	/**
	 * Tests saved messages in Originator design pattern.
	 */
	public void testOriginatorForMessages() {
		String message = Originator.getInstance().getPreviousMessage();
		assertEquals("Test message !", message);

		message = Originator.getInstance().getPreviousMessage();
		assertEquals("Welcome !", message);

		message = Originator.getInstance().getNextMessage();
		assertEquals("Test message !", message);
	}

	/**
	 * Test with second message.
	 * 
	 * @param client
	 *            - The client.
	 * @throws InterruptedException
	 *             - may occur.
	 */
	public void testNewMessage(ClientGUI client) throws InterruptedException {
		client.setTextInTextField("Test message !");
		client.getClientCode().notifyTheReader();
		TimeUnit.SECONDS.sleep(5);
		assertEquals("The reverse of<Test message !> is <! egassem tseT>", client.getTextFromTextField());
	}
}
