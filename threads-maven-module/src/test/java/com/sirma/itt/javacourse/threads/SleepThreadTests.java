package com.sirma.itt.javacourse.threads;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.simra.itt.javacourse.threads.counter_with_sleep.SleepThread;

/**
 * JUnit tests for {@link SleepThread}.
 * 
 * @author Stiliyan Koev.
 */
public class SleepThreadTests {
	/**
	 * Testing two threads.
	 * 
	 * @throws InterruptedException
	 *             - Interrupted exception may occur !
	 */
	@Test
	public void testTwoSleepThread() throws InterruptedException {
		SleepThread threadOne = new SleepThread(5, "t1");
		SleepThread threadTwo = new SleepThread(7, "t2");
		assertEquals(threadOne.getLimit(), 5);
		assertEquals(threadTwo.getLimit(), 7);

		threadOne.start();
		threadTwo.start();
		threadOne.join();
		threadTwo.join();

		assertEquals(threadOne.getThreadName(), "t1");
		assertEquals(threadOne.getCounter(), 5);

		assertEquals(threadTwo.getThreadName(), "t2");
		assertEquals(threadTwo.getCounter(), 7);
	}

	// how to catch this
	@Test(expected = InterruptedException.class)
	public void testInterrupt() {
		SleepThread threadOne = new SleepThread(5, "t1");
		threadOne.start();
		threadOne.interrupt();
	}
}
