package com.simra.itt.javacourse.threads.synchronized_stack;

import java.util.concurrent.TimeUnit;

import com.sirma.itt.javacourse.utilities.ConsoleWriter;

/**
 * Synchronized method for adding new elements.
 * 
 * @author Stiliyan Koev
 */
public class SyncedRemove extends Thread {
	private boolean keepRemoving = true;
	private boolean exitProgram = false;
	private Stack stackInstantion;

	/**
	 * Constructor for {@link SyncedRemove}.
	 * 
	 * @param stack
	 *            - A stack to be used.
	 */
	public SyncedRemove(Stack stack) {
		this.stackInstantion = stack;
	}

	@Override
	public void run() {
		while (!exitProgram) {
			while (keepRemoving) {
				stackInstantion.addOrRemove(2, null);
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					ConsoleWriter.getLogger().error("Interrupted Exception occured !" + e);
				}
			}
		}

	}

	/**
	 * Setter for keepRemoving.
	 * 
	 * @param status
	 *            - True or false.
	 */
	public void setkeepRemoving(boolean status) {
		this.keepRemoving = status;
	}

	/**
	 * Setter for stopping the whole program.
	 * 
	 * @param status
	 *            - True or false.
	 */
	public void setExitProgram(boolean status) {
		this.exitProgram = status;
	}
}
