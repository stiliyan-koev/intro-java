package com.sirma.itt.javacourse.networkinggui.reverse.memento;

/**
 * Caretaker class of Memento design pattern.
 * 
 * @author Stiliyan Koev.
 */
class Caretaker {

	private Object obj;

	/**
	 * Saving new object to Originator.
	 * 
	 * @param fileWriter
	 *            - Where to save.
	 */
	public void save(Originator fileWriter) {
		this.obj = fileWriter.save();
	}

	/**
	 * Undo the last save.
	 * 
	 * @param fileWriter
	 *            - Where it was saved.
	 */
	public void undo(Originator fileWriter) {
		fileWriter.undoToLastSave(obj);
	}
}