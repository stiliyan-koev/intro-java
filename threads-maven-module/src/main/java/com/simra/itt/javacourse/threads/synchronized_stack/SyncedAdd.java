package com.simra.itt.javacourse.threads.synchronized_stack;

import java.util.concurrent.TimeUnit;

// 2 nishki
import com.sirma.itt.javacourse.utilities.ConsoleReader;
import com.sirma.itt.javacourse.utilities.ConsoleWriter;

/**
 * Synchronized method for adding new elements.
 * 
 * @author Stiliyan Koev
 */
public class SyncedAdd extends Thread {

	private boolean manualInput = false;
	private boolean exitProgram = false;
	private Stack stackInstantion;

	/**
	 * Constructor for {@link SyncedAdd}.
	 * 
	 * @param stack
	 *            - A stack to be used.
	 */
	public SyncedAdd(Stack stack) {
		this.stackInstantion = stack;
	}

	@Override
	public void run() {
		int num = 0;
		while (!exitProgram) {
			if (manualInput) {
				ConsoleWriter.write("Type in element: ");
				stackInstantion.addOrRemove(1, ConsoleReader.readInt());
			} else {
				try {
					num++;
					stackInstantion.addOrRemove(1, num);
					ConsoleWriter.write("Inserted: " + num);
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					ConsoleWriter.getLogger().error("Interrupted Exception occured !" + e);
				}
			}
		}
	}

	/**
	 * Setter for manualInput.
	 * 
	 * @param status
	 *            - True or false.
	 */
	public void setManualInput(boolean status) {
		this.manualInput = status;
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
