package com.sirma.itt.javacourse.networkinggui.transmitter.mediator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.sirma.itt.javacourse.networkinggui.transmitter.server.ServerGUI;
import com.sirma.itt.javacourse.utilities.ConsoleWriter;

/**
 * Mediator design pattern.
 * 
 * @author Stiliyan Koev.
 */
public class Mediator implements Runnable {
	private List<String> channels = new ArrayList<String>();
	private ServerGUI serverGUI;

	/**
	 * Constructor.
	 * 
	 * @param serverGUI
	 *            - Server GUI.
	 */
	public Mediator(ServerGUI serverGUI) {
		this.serverGUI = serverGUI;
		channels.add("224.0.0.40");
		channels.add("224.0.0.41");
		channels.add("224.0.0.42");
		channels.add("224.0.0.43");
	}

	@Override
	public void run() {
		sendMessageOnChannel(chooseRandomMulticastChannel());
	}

	/**
	 * Choosing random multicast address from the List of channels.
	 * 
	 * @return - One random chosen address as String.
	 */
	public String chooseRandomMulticastChannel() {
		Random rand = new Random();
		int randomPosition = rand.nextInt(channels.size() - 1) + 1;
		return channels.get(randomPosition);
	}

	/**
	 * Sending message ot multicast channel.
	 * 
	 * @param channelIP
	 *            - The multicast address.
	 */
	public synchronized void sendMessageOnChannel(String channelIP) {
		serverGUI.setTextInTextField("Writing to multicast address " + channelIP);
		try {
			MulticastSocket multicastSocket = new MulticastSocket();
			byte[] buf = new byte[1024];
			buf = "Hello from multicast".getBytes();
			DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName(channelIP), 5000);
			this.wait(1000);
			multicastSocket.send(packet);
			multicastSocket.close();
		} catch (IOException | InterruptedException e) {
			ConsoleWriter.getLogger().warn("IOException occured !" + e);
		}
	}

}
