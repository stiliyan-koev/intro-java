package com.sirma.itt.javacourse.threads;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.simra.itt.javacourse.threads.synchronized_threads.SynchronizedThread;

/**
 * JUnit tests for {@link SynchronizedThread}.
 * 
 * @author Stiliyan Koev
 */
public class SynchronizedThreadsTests {
	/**
	 * Testing both threads counting.
	 * 
	 * @throws InterruptedException
	 *             - Interrupted exception may occur !
	 */
	@Test
	public void testTwoThreadsCounting() throws InterruptedException {

		SynchronizedThread threadOne = new SynchronizedThread(5, "t1");
		SynchronizedThread threadTwo = new SynchronizedThread(7, "t2");
		threadOne.start();
		threadTwo.start();
		threadOne.join();
		threadTwo.join();

		assertEquals(threadOne.getThreadName(), "t1");
		assertEquals(threadOne.getCounter(), 5);

		assertEquals(threadTwo.getThreadName(), "t2");
		assertEquals(threadTwo.getCounter(), 7);
	}
}
