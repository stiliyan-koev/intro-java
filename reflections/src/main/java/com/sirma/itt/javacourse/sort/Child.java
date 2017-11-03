package com.sirma.itt.javacourse.sort;

/**
 * Anotation @Sort which has 2 attributes: name and age.
 * 
 * @author Stiliyan Koev
 */
@People(name = "", age = 10)
public class Child implements Human {
	private String name;

	/**
	 * Constructor with parameter.
	 * 
	 * @param name
	 *            - Name of child.
	 */
	public Child(String name) {
		this.name = name;
	}

	@Override
	public String toString() {

		return name;
	}
}
