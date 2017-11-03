package com.sirma.itt.javacourse.objects;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.sirma.itt.javacourse.objects.trees.heterogeneous.HeterogeneousTree;
import com.sirma.itt.javacourse.objects.trees.node.TreeNode;

/**
 * JUnit tests for {@link HeterogeneousTree}.
 * 
 * @author Stiliyan Koev.
 */
public class HeterogeneousTreeTests {
	/**
	 * Tests for {@link HeterogeneousTree}.
	 */
	@Test
	public void testHeteroTree() {
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

		List<TreeNode<Object>> children = heteroTree.getChildNodes();

		assertEquals(heteroTree.getRoot().getValue(), 7);
		assertEquals(heteroTree.getRoot().getChild(0).getValue(), "string value");
		assertEquals(heteroTree.getRoot().getChild(1).getValue(), 7.5);
		assertEquals(heteroTree.getRoot().getChild(2).getValue(), 10);
		assertEquals(stringNode.getParent(), true);
		assertEquals(stringNode.getChildrenCount(), 0);
		assertEquals(children.get(0).getValue(), "string value");
		assertEquals(children.get(1).getValue(), 7.5);
		assertEquals(children.get(2).getValue(), 10);
		assertEquals(children.get(3).getValue(), ';');
		heteroTree.print();
	}
}
