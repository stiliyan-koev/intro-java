package com.simra.itt.javacourse.threads.timeout_hashtable;

import com.sirma.itt.javacourse.utilities.ConsoleWriter;

/**
 * Custom created Element class. It has a timeoutLimit and when it reach 0, a
 * thread is deleting the element from the hashtable. Value is the main object
 * that has to be stored. Alive boolean is showing us is this element still in
 * use and if not and the timeoutLimit reached 0 it becomes to "not alive". Key
 * is the element's key in the hashtable.
 * 
 * @author Stiliyan Koev
 */
public class Element implements Runnable { // this class is seing
											// TimeoutHashTable.table as null.
											// How to fix ?
	private int timeOutLimit;
	private Object value;
	private boolean alive = true;
	private String key;

	/**
	 * Constructor for Element.
	 * 
	 * @param key
	 *            - Key in hashtable
	 * @param value
	 *            - The element's key in the hashtable.
	 * @param timeOutLimit
	 *            - A counter showing for how long will the element stay if it
	 *            is not used.
	 */
	public Element(String key, Object value, int timeOutLimit, TimeoutHashtable stack) {
		this.timeOutLimit = timeOutLimit;
		this.value = value;
		this.key = key;
	}

	@Override
	public void run() {
		TimeoutHashtable stack = new TimeoutHashtable();
		while (alive) {
			synchronized (this) {
				if (timeOutLimit == 0) {
					stack.update(key, Command.DELETE);
					alive = false;
				} else {
					timeOutLimit -= 2;
					try {
						this.wait(1000);
					} catch (InterruptedException ex) {
						ConsoleWriter.getLogger().warn("Interrupted exception occured !" + ex);
					}
				}
			}
		}
	}

	/**
	 * Getter for objects value.
	 * 
	 * @return - value as Object
	 */
	public Object getObjectValue() {
		return this.value;
	}

	/**
	 * Setter for alive boolean.
	 * 
	 * @param status
	 *            - True or false.
	 */
	public void setAliveStatus(boolean status) {
		this.alive = status;
	}

	/**
	 * A method extending the time for storage with 30 seconds.
	 * 
	 * @param key
	 *            - Which element to update.
	 */
	public void update(String key) {
		this.timeOutLimit = 30;
	}
}
