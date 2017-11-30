package com.simra.itt.javacourse.threads.timeout_hashtable;

import java.util.concurrent.TimeUnit;

/**
 * 6th task from Threads.
 * 
 * @author Stiliyan Koev
 */
public class TimeoutHashtableRunClass {
	/**
	 * Private constructor.
	 */
	private TimeoutHashtableRunClass() {

	}

	/**
	 * Main entry point for {@link TimeoutHashtable}.
	 * 
	 * @param args
	 *            - String arguments.
	 * @throws InterruptedException
	 *             - Interrupted exception may occur.
	 */
	public static void main(String[] args) throws InterruptedException {
		TimeoutHashtable stack = new TimeoutHashtable();

		TimeUnit.SECONDS.sleep(2);

		stack.put("asd", 10);
		stack.start();

		TimeUnit.SECONDS.sleep(2);
		stack.put("dda", 12);

		TimeUnit.SECONDS.sleep(2);
		stack.put("dada", 15);

		TimeUnit.SECONDS.sleep(2);
		stack.remove("dada");
		stack.join();
	}
}
