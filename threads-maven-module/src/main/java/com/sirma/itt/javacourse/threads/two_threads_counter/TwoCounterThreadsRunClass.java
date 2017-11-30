package com.sirma.itt.javacourse.threads.two_threads_counter;

/**
 * Run class for {@link TwoCounterThreads}.
 * 
 * @author Stiliyan Koev
 */
public class TwoCounterThreadsRunClass {

	/**
	 * Private fields
	 */
	private TwoCounterThreadsRunClass() {

	}

	/**
	 * Main entry point for {@link TwoCounterThreads}.
	 * 
	 * @param args
	 *            - String arguments.
	 */
	public static void main(String[] args) {
		TwoCounterThreads one = new TwoCounterThreads(90);
		TwoCounterThreads two = new TwoCounterThreads(100);
		one.start();
		two.start();
	}
}
