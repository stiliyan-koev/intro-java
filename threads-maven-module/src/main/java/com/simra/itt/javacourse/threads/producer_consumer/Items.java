package com.simra.itt.javacourse.threads.producer_consumer;

import java.util.Random;

/**
 * Class with string elements playing a role of items for {@link Factory}.
 * 
 * @author Stiliyan Koev
 */
public class Items {
	/**
	 * Getting a random item from array.
	 * 
	 * @return - A string item representing item for factory.
	 */
	public String getRandomItem() {
		String[] items = new String[] { "VW Golf 5", "Volvo S60", "Bugatti Veyron", "Porsche 911", "BMW M6",
				"Mitsubishi Lancer Evo XIV", "Subaru Impreza WRX STI", "Ferrari LaFerrari", "McLaren P1", "Mazda RX8" };
		Random rand = new Random();
		return items[rand.nextInt(items.length) + 0];
	}
}
