package com.simra.itt.javacourse.threads.synchronized_threads;

/**
 * 4th task from Threads.
 * 
 * @author Stiliyan Koev
 */
public class SynchronizedThreadRunClass {
	/**
	 * Private constructor.
	 */
	private SynchronizedThreadRunClass() {
	}

	/**
	 * Main entry point for {@link SynchronizedThread}.
	 * 
	 * @param args
	 *            - String arguments.
	 */
	public static void main(String[] args) {
		SynchronizedThread t1 = new SynchronizedThread(15, "t1");
		SynchronizedThread t2 = new SynchronizedThread(5, "t2");
		t1.start();
		t2.start();
	}
}
