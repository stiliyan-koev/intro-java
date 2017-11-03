package com.sirma.itt.javacourse.sort;

/**
 * Anotation @Sort which has 2 attributes: name and age.
 * 
 * @Child2 implementing his parent class @Human.
 * @author Stiliyan Koev
 */
@People(name = "", age = 35)
public class Father implements Human {
	private String name;

	/**
	 * Constructor for {@link Father}.
	 * 
	 * @param name
	 *            - name of Father.
	 */
	public Father(String name) {
		this.name = name;
	}

	@Override
	public String toString() {

		return name;
	}
}
