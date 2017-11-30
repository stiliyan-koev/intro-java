
package com.sirma.itt.javacourse.networkinggui.calculator;

import com.sirma.itt.javacourse.patterns.calculator.Calculator;
import com.sirma.itt.javacourse.utilities.ConsoleWriter;

/**
 * First task of networking and gui.
 * 
 * @author Stiliyan Koev.
 */
public class CalculatorMemory {
	private Calculator calculator = new Calculator();
	private String firstNumber = "";
	private String secondNumber = "";
	private String operation = "";
	boolean isOperationBeingPressed = false;

	/**
	 * Constructor.
	 */
	public CalculatorMemory() {

	}

	/**
	 * Adding a digit to the number.
	 * 
	 * @param digit
	 *            - the next digit
	 */
	public void addDigitToNumber(String digit) {
		if (!isOperationBeingPressed) {
			firstNumber += digit;
		} else {
			secondNumber += digit;
		}
	}

	/**
	 * Determine which button has been pressed.
	 * 
	 * @param symbol
	 *            - Symbol pressed.
	 */
	public void pressed(String symbol) {
		char charSymbol = symbol.charAt(0);
		if (charSymbol > 47 && charSymbol < 58) {
			addDigitToNumber(symbol.toString());
		} else if ((charSymbol > 41 && charSymbol < 46 || charSymbol == 47) && !isOperationBeingPressed) {
			operation = symbol.toString();
			isOperationBeingPressed = true;
		} else if ("c".equals(symbol)) {
			performClean();
		} else {
			ConsoleWriter.write("Error !");
		}
	}

	/**
	 * Getting the result of different calculation, such as plus, minus and etc.
	 * 
	 * @return - The result of calculation.
	 */
	public String getResult() {
		double firstDouble = Double.parseDouble(firstNumber);
		double secondDouble = Double.parseDouble(secondNumber);
		switch (operation) {
		case "+":
			return Double.toString(calculator.plus(firstDouble, secondDouble));
		case "-":

			return Double.toString(calculator.minus(firstDouble, secondDouble));
		case "*":

			return Double.toString(calculator.multiply(firstDouble, secondDouble));
		case "/":

			return Double.toString(calculator.devide(firstDouble, secondDouble));

		default:
			return "BEEP";
		}

	}

	/**
	 * Zeroes all the memory.
	 */
	public void performClean() {
		calculator = new Calculator();
		firstNumber = "";
		secondNumber = "";
		operation = "";
		isOperationBeingPressed = false;
	}

	/**
	 * Deleting the last digit (or symbol if it is operand).
	 */
	public void backspace() {
		if (secondNumber.length() > 0) {
			secondNumber = secondNumber.substring(0, secondNumber.length() - 1);
		} else if (operation.length() > 0) {
			operation = "";
			isOperationBeingPressed = false;
		} else if (firstNumber.length() > 0) {
			firstNumber = firstNumber.substring(0, firstNumber.length() - 1);
		}
	}

	/**
	 * Getter for firstNumber.
	 * 
	 * @return - the first number.
	 */
	public String getFirstNumber() {
		return this.firstNumber;
	}

	/**
	 * Getter for secondNumber.
	 * 
	 * @return - the first number.
	 */
	public String getSecondNumber() {
		return this.secondNumber;
	}

	/**
	 * Getter for getOperation
	 * 
	 * @return - the operation.
	 */
	public String getOperation() {
		return this.operation;
	}
}
