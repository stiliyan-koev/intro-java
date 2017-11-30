package com.sirma.itt.javacourse.networkinggui.reverse.memento;

import java.util.ArrayList;

/**
 * Originator class for Memento design pattern.
 * 
 * @author Stiliyan Koev
 */
public class Originator {

	private String fileName;
	private ArrayList<String> content = new ArrayList<String>();
	private static Originator INSTANCE = null;
	private int currentPosition = 0;

	/**
	 * Getting a single instance of Originator.
	 * 
	 * @return - return the only instance.
	 */
	public static Originator getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Originator();
			return INSTANCE;
		} else {
			return INSTANCE;
		}
	}

	@Override
	public String toString() {
		return this.content.toString();
	}

	/**
	 * Adding string to memento.
	 * 
	 * @param str
	 *            - the string to be added.
	 */
	public void addToMemento(String string) {
		content.add(string);
		currentPosition = content.size();
	}

	/**
	 * Getting previous message.
	 * 
	 * @return - previous message as string.
	 */
	public String getPreviousMessage() {
		if (currentPosition <= 0) {
			return content.get(0);
		} else {
			currentPosition--;
			String item = content.get(currentPosition);
			return item;
		}
	}

	/**
	 * Getting next message.
	 * 
	 * @return - next message as string.
	 */
	public String getNextMessage() {
		if (currentPosition + 1 >= content.size()) {
			return content.get(content.size() - 1);
		} else {
			currentPosition++;
			String item = content.get(currentPosition);
			return item;
		}
	}

	/**
	 * Save this memento as new memento.
	 * 
	 * @return - Return the new memento.
	 */
	public Memento save() {
		return new Memento(this.fileName, this.content);
	}

	/**
	 * Undo last saved memento.
	 * 
	 * @param obj
	 *            - Object to be undo.
	 */
	public void undoToLastSave(Object obj) {
		Memento memento = (Memento) obj;
		this.fileName = memento.fileName;
		this.content = memento.content;
	}

	/**
	 * Memento class.
	 * 
	 * @author Stiliyan Koev.
	 */
	private class Memento {
		private String fileName;
		private ArrayList<String> content;

		/**
		 * Constructor.
		 * 
		 * @param file
		 *            - file to write in.
		 * @param content
		 *            - content in file.
		 */
		public Memento(String file, ArrayList<String> content) {
			this.fileName = file;
			this.content = new ArrayList<String>(content);
		}
	}
}