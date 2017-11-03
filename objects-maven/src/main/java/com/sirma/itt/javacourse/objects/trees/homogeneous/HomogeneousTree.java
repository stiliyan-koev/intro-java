package com.sirma.itt.javacourse.objects.trees.homogeneous;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.itt.javacourse.objects.trees.node.TreeNode;

/**
 * Represents a tree data structure. Homogeneous Tree has its root of type
 * TreeNode<T>.
 * 
 * @author Stiliyan Koev.
 * @param <T>
 *            - Type values in the tree.
 */
public class HomogeneousTree<T> {
	private TreeNode<T> root;
	private static final Logger LOGGER = LoggerFactory.getLogger(HomogeneousTree.class);

	/**
	 * Constructs the tree.
	 * 
	 * @param value
	 *            - the value of the node(root).
	 */
	public HomogeneousTree(T value) {
		if (value == null) {
			throw new IllegalArgumentException("Cannot insert null value!");
		}
		this.root = new TreeNode<T>(value);
	}

	/**
	 * Constructs the tree.
	 * 
	 * @param value
	 *            - the value of the root node.
	 * @param children
	 *            - the children of the root node.
	 */
	public HomogeneousTree(T value, HomogeneousTree<T>... children) {
		this(value);
		for (HomogeneousTree<T> child : children) {
			this.root.addChild(child.root);
		}
	}

	/**
	 * @return the root node or null if the tree is empty.
	 */
	public TreeNode<T> getRoot() {
		return this.root;
	}

	/**
	 * @return the child nodes of the tree.
	 */
	public List<TreeNode<T>> getChildNodes() {
		if (this.root != null) {
			return this.root.getChildren();
		}
		return new ArrayList<TreeNode<T>>();
	}

	/**
	 * Prints the tree.
	 * 
	 * @param root
	 *            - the root of the tree.
	 * @param spaces
	 *            - the spaces used for printing of the parent-child.
	 */
	private void print(TreeNode<T> root, String spaces) {

		if (this.root == null) {
			return;
		}

		LOGGER.info(spaces + root.getValue());

		TreeNode<T> child = null;
		for (int i = 0; i < root.getChildrenCount(); i++) {
			child = root.getChild(i);
			print(child, spaces + " ");
		}
	}

	/**
	 * Prints the tree.
	 */
	public void print() {
		this.print(this.root, "");
	}
}
