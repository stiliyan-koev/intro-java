package com.sirma.itt.javacourse.collections;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.sirma.itt.javacourse.collections.lru.LRUcache;

/**
 * Tests for {@link LeastRecentlyUsed}.
 * 
 * @author Stiliyan Koev.
 */
public class LeastRecentlyUsedTests {
	/**
	 * Testing with Integers.
	 */
	@Test
	public void testWithInts() {
		Object[] numbers = { 2, 1, 6, 2, 5, 6, 3, 1, 3, 6, 1, 1, 1, 3 };
		LRUcache cache = new LRUcache(3);
		Map<Integer, Object> lruResults = new HashMap<Integer, Object>(3);

		lruResults = cache.leastRecentlyUsed(numbers);
		assertEquals(3, lruResults.get(0));
		assertEquals(1, lruResults.get(1));
		assertEquals(6, lruResults.get(2));

		assertEquals("3 1 6 ", cache.toString());
		cache.clean();

	}

	/**
	 * Testing with Strings.
	 */
	@Test
	public void testWithString() {
		Map<Integer, Object> lruResults = new HashMap<Integer, Object>(3);
		LRUcache cache = new LRUcache(3);
		Object[] words = { "One", "Two", "Three", "Four", "Five", "Six", "Seven", };

		lruResults = cache.leastRecentlyUsed(words);

		assertEquals("Seven", lruResults.get(0));
		assertEquals("Five", lruResults.get(1));
		assertEquals("Six", lruResults.get(2));
		assertEquals("Seven Five Six ", cache.toString());
		cache.clean();

	}

	/**
	 * Testing with Chars.
	 */
	@Test
	public void testWithChars() {
		Map<Integer, Object> lruResults = new HashMap<Integer, Object>(3);
		LRUcache cache = new LRUcache(3);

		Object[] chars = { 'a', 'b', 'a', 'e', 'f', 'a', 'c', 'a', 'a', };
		lruResults = cache.leastRecentlyUsed(chars);

		assertEquals('a', lruResults.get(0));
		assertEquals('f', lruResults.get(1));
		assertEquals('c', lruResults.get(2));
		assertEquals("a f c ", cache.toString());
		cache.clean();
	}

}
