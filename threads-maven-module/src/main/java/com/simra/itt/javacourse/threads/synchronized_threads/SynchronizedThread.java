package com.simra.itt.javacourse.threads.synchronized_threads;

import com.sirma.itt.javacourse.utilities.ConsoleWriter;

/**
 * 
 * 
 * @author Stiliyan Koev
 */
public class SynchronizedThread extends Thread {
	private int limit = 0;
	private static final Lock OBJ = new Lock();
	private int counter = 0;
	private String name;
	private static volatile boolean isSomenoeDone;

	/**
	 * Constructor for {@link SynchronizedThread}.
	 * 
	 * @param limit
	 *            - A number to which the counters have to count.
	 * @param name
	 *            - Name of the thread.
	 */
	public SynchronizedThread(int limit, String name) {
		this.name = name;
		this.limit = limit;
		SynchronizedThread.isSomenoeDone = false;
	}

	@Override
	public void run() {
		while (limit > counter) {
			counter++;
			OBJ.print(counter, name, isSomenoeDone);
		}
		synchronized (OBJ) {
			SynchronizedThread.isSomenoeDone = true;
			OBJ.notify();
		}
	}

	/**
	 * Class used for Lock object.
	 * 
	 * @author Stiliyan Koev.
	 */
	static class Lock {
		public void print(int num, String name, boolean isSomeoneDone) {
			synchronized (this) {
				ConsoleWriter.write(name + " : " + num);
				this.notify();
				if (!isSomeoneDone) {
					try {
						this.wait();
					} catch (InterruptedException ex) {
						ConsoleWriter.getLogger().warn("Interrupted exception occured !" + ex);
					}
				}
			}
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
