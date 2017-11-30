package com.simra.itt.javacourse.threads.timeout_hashtable;

import java.util.Calendar;
import java.util.Hashtable;
import java.util.Map;

import com.sirma.itt.javacourse.utilities.ConsoleWriter;

/**
 * Synchronized Stack. Hashtable "table" is holding the keys and its values,
 * Hashtable timer is holding the counters of each key which shows for how long
 * the object was inactive(not used).
 * 
 * @author Stiliyan Koev
 */
public class TimeoutHashtable extends Thread {
	private volatile Hashtable<String, Element> table = new Hashtable<String, Element>();
	private boolean needAccess = false;

	@Override
	public void run() {
		synchronized (this) {
			while (table.size() > 0) {
				if (needAccess) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						needAccess = false;
					}
				}
				ConsoleWriter.write(Calendar.getInstance().get(Calendar.SECOND));
				try {
					this.wait(1000);
				} catch (InterruptedException ex) {
					ConsoleWriter.getLogger().warn("Interrupted exception occured !" + ex);
				}
			}
		}
	}

	/**
	 * Updating an exact key. The method adds extra 30 seconds of lifetime to
	 * the element.
	 * 
	 * @param key
	 *            - key in hashtable.
	 * @param option
	 *            - option to be chosen - add,update or remove.
	 */
	public void update(String key, Command option) {
		needAccess = true;
		synchronized (this) {
			if (Command.UPDATE.equals(option)) {
				table.get(key).update(key);
				this.notify();
			} else if (Command.DELETE.equals(option)) {
				remove(key);
				this.notify();
			}
		}
	}

	/**
	 * Puts the new key and its value to the HashTable.
	 * 
	 * @param key
	 *            - A key to be inserted.
	 * @param value
	 *            - Key's value to be inserted.
	 */
	public void put(String key, Object value) {
		Element element = new Element(key, value, 30, this);
		element.run();
		synchronized (this) {
			table.put(key, element);
		}
	}

	/**
	 * Gets the key and it's value. Also updates the counter which is counting
	 * for how long the object was inactive(not used).
	 * 
	 * @param key
	 *            - Key of the value.
	 * @return - The object which is held by the key.
	 */
	public Object get(String key) {
		Object objectToReturn = null;
		needAccess = true;
		synchronized (table) {
			objectToReturn = table.get(key);
			update(key, Command.UPDATE);
			needAccess = false;
			table.notify();
		}
		return objectToReturn;
	}

	/**
	 * Delete the key and its value from the Hashtable.
	 * 
	 * @param key
	 *            - Key to be deleted.
	 */
	public void remove(String key) {
		needAccess = true;
		synchronized (table) {
			if ((table.get(key) != null)) {
				ConsoleWriter.write("Removed: " + table.get(key).getObjectValue());
				table.get(key).setAliveStatus(false);
				table.remove(key);
				needAccess = false;
				table.notify();
			} else {
				ConsoleWriter.write("There is no element in the HashTable with " + key + " key");
				needAccess = false;
				table.notify();
			}
		}
	}

	/**
	 * Getter for stack.
	 * 
	 * @return - return the hashtable with elements.
	 */
	public Map<String, Element> getStack() {
		return this.table;
	}
}
