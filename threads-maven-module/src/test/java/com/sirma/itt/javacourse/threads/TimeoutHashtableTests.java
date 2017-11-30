package com.sirma.itt.javacourse.threads;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.simra.itt.javacourse.threads.timeout_hashtable.Command;
import com.simra.itt.javacourse.threads.timeout_hashtable.TimeoutHashtable;

/**
 * JUnit tests for {@link TimeoutHashtable}.
 * 
 * @author Stiliyan Koev
 */
public class TimeoutHashtableTests {
	/**
	 * By the time second element is added, the first one should be deleted due
	 * to not being used over the time.
	 * 
	 * @throws InterruptedException
	 *             - Interrupted exception may occur !
	 */
	@Test
	public void testAddAndTimedDelete() throws InterruptedException {
		TimeoutHashtable stack = new TimeoutHashtable();

		stack.put("one", 1);
		TimeUnit.SECONDS.sleep(5);
		synchronized (stack) {

			stack.put("two", 2);
			TimeUnit.SECONDS.sleep(5);
			assertEquals(stack.getStack().size(), 1);
			assertEquals(stack.get("two"), 2);

		}
	}

	/**
	 * Testing update method.
	 * 
	 * @throws InterruptedException
	 *             - Interrupted exception may occur !
	 */
	@Test
	public void testUpdate() throws InterruptedException {
		TimeoutHashtable stack = new TimeoutHashtable();

		stack.put("one", 1);
		TimeUnit.SECONDS.sleep(5);
		stack.update("one", Command.UPDATE);
		TimeUnit.SECONDS.sleep(5);
		assertEquals(stack.getStack().size(), 1);

	}

}
