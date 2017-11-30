package com.sirma.itt.javacourse.threads;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.simra.itt.javacourse.threads.producer_consumer.Consumer;
import com.simra.itt.javacourse.threads.producer_consumer.Factory;
import com.simra.itt.javacourse.threads.producer_consumer.Producer;
import com.simra.itt.javacourse.threads.producer_consumer.ProducerConsumerRunClass;

/**
 * JUnit tests for {@link ProducerConsumerRunClass}.
 * 
 * @author Stiliyan Koev.
 */
public class ProducerConsumerTests {
	/**
	 * Tests addStock and sellStock methods.
	 */
	@Test
	public void testFactory() {
		Factory shop = new Factory();
		shop.setShouldStop(false);
		assertEquals(shop.getShouldStop(), false);
		Producer producer = new Producer(shop);
		Consumer consumer = new Consumer(shop);

		producer.addStock("Ice cream");
		producer.addStock("Ice candy");
		producer.addStock("Ice cake");
		assertEquals(shop.getInStock().size(), 3);

		consumer.sellStock();
		assertEquals(shop.getInStock().size(), 2);
	}

}
