package com.sirma.itt.javacourse.collections.lru;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.itt.javacourse.utilities.ConsoleReader;

/**
 * Class presenting least recentrly used cache.
 * 
 * @author Stiliyan Koev
 */
public class LRUcache {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	private Map<Integer, Object> cache = null;
	private Queue<Integer> priorities = new LinkedList<Integer>();
	private int size = 0;

	/**
	 * Constructor with parameter.
	 * 
	 * @param size
	 *            - This shows how many elements you want to be kept in the
	 *            cache.
	 */
	public LRUcache(int size) {
		this.size = size;
		this.cache = new HashMap<Integer, Object>(size);

	}

	/**
	 * Putting elements with keys in the cache.
	 * 
	 * @param elements
	 *            - Elements to be inserted.
	 * @return - Cache full with elements.
	 */
	public Map<Integer, Object> leastRecentlyUsed(Object[] elements) {
		for (int i = 0; i < elements.length; i++) {
			addElement(elements[i]);
		}
		return cache;
	}

	/**
	 * Add a single element to the cache.
	 * 
	 * @param newElement
	 * @return - A map with least recently used elements.
	 */
	public Map<Integer, Object> addElement(Object newElement) {

		if (!cache.containsValue(newElement)) {
			if (cache.size() < size) {
				cache.put(cache.size(), newElement);
				priorities.add(priorities.size());
			} else {
				cache.replace(priorities.peek(), newElement);
				priorities.add(priorities.poll());
			}
		} else {
			priorities.add(priorities.poll());
		}
		return cache;
	}

	/**
	 * Creates a string with least recently used elements.
	 * 
	 * @return - A string with LRU.
	 */
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < cache.size(); i++) {
			stringBuilder.append(cache.get(i));
			stringBuilder.append(" ");
		}
		return stringBuilder.toString();
	}

	/**
	 * User input to array.
	 * 
	 * @return - The elements in array.
	 */
	public void userNumbers() {
		LOGGER.info("Type in how many numbers you will want to enter: ");
		int sizeOfArray = ConsoleReader.validatePositiveIntNumber();
		Object[] elements = new Object[sizeOfArray];
		for (int i = 0; i < sizeOfArray; i++) {
			LOGGER.info("Type in number: ");
			elements[i] = ConsoleReader.readInt();
		}
		leastRecentlyUsed(elements);
	}

	/**
	 * Deleting every element from the cache.
	 */
	public void clean() {
		this.cache = null;
		this.priorities = new LinkedList<Integer>();
		this.size = 0;
	}
}
