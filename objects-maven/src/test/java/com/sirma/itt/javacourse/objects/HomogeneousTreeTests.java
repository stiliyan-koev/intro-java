package com.sirma.itt.javacourse.objects;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.sirma.itt.javacourse.objects.trees.homogeneous.HomogeneousTree;
import com.sirma.itt.javacourse.objects.trees.node.TreeNode;

/**
 * Tests for {@link HomogeneousTree}.
 * 
 * @author Stiliyan Koev
 */
public class HomogeneousTreeTests {
	/**
	 * Tests for {@link HomogeneousTree}.
	 * 
	 * @author Stiliyan Koev
	 */
	@Test
	public void test() {
		HomogeneousTree<Integer> intTree = new HomogeneousTree<Integer>(5, new HomogeneousTree<Integer>(1,
				new HomogeneousTree<Integer>(10), new HomogeneousTree<Integer>(22), new HomogeneousTree<Integer>(11)));

		int root = intTree.getRoot().getValue();
		assertEquals(root, 5);

		List<TreeNode<Integer>> childNodes = intTree.getChildNodes();
		int firstChild = childNodes.get(0).getValue();
		int secondChild = childNodes.get(0).getChild(0).getValue();
		int thirdChild = childNodes.get(0).getChild(1).getValue();
		int fourthChild = childNodes.get(0).getChild(2).getValue();
		assertEquals(firstChild, 1);
		assertEquals(secondChild, 10);
		assertEquals(thirdChild, 22);
		assertEquals(fourthChild, 11);

		intTree.print();
	}
}
