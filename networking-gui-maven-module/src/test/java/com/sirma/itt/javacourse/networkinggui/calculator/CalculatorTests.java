package com.sirma.itt.javacourse.networkinggui.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.javacourse.networkinggui.calculator.Buttons;
import com.sirma.itt.javacourse.networkinggui.calculator.CalculatorMemory;
import com.sirma.itt.javacourse.networkinggui.calculator.GUI;
import com.sirma.itt.javacourse.patterns.calculator.Calculator;

/**
 * JUnit tests for {@link Calculator}.
 * 
 * @author Stiliyan Koev
 */
public class CalculatorTests {
	/**
	 * Tests for button information.
	 */
	@Test
	public void buttonTests() {
		Buttons button = new Buttons("2");
		assertEquals("2", button.getValue());
		assertEquals("button2", button.getName());
		GUI gui = new GUI();
		gui.setVisible(false);
	}

	/**
	 * Tests for different keys being pressed.
	 */
	@Test
	public void calculatorMemoryTests() {
		CalculatorMemory calc = new CalculatorMemory();
		calc.pressed("1");
		calc.pressed("+");
		calc.pressed("1");

		assertEquals("1", calc.getFirstNumber());
		assertEquals("1", calc.getSecondNumber());
		assertEquals("+", calc.getOperation());
		assertEquals("2.0", calc.getResult());

		calc.pressed("c");
		assertEquals("", calc.getFirstNumber());
		assertEquals("", calc.getSecondNumber());
		assertEquals("", calc.getOperation());

		calc.pressed("A");
	}

	/**
	 * Testing minus operand with two numbers.
	 */
	@Test
	public void testMinusOperand() {
		CalculatorMemory calc = new CalculatorMemory();
		calc.pressed("1");
		calc.pressed("0");
		calc.pressed("-");
		calc.pressed("5");

		assertEquals("10", calc.getFirstNumber());
		assertEquals("5", calc.getSecondNumber());
		assertEquals("-", calc.getOperation());
		assertEquals("5.0", calc.getResult());
	}

	/**
	 * Testing multiply operand with two numbers.
	 */
	@Test
	public void testMultiplyOperand() {
		CalculatorMemory calc = new CalculatorMemory();
		calc.pressed("1");
		calc.pressed("0");
		calc.pressed("*");
		calc.pressed("5");

		assertEquals("10", calc.getFirstNumber());
		assertEquals("5", calc.getSecondNumber());
		assertEquals("*", calc.getOperation());
		assertEquals("50.0", calc.getResult());
	}

	/**
	 * Testing devide operand with two numbers.
	 */
	@Test
	public void testDevideOperand() {
		CalculatorMemory calc = new CalculatorMemory();
		calc.pressed("1");
		calc.pressed("0");
		calc.pressed("/");
		calc.pressed("5");

		assertEquals("10", calc.getFirstNumber());
		assertEquals("5", calc.getSecondNumber());
		assertEquals("/", calc.getOperation());
		assertEquals("2.0", calc.getResult());
	}

	/**
	 * Tests for backspace button being pressed in different scenarios.
	 */
	@Test
	public void testBackspaceBeingPressed() {
		CalculatorMemory calc = new CalculatorMemory();
		calc.pressed("1");
		calc.pressed("0");
		assertEquals("10", calc.getFirstNumber());
		calc.backspace();
		assertEquals("1", calc.getFirstNumber());
		calc.performClean();

		calc.pressed("1");
		calc.pressed("0");
		calc.pressed("+");
		assertEquals("10", calc.getFirstNumber());
		assertEquals("+", calc.getOperation());
		calc.backspace();
		assertEquals("", calc.getOperation());
		calc.performClean();

		calc.pressed("1");
		calc.pressed("0");
		calc.pressed("+");
		calc.pressed("2");
		calc.pressed("5");
		assertEquals("25", calc.getSecondNumber());

		calc.backspace();
		assertEquals("2", calc.getSecondNumber());
		calc.performClean();

		calc.backspace();
	}
}
