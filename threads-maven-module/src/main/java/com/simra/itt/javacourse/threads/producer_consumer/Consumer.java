package com.simra.itt.javacourse.threads.producer_consumer;

import java.util.concurrent.TimeUnit;

import com.sirma.itt.javacourse.utilities.ConsoleWriter;

/**
 * Class for consumer.
 * 
 * @author Stiliyan Koev
 */
public class Consumer extends Thread {
	private Factory factory = new Factory();

	/**
	 * Constructor for {@link Consumer}.
	 * 
	 * @param factory
	 *            - {@Link Factory} instantiation.
	 */
	public Consumer(Factory factory) {
		this.factory = factory;
	}

	@Override
	public synchronized void run() {
		while (!factory.getShouldStop()) {
			sellStock();
		}
	}

	/**
	 * Selling stocks from factory.
	 */
	public void sellStock() {
		try {
			factory.sell();
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			ConsoleWriter.getLogger().error("Interrupted Exception occured !" + e);
		}

	}
}
