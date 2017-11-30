package com.simra.itt.javacourse.threads.counter_with_sleep;

/**
 * 3rd task from Threads.
 * 
 * @author Stiliyan Koev
 */
public class SleepThreadRunClass {
	/**
	 * Private constructor.
	 */
	private SleepThreadRunClass() {

	}

	/**
	 * Main entry point for {@link SleepThread}.
	 * 
	 * @param args
	 *            - String arguments
	 */
	public static void main(String[] args) {
		SleepThread threadOne = new SleepThread(5, "t1");
		SleepThread threadTwo = new SleepThread(7, "t2");

		threadOne.start();
		threadTwo.start();
	}
}
