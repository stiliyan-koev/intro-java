package com.sirma.itt.javacourse.collections.pages;

import java.util.ArrayList;
import java.util.List;

/**
 * PageBean task.
 * 
 * @author Stiliyan Koev
 */
public class PageBean {
	private List<Object> book = new ArrayList<Object>();
	private int currentPageNumber = 0;

	/**
	 * Getter for book.
	 * 
	 * @return - The book.
	 */
	public List<Object> getBook() {
		return book;
	}

	/**
	 * Setter for book.
	 * 
	 * @param newBook
	 *            - The book to be set.
	 */
	public void setBook(List<Object> newBook) {
		this.book = newBook;
	}

	/**
	 * Distributing the elements to pages.
	 * 
	 * @param pageSize
	 *            - Represent how many elements per page will the book have.
	 * @param listOfElements
	 *            - All of the elements to be distributed.
	 */
	public void listToPages(int pageSize, List<Object> listOfElements) {
		for (int i = 0; i < listOfElements.size(); i += pageSize) {
			List<Object> pageContent = new ArrayList<Object>();
			for (int j = 0; j < pageSize; j++) {
				if (j + i >= listOfElements.size()) {
					break;
				} else {
					pageContent.add(listOfElements.get(j + i));
				}
			}
			addPageToBook(pageContent);
		}
	}

	/**
	 * Adding the page to the book content.
	 * 
	 * @param pageContent
	 *            - The new page to be added.
	 */
	public void addPageToBook(List<Object> pageContent) {
		book.add(pageContent);
		setBook(book);
	}

	/**
	 * Takes the next list of elements (page).
	 * 
	 * @return - Next list of elements.
	 */
	public Object next() {
		if (currentPageNumber + 1 != book.size()) {
			currentPageNumber++;
			return book.get(currentPageNumber);
		} else {
			return null;
		}
	}

	/**
	 * Takes the previous list of elements (page).
	 * 
	 * @return - Previous list of elements.
	 */
	public Object previous() {
		if (currentPageNumber > 0) {
			currentPageNumber--;
			return book.get(currentPageNumber);
		} else {
			return null;
		}
	}

	/**
	 * Shows is there a next list of elements.
	 * 
	 * @return - True if yes, false if not.
	 */
	public Boolean hasNext() {
		return currentPageNumber + 1 < book.size();
	}

	/**
	 * Shows is there a previous list of elements.
	 * 
	 * @return - True if yes, false if not.
	 */
	public Boolean hasPrevious() {
		return !(currentPageNumber - 1 <= 0);
	}

	/**
	 * Get and returns the first page of list elements. Also sets the current
	 * page to 0, because it is currently on the first page.
	 * 
	 * @return - The first page of elements.
	 */
	public Object firstPage() {
		currentPageNumber = 0;
		return book.get(0);
	}

	/**
	 * Get and returns the last page of list elements. Also sets the current
	 * page to the last page, because it is currently on the last page.
	 * 
	 * @return - The last page of elements.
	 */
	public Object lastPage() {
		currentPageNumber = book.size() - 1;
		return book.get(currentPageNumber);
	}

	/**
	 * Gets the current page number.
	 * 
	 * @return - A number representing current page number.
	 */
	public int getCurrentPageNumber() {
		return currentPageNumber + 1;
	}
}
