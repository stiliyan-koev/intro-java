package com.simra.itt.javacourse.threads.synchronized_stack;

import java.util.ArrayList;
import java.util.List;

import com.sirma.itt.javacourse.utilities.ConsoleWriter;

/**
 * Stack body for Synchronized Stack task.
 * 
 * @author Stiliyan Koev
 */
public class Stack {
	private List<Object> listWithObjects;
	private int size;

	/**
	 * Constructor for Stack.
	 * 
	 * @param size
	 *            - Size of stack.
	 */
	public Stack(int size) {
		listWithObjects = new ArrayList<Object>(size);
		this.size = size;
	}

	/**
	 * One method doing two things - if option is "1" it adds, if it is "2" it
	 * removes an elements to/from stack.
	 * 
	 * @param option
	 *            - 1 - add, 2 - remove.
	 * @param obj
	 *            - An object to manipulate.
	 */
	public void addOrRemove(int option, Object obj) {
		synchronized (this) {
			switch (option) {
			case 1:
				if (listWithObjects.size() == size) {
					caseArrayIsFullOnAddCommand();
				} else {
					listWithObjects.add(obj);
					this.notifyAll();
				}
				break;

			case 2:
				if (listWithObjects.isEmpty()) {
					caseArrayIsEmptyOnRemoveCommand();

				} else {

					int numberDeleted = (int) listWithObjects.get((listWithObjects.size() - 1));
					ConsoleWriter.write("Deleted: " + numberDeleted);
					listWithObjects.remove(listWithObjects.size() - 1);
					this.notifyAll();
				}
				break;
			default:
				break;
			}
		}
	}

	public void caseArrayIsFullOnAddCommand() {
		ConsoleWriter.write("Array full. Waiting someone to be deleted !" + System.lineSeparator());
		try {
			this.wait();
		} catch (InterruptedException e) {
			ConsoleWriter.getLogger().error("Interrupted Exception occured !" + e);
		}

	}

	public void caseArrayIsEmptyOnRemoveCommand() {
		try {
			ConsoleWriter.write("Array empty. Waiting for a new element !" + System.lineSeparator());
			this.wait();

		} catch (InterruptedException e) {
			ConsoleWriter.getLogger().error("Interrupted Exception occured !" + e);
		}
	}

	/**
	 * Getting an index at position.
	 * 
	 * @param position
	 *            - Position of an index to get the value from.
	 * @return - Object at index.
	 */
	public Object getIndexAt(int position) {
		return listWithObjects.get(position);
	}

	/**
	 * Printing all elements.
	 */
	public void printAllElements() {
		String theList = "";
		for (int i = 0; i < size; i++) {
			theList = theList + listWithObjects.get(i) + " ";
		}
		ConsoleWriter.write(theList);
	}

	/**
	 * Getter for listWithobjects
	 * 
	 * @return - list with objects.
	 */
	public List<Object> getListWithObjects() {
		return listWithObjects;
	}

	/**
	 * Getter for size.
	 * 
	 * @return - size as int.
	 */
	public int getSize() {
		return size;
	}
}
