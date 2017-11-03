package com.sirma.itt.javacourse.exceptions.arraywithargumentstask;

/**
 * ArrayFullException would be thrown when one array is full and has no more
 * space in it.
 * 
 * @author Stiliyan Koev
 */
public class ArrayFullException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * The default exception constructor.
	 */
	public ArrayFullException() {

	}

	/**
	 * Constructor with message to be thrown.
	 * 
	 * @param message
	 *            - The message that must be thrown.
	 */
	public ArrayFullException(String message) {
		super(message);
	}

	/**
	 * Constructor with cause to be thrown.
	 * 
	 * @param cause
	 *            - Cause that must be thrown.
	 */
	public ArrayFullException(Throwable cause) {
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
	public ArrayFullException(String message, Throwable cause) {
		super(message, cause);
	}

}
