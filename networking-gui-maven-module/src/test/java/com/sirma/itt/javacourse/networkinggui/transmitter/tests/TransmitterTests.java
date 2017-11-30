package com.sirma.itt.javacourse.networkinggui.transmitter.tests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.sirma.itt.javacourse.networkinggui.transmitter.client.ClientGUI;
import com.sirma.itt.javacourse.networkinggui.transmitter.mediator.Mediator;
import com.sirma.itt.javacourse.networkinggui.transmitter.server.ServerGUI;

/**
 * Test for sixth task.
 * 
 * @author Stiliyan Koev
 */
public class TransmitterTests {
	private static ServerGUI server;
	private static String multicastIP = "";
	private static ClientGUI client;

	private static String message = "";

	/**
	 * One test of normal execution.
	 * 
	 * @throws InterruptedException
	 *             - may occur.
	 */
	@Test
	public void test() throws InterruptedException {
		server = new ServerGUI(7005);
		client = new ClientGUI(7005);
		int port = server.getServerCode().getServerSocket().getLocalPort();
		client.getClientCode().setClientSocket(port);
		multicastIP = client.getClientCode().getMulticastAddressFromServer();

		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(new MediatorSendMessage());
		service.submit(new ClientReadMessage());
		service.shutdown();
		service.awaitTermination(1, TimeUnit.DAYS);
		TimeUnit.SECONDS.sleep(2);
		assertEquals("Hello from multicast", client.getTextArea().getText().substring(0, 20));
	}

	/**
	 * Callable class to be added in ExecutorService.
	 * 
	 * @author Stiliyan Koev
	 */
	public static class MediatorSendMessage implements Callable<Object> {

		@Override
		public Object call() throws Exception {
			Mediator mediator = new Mediator(server);
			mediator.sendMessageOnChannel(multicastIP);
			return null;
		}

	}

	/**
	 * Callable class to be added in ExecutorService.
	 * 
	 * @author Stiliyan Koev
	 */
	public static class ClientReadMessage implements Callable<Object> {

		@Override
		public Object call() throws Exception {
			message = client.getClientCode().getInformationFromMulticast(multicastIP);
			client.setTextToTextArea(message);
			return null;
		}
	}
}
