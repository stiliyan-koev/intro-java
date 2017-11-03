package com.sirma.itt.javacourse.exceptions.notinrange;

/**
 * Exception when the given number is not between the range of 1-100.
 * 
 * @author Stiliyan Koev
 */
public class NotInRangeException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "The number is not withing the range of 1-100";

	/**
	 * The default exception constructor.
	 */
	public NotInRangeException() {

	}

	/**
	 * Constructor with cause to be thrown.
	 * 
	 * @param cause
	 *            - Cause that must be thrown.
	 */
	public NotInRangeException(Throwable cause) {
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
	public NotInRangeException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Returning the error message as String.
	 * 
	 * @return - The error message.
	 */
	public String getMessage() {
		return MESSAGE;
	}
}
