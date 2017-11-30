package com.simra.itt.javacourse.threads.producer_consumer;

import java.util.concurrent.TimeUnit;

import com.sirma.itt.javacourse.utilities.ConsoleWriter;

/**
 * Producer class.
 * 
 * @author Stiliyan Koev
 */
public class Producer extends Thread {
	private Factory factory;

	/**
	 * Constructor for {@link Producer}.
	 * 
	 * @param factory
	 *            - {@Link Factory} instantiation.
	 */
	public Producer(Factory factory) {
		this.factory = factory;
	}

	@Override
	public synchronized void run() {
		Items itemsToLoad = new Items();
		while (!factory.getShouldStop()) {
			addStock(itemsToLoad.getRandomItem());
		}
	}

	/**
	 * Adding stock to the factory.
	 * 
	 * @param newStock
	 *            - An object of stock to be added.
	 */
	public void addStock(Object newStock) {
		try {
			factory.add(newStock);
			TimeUnit.SECONDS.sleep(2);

		} catch (InterruptedException e) {
			ConsoleWriter.getLogger().error("Interrupted Exception occured !" + e);
		}
	}
}
