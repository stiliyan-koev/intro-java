package com.sirma.itt.javacourse.sort;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Declaration of anotation @Sort.
 * 
 * @author Stiliyan Koev
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface People {
	/**
	 * Name of people.
	 * 
	 * @return - the name of instance of people.
	 */
	String name();

	/**
	 * Ages of people.
	 * 
	 * @return - the age of instance of people.
	 */
	int age();

}
