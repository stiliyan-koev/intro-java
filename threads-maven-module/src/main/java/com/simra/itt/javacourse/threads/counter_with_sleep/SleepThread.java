package com.simra.itt.javacourse.threads.counter_with_sleep;

import com.sirma.itt.javacourse.utilities.ConsoleWriter;

/**
 * Thread which sleeps 2 seconds.
 * 
 * @author Stiliyan Koev
 */
public class SleepThread extends Thread {
	private int limit = 0;
	private static final Lock OBJ = new Lock();
	private int counter = 0;
	private String name;

	/**
	 * Construcotr with parameters.
	 * 
	 * @param limit
	 *            - To which number would the thread count.
	 * @param name
	 *            - Name of thread.
	 */
	public SleepThread(int limit, String name) {
		this.name = name;
		this.limit = limit;
	}

	@Override
	public void run() {
		while (limit > counter) {
			counter++;
			OBJ.print(counter, name);
		}
	}

	/**
	 * This method has is acting like Lock target.
	 * 
	 * @author Stiliyan Koev
	 */
	static class Lock {
		public void print(int num, String name) {
			synchronized (this) {
				ConsoleWriter.write(name + " : " + num);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					ConsoleWriter.getLogger().warn("Interrupted Exception occured !" + e);
				}
			}
		}
	}

	/**
	 * Getter for limit;
	 * 
	 * @return - value of limit.
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * Getter for counter.
	 * 
	 * @return - value of counter
	 */
	public int getCounter() {
		return counter;
	}

	/**
	 * Getter for name.
	 * 
	 * @return - value of name.
	 */
	public String getThreadName() {
		return name;
	}
}
