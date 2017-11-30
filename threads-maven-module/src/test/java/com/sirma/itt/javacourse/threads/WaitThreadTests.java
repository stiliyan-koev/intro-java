package com.sirma.itt.javacourse.threads;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.simra.itt.javacourse.threads.counter_with_wait.WaitThread;

/**
 * JUnit tests for {@link WaitThread}.
 * 
 * @author Stiliyan Koev.
 */
public class WaitThreadTests {
	/**
	 * Testing two threads to count.
	 * 
	 * @throws InterruptedException
	 *             - Interrupted exception may occur !.
	 */
	@Test
	public void testTwoCounters() throws InterruptedException {

		WaitThread threadOne = new WaitThread(5, "t1");
		WaitThread threadTwo = new WaitThread(7, "t2");
		threadOne.start();
		threadTwo.start();
		threadOne.join();
		threadTwo.join();

		assertEquals(threadOne.getThreadName(), "t1");
		assertEquals(threadOne.getCounter(), 5);

		assertEquals(threadTwo.getThreadName(), "t2");
		assertEquals(threadTwo.getCounter(), 5);
	}
}
