package com.sirma.itt.javacourse.objects.trees.node;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a tree node.
 * 
 * @author Stiliyan Koev
 * @param <T>
 *            - Type values in the tree.
 */
public final class TreeNode<T> {
	private T value;
	private boolean hasParent;
	private List<TreeNode<T>> children;

	/**
	 * Getter for Children Nodes.
	 * 
	 * @return - return the Node which is Children of its Parent.
	 */
	public List<TreeNode<T>> getChildren() {
		return children;
	}

	/**
	 * Setter for Children Nodes.
	 * 
	 * @param children
	 *            - the children node that has to be attached to its Parent.
	 */
	public void setChildren(List<TreeNode<T>> children) {
		this.children = children;
	}

	/**
	 * Constructs a tree node.
	 * 
	 * @param value
	 *            - the value of the node.
	 */
	public TreeNode(T value) {
		if (value == null) {
			throw new IllegalArgumentException("Cannot insert null value!");
		}
		this.value = value;
		this.children = new ArrayList<TreeNode<T>>();
	}

	/**
	 * @return the value of the node.
	 */
	public T getValue() {
		return this.value;
	}

	/**
	 * Set the value of the node.
	 * 
	 * @param value
	 *            - the given value.
	 */
	public void setValue(T value) {
		this.value = value;
	}

	/**
	 * Add child to the node.
	 * 
	 * @param child
	 *            - the child to be added.
	 */
	public void addChild(TreeNode<T> child) {
		if (child == null) {
			throw new IllegalArgumentException("Cannot insert null value!");
		}
		child.setHasParent(true);
		this.children.add(child);
	}

	/**
	 * Gets the child of the node at given index.
	 * 
	 * @param index
	 *            - the index of the child.
	 * @return the child on the given position.
	 */
	public TreeNode<T> getChild(int index) {
		return this.children.get(index);
	}

	/**
	 * @return the value of node's children.
	 */
	public int getChildrenCount() {
		return this.children.size();
	}

	/**
	 * Checking does the Node has parent.
	 * 
	 * @return true or false.
	 */
	public boolean getParent() {
		return hasParent;
	}

	/**
	 * Setter for hasParent.
	 * 
	 * @param hasParent
	 *            - showing us does the node belongs to any Parent.
	 */
	public void setHasParent(boolean hasParent) {
		this.hasParent = hasParent;
	}
}
