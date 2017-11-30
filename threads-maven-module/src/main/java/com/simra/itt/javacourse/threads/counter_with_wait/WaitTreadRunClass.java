package com.simra.itt.javacourse.threads.counter_with_wait;

/**
 * 3rd task from Threads.
 * 
 * @author Stiliyan Koev
 */
public class WaitTreadRunClass {
	/**
	 * Private constructor
	 */
	private WaitTreadRunClass() {

	}

	/**
	 * Main entry point for {@link WaitThread}.
	 * 
	 * @param args
	 *            - String arguments.
	 */
	public static void main(String[] args) {
		WaitThread t1 = new WaitThread(2, "t1");
		WaitThread t2 = new WaitThread(5, "t2");
		t1.start();
		t2.start();
	}
}
