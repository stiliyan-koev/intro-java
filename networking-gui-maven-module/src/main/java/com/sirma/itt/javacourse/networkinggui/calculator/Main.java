package com.sirma.itt.javacourse.networkinggui.calculator;

import javax.swing.JFrame;

/**
 * RunClass for Calculator task.
 * 
 * @author Stiliyan Koev.
 */
public class Main {
	/**
	 * Entry class.
	 * 
	 * @param args
	 *            - String arguments
	 */
	public static void main(String[] args) {
		GUI gui = new GUI();
		gui.setSize(250, 400);
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		gui.setResizable(false);
	}
}