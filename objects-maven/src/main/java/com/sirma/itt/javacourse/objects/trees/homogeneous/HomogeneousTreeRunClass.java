package com.sirma.itt.javacourse.objects.trees.homogeneous;

/**
 * Run class for {@link HomogeneousTree}.
 * 
 * @author Stiliyan Koev.
 */
public class HomogeneousTreeRunClass {
	/**
	 * Private constructor
	 */
	private HomogeneousTreeRunClass() {

	}

	/**
	 * Main entry class.
	 * 
	 * @param args
	 *            - String arguments.
	 */
	public static void main(String[] args) {

		HomogeneousTree<Integer> intTree = new HomogeneousTree<Integer>(5, new HomogeneousTree<Integer>(1,
				new HomogeneousTree<Integer>(10), new HomogeneousTree<Integer>(22), new HomogeneousTree<Integer>(11)),

				new HomogeneousTree<Integer>(151),
				new HomogeneousTree<Integer>(124, new HomogeneousTree<Integer>(23), new HomogeneousTree<Integer>(136)));

		HomogeneousTree<Double> doubleTree = new HomogeneousTree<Double>(7.5, new HomogeneousTree<Double>(2.5));

		HomogeneousTree<String> stringTree = new HomogeneousTree<String>("A", new HomogeneousTree<String>("B"),
				new HomogeneousTree<String>("C"));

		intTree.print();
		doubleTree.print();
		stringTree.print();

	}
}
