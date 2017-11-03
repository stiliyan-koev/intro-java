package com.sirma.itt.javacourse.collections.exceptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ExceptionMessageManager task.
 * 
 * @author Stiliyan Koev
 */
public class ExceptionsMessageManager {
	private Map<String, String> messageManager = new HashMap<String, String>();
	private String message = "";

	/**
	 * Creates a with values and keys.
	 */
	public ExceptionsMessageManager() {
		String[] values = { "Invalid EGN", "Invalid card number", "Invalid postal code" };
		String[] keys = { "EGN", "Card number", "Postal code" };
		for (int i = 0; i < keys.length; i++) {
			messageManager.put(keys[i], values[i]);
		}

	}

	/**
	 * Setter for message.
	 * 
	 * @param message
	 *            - message that has to be added to current message.
	 */
	public void setMessage(String message) {
		if (this.message.length() > 0) {
			this.message = this.message + "," + message;
		} else {
			this.message = message;
		}

	}

	/**
	 * Getting the exception manager's message.
	 * 
	 * @return - Returns the message as String.
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * Adding an exception message to the exception manager. IF the message is
	 * already in the manager's values it throws exception.
	 * 
	 * @param message
	 *            - Exception message given by user.
	 * @return - The exception manager or throws exception.
	 */
	public String addExceptionMessage(String message) {
		if (checkDoesTheMessageExists(message)) {
			setMessage(message);
			return getMessage();
		} else {
			throw new IllegalArgumentException("There is no such a exception message");
		}
	}

	/**
	 * Adding an exception message to the exception manager. IF the message code
	 * is already in the manager's keys it throws exception.
	 * 
	 * @param messageCode
	 *            - Exception message code given by user.
	 * @return - The exception manager or throws exception.
	 */
	public String addExceptionMessageUsingCode(String messageCode) {
		if (checkDoesTheKeyExists(messageCode)) {
			setMessage(messageCode);
			return getMessage();
		} else {
			throw new IllegalArgumentException("There is no such a exception message");
		}
	}

	/**
	 * Checks does the key given by the user is already in the exception
	 * manager's keys.
	 * 
	 * @param messageCode
	 *            - The exception key given by user.
	 * @return - True if exception manager contains the key, false if not.
	 */
	public boolean checkDoesTheKeyExists(String messageCode) {
		return messageManager.containsKey(messageCode);
	}

	/**
	 * Checks does the value given by the user is already in the exception
	 * manager's values.
	 * 
	 * @param newMessage
	 *            - The exception message given by user.
	 * @return - True if exception manager contains the key, false if not.
	 */
	public boolean checkDoesTheMessageExists(String newMessage) {
		return messageManager.containsValue(newMessage);
	}

	/**
	 * Separating all of the messages given by user to List<String>.
	 * 
	 * @param messagesCombination
	 *            - Exception messages given by user.
	 * @return - A List<String> of messages.
	 */
	public List<String> getMessages(String messagesCombination) {
		String[] messages = messagesCombination.split(",");
		return Arrays.asList(messages);
	}
}
