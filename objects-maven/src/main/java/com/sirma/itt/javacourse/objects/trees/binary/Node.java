package com.sirma.itt.javacourse.objects.trees.binary;

/**
 * Public class of Node. Node has its value and its Left child and Right child. Each of the childs has Value in their
 * construction.
 * 
 * @author Stiliyan Koev
 * @param <T>
 *            - value of the node.
 */
public class Node<T> {
	private Node<T> left;

	private Node<T> right;

	private T value;

	/**
	 * constructor for Node.
	 * 
	 * @param value
	 *            - the number given by user.
	 */
	public Node(T value) {
		this.value = value;
	}

	/**
	 * Getting the left node with its Nodes.
	 * 
	 * @return - Left node as node.
	 */
	public Node<T> getLeftNode() {
		return left;
	}

	/**
	 * Setter for left Node.
	 * 
	 * @param left
	 *            - left Node.
	 */
	public void setLeft(Node<T> left) {
		this.left = left;
	}

	/**
	 * Getting the right node with its Nodes.
	 * 
	 * @return - Right node as node.
	 */
	public Node<T> getRightNode() {
		return right;
	}

	/**
	 * Setter for right Node.
	 * 
	 * @param right
	 */
	public void setRight(Node<T> right) {
		this.right = right;
	}

	/**
	 * Getting value of the current Node.
	 * 
	 * @return - the value of Node.
	 */
	public T getValue() {
		return value;
	}

	/**
	 * Setter for value of Node.
	 * 
	 * @param value
	 *            - number given by user.
	 */
	public void setValue(T value) {
		this.value = value;
	}

	/**
	 * Getting the value of Left Node. If there is still no Left Node it returns NULL.
	 * 
	 * @return - number of NULL.
	 */
	public T getLeftValue() {
		if (left != null) {
			return left.value;
		} else {
			return null;
		}
	}

	/**
	 * Getting the value of Right Node. If there is still no Right Node it returns NULL.
	 * 
	 * @return - number of NULL.
	 */
	public T getRightValue() {
		if (right != null) {
			return right.value;
		} else {
			return null;
		}
	}

}
