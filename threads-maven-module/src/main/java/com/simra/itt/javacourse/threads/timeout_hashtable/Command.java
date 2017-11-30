package com.simra.itt.javacourse.threads.timeout_hashtable;

/**
 * Commands for TimeoutHashtable.
 * 
 * @author Stiliyan Koev
 */
public enum Command {
	UPDATE("Update"), DELETE("DELETE"), ADD("ADD");
	private String displayName;

	/**
	 * Constructor for Command.
	 * 
	 * @param displayName
	 *            - the command.
	 */
	private Command(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}