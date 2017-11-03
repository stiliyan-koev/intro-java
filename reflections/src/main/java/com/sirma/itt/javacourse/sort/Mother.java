package com.sirma.itt.javacourse.sort;

/**
 * Anotation @Sort which has 2 attributes: name and age.
 * 
 * @Mother implementing his parent class @Human.
 * @author Stiliyan Koev
 */
@People(name = "", age = 25)

public class Mother implements Human {
	private String name;

	/**
	 * Constructor for {@link Mother}.
	 * 
	 * @param name
	 *            - name of Mother.
	 */
	public Mother(String name) {
		this.name = name;
	}

	/**
	 * Getter for name.
	 * 
	 * @return - a name as String.
	 */
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}
}
