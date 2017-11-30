package com.sirma.itt.javacourse.threads.stop_counter_thread;

import com.sirma.itt.javacourse.utilities.ConsoleReader;
import com.sirma.itt.javacourse.utilities.ConsoleWriter;

/**
 * Run class for {@link StopCounterThreadBody}.
 * 
 * @author Stiliyan Koev
 */
public class StopCounterThreadRunClass {
	/**
	 * Main entry point for {@link StopCounterThreadBody}.
	 * 
	 * @param args
	 *            - String arguments.
	 */
	public static void main(String[] args) {
		StopCounterThreadBody thread = new StopCounterThreadBody();
		thread.start();
		ConsoleWriter.write("enter");
		if (ConsoleReader.read().length() > 0) {
			thread.setDisturbed(true);
		}
	}
}
