package com.simra.itt.javacourse.threads.producer_consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.sirma.itt.javacourse.utilities.ConsoleWriter;

/**
 * Factory class.
 * 
 * @author Stiliyan Koev
 */
public class Factory {
	private static List<Object> inStock = new ArrayList<Object>(10);
	private int factorySize = 10;
	private volatile boolean shouldStop = false;

	/**
	 * A method that add an object (stock item) to factory.
	 * 
	 * @param item
	 *            - An item to be added.
	 * @throws InterruptedException
	 *             - Interrupted Exception may occur.
	 */
	public void add(Object item) throws InterruptedException {
		synchronized (inStock) {
			if (inStock.size() + 1 > factorySize) {
				ConsoleWriter.write("Factory is full. Waiting for free space !");
				inStock.wait();
			} else {
				ConsoleWriter.write("We just loaded " + item);
				inStock.add(item);
				inStock.notify();
			}
		}
	}

	/**
	 * A method that sells (delete) an object from factory.
	 * 
	 * @throws InterruptedException-
	 *             Interrupted Exception may occur.
	 */
	public void sell() throws InterruptedException {
		synchronized (inStock) {
			if (inStock.size() - 1 < 0) {
				ConsoleWriter.write("Factory is empty ! Waiting for new products !");
				inStock.wait();
			} else {
				String itemToRemove = (String) inStock.get(new Random().nextInt(inStock.size() + 0));
				ConsoleWriter.write("We just sold " + itemToRemove);
				inStock.remove(itemToRemove);
				inStock.notify();
			}
		}
	}

	/**
	 * Getter for inStock list.
	 * 
	 * @return - the list with stocks that are available.
	 */
	public List<Object> getInStock() {
		return inStock;
	}

	/**
	 * Getter for shouldStop.
	 * 
	 * @return - true or false, representing does the program has to stop.
	 */
	public boolean getShouldStop() {
		return shouldStop;
	}

	/**
	 * Setter for shouldStop.
	 * 
	 * @param shouldStop
	 *            - true or false.
	 */
	public void setShouldStop(boolean shouldStop) {
		this.shouldStop = shouldStop;
	}
}
