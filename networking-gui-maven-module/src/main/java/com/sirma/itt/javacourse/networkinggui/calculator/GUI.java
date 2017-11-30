package com.sirma.itt.javacourse.networkinggui.calculator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * GUI of calculator.
 * 
 * @author Stiliyan Koev
 */
public class GUI extends JFrame {
	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	private JTextField answerField;
	private JButton one, two, three, four, five, six, seven, eigth, nine, zero, div, multi, plus, minus, equals,
			backspace, c, dot;

	CalculatorMemory calcMem = new CalculatorMemory();
	private JPanel panel;

	/**
	 * Constructor.
	 */
	public GUI() {
		super("Calculator");
		panel = new JPanel();
		answerField = new JTextField(null, 20);
		JButton[] buttonsArray = { one = new JButton("1"), two = new JButton("2"), three = new JButton("3"),
				four = new JButton("4"), five = new JButton("5"), six = new JButton("6"), seven = new JButton("7"),
				eigth = new JButton("8"), nine = new JButton("9"), plus = new JButton("+"), zero = new JButton("0"),
				multi = new JButton("*"), minus = new JButton("-"), equals = new JButton("="), div = new JButton("/"),
				backspace = new JButton("<-"), dot = new JButton("."), c = new JButton("C") };
		panel.setBackground(Color.CYAN);
		panel.add(answerField);
		addAllButtons(buttonsArray);
		this.setContentPane(panel);

	}

	/**
	 * Adding all of the buttons to the GUI.
	 * 
	 * @param arrayWithButtons
	 *            - array with all buttons.
	 */
	public void addAllButtons(JButton[] arrayWithButtons) {
		for (int i = 0; i < arrayWithButtons.length; i++) {

			Dimension dim = new Dimension(70, 50);
			arrayWithButtons[i].setFont(new Font("Arial", Font.PLAIN, 40));
			arrayWithButtons[i].setPreferredSize(dim);
			arrayWithButtons[i].addActionListener(new Action());
			panel.add(arrayWithButtons[i]);
		}
	}

	/**
	 * Action class implementing ActionListener.
	 * 
	 * @author Stiliyan Koev.
	 */
	public class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton clicked = (JButton) e.getSource();
			if (clicked == equals) {
				answerField.setText(calcMem.getResult());
			} else {
				if (clicked == zero) {
					calcMem.pressed("0");
				} else if (clicked == one) {
					calcMem.pressed("1");
				} else if (clicked == two) {
					calcMem.pressed("2");
				} else if (clicked == three) {
					calcMem.pressed("3");
				} else if (clicked == four) {
					calcMem.pressed("4");
				} else if (clicked == five) {
					calcMem.pressed("5");
				} else if (clicked == six) {
					calcMem.pressed("6");
				} else if (clicked == seven) {
					calcMem.pressed("7");
				} else if (clicked == eigth) {
					calcMem.pressed("8");
				} else if (clicked == nine) {
					calcMem.pressed("9");
				} else if (clicked == plus) {
					calcMem.pressed("+");
				} else if (clicked == minus) {
					calcMem.pressed("-");
				} else if (clicked == multi) {
					calcMem.pressed("*");
				} else if (clicked == div) {
					calcMem.pressed("/");
				} else if (clicked == equals) {
					calcMem.pressed("=");
				} else if (clicked == backspace) {
					calcMem.backspace();
				} else if (clicked == c) {
					calcMem.pressed("c");
				} else if (clicked == dot) {
					calcMem.addDigitToNumber(".");
				}
				answerField.setText(calcMem.getFirstNumber() + calcMem.getOperation() + calcMem.getSecondNumber());
			}
		}
	}
}
