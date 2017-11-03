package com.sirma.itt.javacourse.reflannotregex;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.sirma.itt.javacourse.sort.Child;
import com.sirma.itt.javacourse.sort.CustomComparator;
import com.sirma.itt.javacourse.sort.Father;
import com.sirma.itt.javacourse.sort.Human;
import com.sirma.itt.javacourse.sort.Mother;
import com.sirma.itt.javacourse.sort.People;

/**
 * Testing the anotation sort. Child1 fields: name = name = "Asen", age = 15;
 * Child2 fields: name = "Georgi", age = 23; Child3 fields: name = "Todor", age
 * = 10;
 * 
 * @author Stiliyan Koev
 */
public class AnnotationSortTests {

	@Test
	public void testSort() throws NoSuchFieldException, SecurityException {
		Mother mother = new Mother("Ginka");
		Father father = new Father("Petar");
		Child child = new Child("Goshko");
		assertEquals("Ginka", mother.getName());
		List<Human> list = new ArrayList<>();

		list.add(mother);
		list.add(child);
		list.add(father);

		Collections.sort(list, new CustomComparator());

		assertEquals("Goshko", list.get(0).toString());
		assertEquals(10, list.get(0).getClass().getAnnotation(People.class).age());

		assertEquals("Ginka", list.get(1).toString());
		assertEquals(25, list.get(1).getClass().getAnnotation(People.class).age());

		assertEquals("Petar", list.get(2).toString());
		assertEquals(35, list.get(2).getClass().getAnnotation(People.class).age());

	}

}
