package com.sirma.itt.javacourse.objects;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

import com.sirma.itt.javacourse.objects.sumator.Sumator;

/**
 * Test cases for {@Sumator}.
 * 
 * @author User
 */
public class SumatorTests {
	Sumator sumator = new Sumator();

	/**
	 * Test with two integer numbers.
	 */
	@Test
	public void twoIntegerNumbers() {
		int firstNumber = 20;
		int secondNumber = 25;
		int actual = sumator.sum(firstNumber, secondNumber);
		int expected = 45;
		Assert.assertEquals((long) actual, (long) expected);
	}

	/**
	 * Test with two negative integer numbers
	 */
	@Test
	public void twoIntegerNegativeNumbers() {
		int firstNumber = -20;
		int secondNumber = -25;
		int actual = sumator.sum(firstNumber, secondNumber);
		int expected = -45;
		Assert.assertEquals((long) actual, (long) expected);
	}

	/**
	 * Test with two float numbers.
	 */
	@Test
	public void twoFloatNumbers() {
		float firstNumber = 20.0f;
		float secondNumber = 25.0f;
		float actual = sumator.sum(firstNumber, secondNumber);
		float expected = 45.0f;
		float delta = 0.1f;
		Assert.assertEquals((float) expected, (float) actual, (float) delta);
	}

	/**
	 * Test with two negative float numbers.
	 */
	@Test
	public void twoFloatNegativeNumbers() {
		float firstNumber = -20.0f;
		float secondNumber = -25.0f;
		float actual = sumator.sum(firstNumber, secondNumber);
		float expected = -45.0f;
		float delta = 0.1f;
		Assert.assertEquals((float) expected, (float) actual, (float) delta);
	}

	/**
	 * Test with two String numbers.
	 */
	@Test
	public void twoStringNumbers() {
		String firstNumber = "20";
		String secondNumber = "25";
		String actual = sumator.sum(firstNumber, secondNumber);
		String expected = "45";
		Assert.assertEquals((Object) actual, (Object) expected);
	}

	/**
	 * Test with two BigInteger numbers.
	 */
	@Test
	public void twoBigIntegerNumbers() {
		BigInteger firstNumber = new BigInteger("20");
		BigInteger secondNumber = new BigInteger("25");
		BigInteger actual = sumator.sum(secondNumber, firstNumber);
		BigInteger expected = new BigInteger("45");
		Assert.assertEquals((Object) actual.toString(), (Object) expected.toString());
	}

	/**
	 * Test with two negative BigInteger numbers.
	 */
	@Test
	public void twoBigIntegerNegativeNumbers() {
		BigInteger firstNumber = new BigInteger("-20");
		BigInteger secondNumber = new BigInteger("-25");
		BigInteger actual = sumator.sum(secondNumber, firstNumber);
		BigInteger expected = new BigInteger("-45");
		Assert.assertEquals((Object) actual, (Object) expected);
	}

	/**
	 * Test with two BigDecimal numbers.
	 */
	@Test
	public void twoBigDecimalNumbers() {
		BigDecimal firstNumber = new BigDecimal("20");
		BigDecimal secondNumber = new BigDecimal("25");
		BigDecimal actual = sumator.sum(secondNumber, firstNumber);
		BigDecimal expected = new BigDecimal("45");
		Assert.assertEquals((Object) actual, (Object) expected);
	}

	/**
	 * Test with two negative BigDecimal numbers.
	 */
	@Test
	public void twoBigDecimalNegativeNumbers() {
		BigDecimal firstNumber = new BigDecimal("-20");
		BigDecimal secondNumber = new BigDecimal("-25");
		BigDecimal actual = sumator.sum(secondNumber, firstNumber);
		BigDecimal expected = new BigDecimal("-45");
		Assert.assertEquals((Object) actual, (Object) expected);
	}
}