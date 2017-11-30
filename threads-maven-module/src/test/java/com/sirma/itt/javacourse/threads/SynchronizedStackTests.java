
package com.sirma.itt.javacourse.threads;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.simra.itt.javacourse.threads.synchronized_stack.Stack;

/**
 * JUnit tests for {@link Stack}.
 * 
 * @author Stiliyan Koev
 */
public class SynchronizedStackTests {
	/**
	 * Testing add and delete methods.
	 * 
	 * @throws InterruptedException
	 *             - Interrupted exception may occur !
	 */
	@Test
	public void testAddAndDelete() throws InterruptedException {
		Stack body = new Stack(2);

		assertEquals(2, body.getSize());
		body.addOrRemove(1, 2);
		assertEquals(1, body.getListWithObjects().size());

		body.addOrRemove(2, 5);
		assertEquals(0, body.getListWithObjects().size());

		body.addOrRemove(1, 2);
		body.addOrRemove(1, 5);
		assertEquals(2, body.getListWithObjects().size());

		body.addOrRemove(2, 2);
		body.addOrRemove(2, 5);
		assertEquals(0, body.getListWithObjects().size());

	}
}
