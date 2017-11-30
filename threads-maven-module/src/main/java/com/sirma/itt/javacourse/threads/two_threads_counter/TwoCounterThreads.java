package com.sirma.itt.javacourse.threads.two_threads_counter;

import com.sirma.itt.javacourse.utilities.ConsoleWriter;

/**
 * Two Counter Threads task.
 * 
 * @author Stiliyan Koev
 */
public class TwoCounterThreads extends Thread {
	private static volatile boolean isSomeoneFinished = false;
	private int limit;
	private int counter = 0;

	/**
	 * Private constructor
	 */
	private TwoCounterThreads() {

	}

	/**
	 * Constructor for {@link TwoCounterThreads}.
	 * 
	 * @param limit
	 *            - A number setting the limit of counting.
	 */
	public TwoCounterThreads(int limit) {
		this.limit = limit;
	}

	@Override
	public void run() {
		while (!TwoCounterThreads.isSomeoneFinished)
			try {
				while (!TwoCounterThreads.isSomeoneFinished && counter <= limit) {
					counter++;
					ConsoleWriter.write(counter);
					Thread.sleep(500);
					if (counter == limit) {
						TwoCounterThreads.isSomeoneFinished = true;
					}
				}
				TwoCounterThreads.isSomeoneFinished = true;
			} catch (InterruptedException e) {
				ConsoleWriter.write(e.getMessage());
			}
	}

	/**
	 * Getter for counter.
	 * 
	 * @return - value of counter.
	 */
	public int getCounter() {
		return counter;
	}
}
