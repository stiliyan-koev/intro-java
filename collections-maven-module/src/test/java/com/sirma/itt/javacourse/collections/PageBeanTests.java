package com.sirma.itt.javacourse.collections;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.sirma.itt.javacourse.collections.pages.PageBean;

/**
 * Tests for {@link PageBean}.
 * 
 * @author Stiliyan Koev.
 */
public class PageBeanTests {
	@Test
	public void testPageBean() {
		PageBean book = new PageBean();
		assertEquals(book.hasPrevious(), false);
		ArrayList<Object> listOfElements = new ArrayList<Object>();
		listOfElements.add("a");
		listOfElements.add("b");
		listOfElements.add("c");
		listOfElements.add("d");
		listOfElements.add("e");
		listOfElements.add("f");
		listOfElements.add("g");
		listOfElements.add("h");
		listOfElements.add("i");

		book.listToPages(2, listOfElements);
		assertEquals(1, book.getCurrentPageNumber());

		assertEquals("[c, d]", book.next().toString());
		assertEquals(2, book.getCurrentPageNumber());
		assertEquals("[a, b]", book.previous().toString());
		assertEquals(true, book.hasNext());
		assertEquals(false, book.hasPrevious());
		assertEquals("[a, b]", book.firstPage().toString());
		assertEquals(false, book.hasPrevious());
		assertEquals(null, book.previous());

		assertEquals("[i]", book.lastPage().toString());
		assertEquals(book.hasPrevious(), true);
		assertEquals(false, book.hasNext());
		assertEquals(null, book.next());
	}

}
