package com.sirma.itt.javacourse.threads.stop_counter_thread;

import com.sirma.itt.javacourse.utilities.ConsoleWriter;

/**
 * Stop Counter Thread task. When a symbol is entered by an user the Thread is
 * stopped.
 * 
 * @author Stiliyan Koev
 */
public class StopCounterThreadBody extends Thread {
	int counter = 0;
	private boolean isDisturbed = false;

	@Override
	public void run() {
		while (!isDisturbed) {
			counter++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				ConsoleWriter.getLogger().error("Interrupted Exception occured !" + e);
			}
		}
		ConsoleWriter.write(counter);
	}

	/**
	 * Getter for counter.
	 * 
	 * @return - value of current counter.
	 */
	public int getCounter() {
		return counter;
	}

	/**
	 * Setter for isDisturbed.
	 * 
	 * @return - true or false.
	 */
	public boolean getIsDisturbed() {
		return isDisturbed;
	}

	/**
	 * Setter for counter.
	 * 
	 * @param counter
	 *            - current counter of thread.
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}

	/**
	 * Setter for isDisturbed.
	 * 
	 * @param status
	 *            - true or false.
	 */
	public void setDisturbed(boolean status) {
		isDisturbed = status;
	}
}