package com.sirma.itt.javacourse.networkinggui.calculator;

import javax.swing.AbstractButton;
import javax.swing.JButton;

import com.sirma.itt.javacourse.utilities.ConsoleWriter;

/**
 * Buttons for calculator.
 * 
 * @author Stiliyan Koev.
 */
public class Buttons extends AbstractButton {
	private static final long serialVersionUID = 1L;
	private String value;
	private String name;
	private JButton button;

	/**
	 * Constructor.
	 * 
	 * @param value
	 */
	public Buttons(String value) {
		name = "button" + value;
		this.value = value;
		button = new JButton(value);
		try {
			Integer.parseInt(value);
		} catch (NumberFormatException e) {
			ConsoleWriter.getLogger().warn("Exception occured !" + e);
		}
	}

	/**
	 * Getter for value.
	 * 
	 * @return - parameter value.
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 
	 * Getter for name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter for button.
	 * 
	 * @return - the button.
	 */
	public JButton getButton() {
		return button;
	}
}
