package com.sirma.itt.javacourse.objects.trees.heterogeneous;

import com.sirma.itt.javacourse.objects.trees.node.TreeNode;

/**
 * Run class for {@link HeterogeneousTree}.
 * 
 * @author Stiliyan Koev.
 */
public class HeterogeneousTreeRunClass {
	/**
	 * Private constructor
	 */
	private HeterogeneousTreeRunClass() {

	}

	/**
	 * Main entry class.
	 * 
	 * @param args
	 *            - String arguments.
	 */
	public static void main(String[] args) {

		char charValue = 59;
		String stringValue = "string value";
		Integer intValue = 10;
		Double doubleValue = 7.5;

		HeterogeneousTree<Object> heteroTree = new HeterogeneousTree<Object>(7);
		TreeNode<Object> stringNode = new TreeNode<Object>(stringValue);
		TreeNode<Object> doubleNode = new TreeNode<Object>(doubleValue);
		TreeNode<Object> charNode = new TreeNode<Object>(charValue);
		TreeNode<Object> intNode = new TreeNode<Object>(intValue);
		heteroTree.getRoot().addChild(stringNode);
		heteroTree.getRoot().addChild(doubleNode);
		heteroTree.getRoot().addChild(intNode);
		heteroTree.getRoot().addChild(charNode);
		heteroTree.print();
	}

}
