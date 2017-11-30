package com.simra.itt.javacourse.threads.counter_with_wait;

import com.sirma.itt.javacourse.utilities.ConsoleWriter;

/**
 * Thread which is waiting for other to notify.
 * 
 * @author Stiliyan Koev
 */
public class WaitThread extends Thread {
	private int limit = 0;
	private int counter = 0;
	private String name;
	private static volatile boolean isSomenoeDone;

	/**
	 * Constructor for {@link WaitThread} class.
	 * 
	 * @param limit
	 *            - A limit to count.
	 * @param name
	 *            - Thread name.
	 */
	public WaitThread(int limit, String name) {
		this.name = name;
		this.limit = limit;
		WaitThread.isSomenoeDone = false;
	}

	@Override
	public void run() {
		try {
			while (limit > counter && !isSomenoeDone) {
				synchronized (this) {
					wait(1000);
				}
				ConsoleWriter.write(name + " : " + counter);
				counter++;
			}
			isSomenoeDone = true;
		} catch (InterruptedException e) {
			ConsoleWriter.getLogger().warn(e.getMessage(), e);
		}
	}

	/**
	 * Getter for counter.
	 * 
	 * @return - counter.
	 */
	public int getCounter() {
		return counter;
	}

	/**
	 * Getter for name
	 * 
	 * @return - name.
	 */
	public String getThreadName() {
		return name;
	}
}
