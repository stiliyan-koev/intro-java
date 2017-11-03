package com.sirma.itt.javacourse.collections.pages;

import java.util.ArrayList;
import java.util.List;

import com.sirma.itt.javacourse.utilities.ConsoleWriter;

/**
 * Run class for {@link PageBean}.
 * 
 * @author Stiliyan Koev.
 */
public class PageBeanRunClass {

	/**
	 * Private constructor.
	 */
	private PageBeanRunClass() {

	}

	/**
	 * Main entry point class.
	 * 
	 * @param args
	 *            - String arguments.
	 */
	public static void main(String[] args) {
		List<Object> content = new ArrayList<Object>();
		PageBean book = new PageBean();
		content.add("a");
		content.add("b");
		content.add("c");
		content.add("d");
		content.add("e");
		content.add("f");
		content.add("g");
		content.add("h");
		content.add("i");
		content.add("j");
		content.add("k");
		content.add("l");
		content.add("m");
		content.add("n");
		content.add("o");
		content.add("p");
		content.add("q");
		content.add("r");
		content.add("s");
		content.add("t");
		content.add("u");
		book.listToPages(5, content);
		ConsoleWriter.write(book.next());
		ConsoleWriter.write(book.previous());
		ConsoleWriter.write(book.hasNext());
		ConsoleWriter.write(book.hasPrevious());
		ConsoleWriter.write(book.firstPage());
		ConsoleWriter.write(book.lastPage());
		ConsoleWriter.write(book.getCurrentPageNumber());
	}
}
