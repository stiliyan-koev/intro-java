package com.sirma.itt.javacourse.exceptions.arraywithargumentstask;

/**
 * ArrayEmptyException would be thrown when one array is empty and has nothing
 * to delete anymore.
 * 
 * @author Stiliyan Koev
 */
public class ArrayEmptyException extends Exception {
	private static final long serialVersionUID = 1L;
	private static final String ERROR_MESSAGE = "Array is empty";

	/**
	 * Default empty constructor.
	 */
	public ArrayEmptyException() {

	}

	/**
	 * Constructor with cause to be thrown.
	 * 
	 * @param cause
	 *            - Cause that must be thrown.
	 */
	public ArrayEmptyException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor with message and cause to be thrown.
	 * 
	 * @param message
	 *            - The message that must be thrown.
	 * @param cause
	 *            - Cause that must be thrown.
	 */
	public ArrayEmptyException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Returning the error message as String.
	 * 
	 * @return - The error message.
	 */
	public String getErrorMessage() {
		return ERROR_MESSAGE;
	}
}
