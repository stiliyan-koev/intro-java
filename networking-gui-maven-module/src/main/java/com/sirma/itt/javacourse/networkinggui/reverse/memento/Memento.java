package com.sirma.itt.javacourse.networkinggui.reverse.memento;

/**
 * Memento design pattern.
 * 
 * @author Stiliyan Koev
 */
public class Memento {
	private String article;

	/**
	 * Save a new article String to the memento Object
	 */
	public Memento(String articleSave) {
		article = articleSave;
	}

	/**
	 * Return the value stored in article
	 */
	public String getSavedArticle() {
		return article;
	}
}
