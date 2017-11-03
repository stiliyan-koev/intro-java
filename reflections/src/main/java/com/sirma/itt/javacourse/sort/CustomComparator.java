package com.sirma.itt.javacourse.sort;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Custom created comparator comparing by age.
 * 
 * @author Stiliyan Koev.
 */
public class CustomComparator implements Comparator<Human>, Serializable {
	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Custom comparator class, comparing the anotation values of each class.
	 * {@inheritDoc} //to ask what is this.
	 */
	@Override
	public int compare(Human class1, Human class2) {
		int result = 0;

		People annotation = class1.getClass().getAnnotation(People.class);
		int age1 = annotation.age();

		People anotation2 = class2.getClass().getAnnotation(People.class);
		int age2 = anotation2.age();

		if (age1 > age2) {
			result = 1;
		} else if (age1 < age2) {
			result = -1;
		}

		return result;
	}

}
