package com.simra.itt.javacourse.threads.producer_consumer;

import java.util.concurrent.TimeUnit;

import com.sirma.itt.javacourse.utilities.ConsoleWriter;

/**
 * Run class for Producer-Consumer task.
 * 
 * @author Stiliyan Koev
 */
public class ProducerConsumerRunClass {
	/**
	 * Private constructor.
	 */
	private ProducerConsumerRunClass() {
	}

	/**
	 * Main entry class.
	 * 
	 * @param args
	 *            - String arguments.
	 * @throws InterruptedException
	 *             - {@link InterruptedException} mai occur.
	 */
	public static void main(String[] args) throws InterruptedException {
		Factory fac = new Factory();
		Consumer consumer = new Consumer(fac);
		Producer producer = new Producer(fac);

		producer.start();
		consumer.start();

		TimeUnit.SECONDS.sleep(30);
		ConsoleWriter.write("Factory closed !");
		fac.setShouldStop(true);
	}
}
