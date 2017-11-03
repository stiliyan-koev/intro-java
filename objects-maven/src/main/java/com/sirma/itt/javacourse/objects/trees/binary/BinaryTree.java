package com.sirma.itt.javacourse.objects.trees.binary;

import com.sirma.itt.javacourse.objects.trees.binary.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of Binary Tree data structure.
 * 
 * @author Stiliyan Koev.
 * @param <T>
 */
public class BinaryTree<T extends Comparable<? super T>> {
	private static final Logger LOGGER = LoggerFactory.getLogger(BinaryTree.class);
	private Node<T> root;

	/**
	 * Getter for root - the first Node in the binary tree.
	 * 
	 * @return
	 */
	public Node<T> getRoot() {
		return root;
	}

	/**
	 * * Setting the root from a user. This is the first node (the beginning) of our tree.
	 */
	public void setRoot(T i) {
		this.root = new Node<T>(i);
	}

	/**
	 * Adding a new number. This function is choosing where the new number(node/leaf) should be - on parent's left or on
	 * parent's right.
	 * 
	 * @param node
	 *            - The new node (number) that will be added.
	 * @param num
	 *            - value of the node (the number given by user).
	 * @return - return if the number is already in the tree or not.
	 */

	public Boolean addNewNumber(Node<T> node, T num) {
		if (!doesItContains(node, num)) {
			if (num.compareTo(node.getValue()) < 0) {
				if (node.getLeftValue() != null) {
					addNewNumber(node.getLeftNode(), num);
				} else {
					LOGGER.info("{} to left of {}", num, node.getValue());
					node.setLeft(new Node<T>(num));
				}
			} else if (num.compareTo(node.getValue()) > 0) {
				if (node.getRightValue() != null) {
					addNewNumber(node.getRightNode(), num);
				} else {
					LOGGER.info("{} to right of {} ", num, node.getValue());
					node.setRight(new Node<T>(num));
				}
			}
		} else {
			LOGGER.info("The entered number {} is already in the tree and can not be inserted.", num);
			return true;
		}
		return false;
	}

	/**
	 * Printing sorted the Binary Tree. From the least to the biggest number.
	 * 
	 * @param node
	 *            - The whole Binary Tree.
	 */
	public void printSorted(Node<T> node) {
		if (node != null) {
			printSorted(node.getLeftNode());
			LOGGER.info("Value: {}", node.getValue());
			printSorted(node.getRightNode());
		}
	}

	/**
	 * Checks if the given by user number is already in the tree.
	 * 
	 * @param node
	 *            - The whole Binary Tree.
	 * @param value
	 *            - value that has to be checked.
	 * @return - returns boolean Yes or No.
	 */
	public boolean doesItContains(Node<T> node, T value) {
		boolean contains = false;
		if (node != null) {
			doesItContains(node.getLeftNode(), value);
			if (value.equals(node.getValue())) {
				contains = true;
			}
		}
		return contains;
	}
}
