package com.sirma.itt.javacourse.threads;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.javacourse.threads.two_threads_counter.TwoCounterThreads;

/**
 * JUnit tests for {@link TwoCounterThreads}.
 * 
 * @author Stiliyan Koev
 */
public class TwoCountersThreadTests {
	/**
	 * Testing two counters. One should stop another.
	 * 
	 * @throws InterruptedException
	 *             - Interrupted exception may occur !.
	 */
	@Test
	public void testTwoCounters() throws InterruptedException {

		TwoCounterThreads seven = new TwoCounterThreads(7);
		TwoCounterThreads ten = new TwoCounterThreads(10);

		seven.start();
		ten.start();
		seven.join();
		ten.join();

		assertEquals(seven.getCounter(), 7);
		assertEquals(ten.getCounter(), 7);

	}

}
