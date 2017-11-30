package com.simra.itt.javacourse.threads.synchronized_stack;

import java.util.concurrent.TimeUnit;

/**
 * RunClass for Synchronized stack task.
 * 
 * @author Stiliyan Koev.
 */
public class StackRunClass {
	/**
	 * Private constructor.
	 */
	private StackRunClass() {
	}

	/**
	 * Main entry method.
	 * 
	 * @param args
	 *            - String arguments.
	 * @throws InterruptedException
	 *             - Interrupted exception may occur !
	 */
	public static void main(String[] args) throws InterruptedException {
		Stack stack = new Stack(2);
		SyncedAdd add = new SyncedAdd(stack);
		SyncedRemove remove = new SyncedRemove(stack);
		SyncedAdd addTwo = new SyncedAdd(stack);
		add.start();
		remove.start();
		addTwo.start();
		TimeUnit.SECONDS.sleep(30);
		add.setExitProgram(true);
		remove.setExitProgram(true);
	}

}
