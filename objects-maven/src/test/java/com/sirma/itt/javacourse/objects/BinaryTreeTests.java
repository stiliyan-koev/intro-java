package com.sirma.itt.javacourse.objects;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.sirma.itt.javacourse.objects.trees.binary.BinaryTree;

public class BinaryTreeTests {
	/**
	 * Tests for binary tree from type Integer.
	 */
	@Test
	public void integerBinaryTreeTests() {
		BinaryTree<Integer> intTree = new BinaryTree<Integer>();
		intTree.setRoot(5);
		intTree.addNewNumber(intTree.getRoot(), 1);
		intTree.addNewNumber(intTree.getRoot(), 10);

		int actual = intTree.getRoot().getLeftValue();
		Assert.assertEquals(actual, 1);

		actual = intTree.getRoot().getValue();
		assertEquals(actual, 5);

		actual = intTree.getRoot().getRightValue();
		assertEquals(actual, 10);
	}

	/**
	 * Tests for binary tree from type of Integer with negative numbers.
	 */
	@Test
	public void integerNegativeBinaryTreeTests() {
		BinaryTree<Integer> intTree = new BinaryTree<Integer>();
		intTree.setRoot(-5);
		intTree.addNewNumber(intTree.getRoot(), -1);
		intTree.addNewNumber(intTree.getRoot(), -10);

		int actual = intTree.getRoot().getValue();
		assertEquals(actual, -5);

		actual = intTree.getRoot().getLeftValue();
		Assert.assertEquals(actual, -10);

		actual = intTree.getRoot().getRightValue();
		assertEquals(actual, -1);
	}

	/**
	 * Tests for binary tree from type of Float.
	 */
	@Test
	public void floatBinaryTreeTests() {
		BinaryTree<Float> floatTree = new BinaryTree<Float>();
		floatTree.setRoot(5.5f);
		floatTree.addNewNumber(floatTree.getRoot(), 1.5f);
		floatTree.addNewNumber(floatTree.getRoot(), 10.5f);

		float actual = floatTree.getRoot().getValue();

		Assert.assertEquals(actual, 5.5f, 0.1f);

		actual = floatTree.getRoot().getLeftValue();
		Assert.assertEquals(actual, 1.5f, 0.1f);

		actual = floatTree.getRoot().getRightValue();
		Assert.assertEquals(actual, 10.5f, 0.1f);
	}

	/**
	 * Tests for binary tree from type of Float with negative numbers.
	 */// @Test
	public void floatNegativeBinaryTreeTests() {
		BinaryTree<Float> floatTree = new BinaryTree<Float>();
		floatTree.setRoot(-5.5f);
		floatTree.addNewNumber(floatTree.getRoot(), -1.5f);
		floatTree.addNewNumber(floatTree.getRoot(), -10.5f);
		float actual = floatTree.getRoot().getValue();
		Assert.assertEquals(actual, -5.5f, 0.1f);
		actual = floatTree.getRoot().getLeftValue();
		Assert.assertEquals(actual, -10.5f, 0.1f);
		actual = floatTree.getRoot().getRightValue();
		Assert.assertEquals(actual, -1.5f, 0.1f);
	}

}
