import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import tree.Tree;


/**
 * @author Daniil Gofman
 *
 */
class TreeTest {
	/*
	 * Testing {@link Tree.size()} method
	*/
	@Test
	void sizeTest1() {
		Tree<String> tree = new Tree<>("LA");
		tree.addNode("Brooklin");
		tree.addNode("New York");
		tree.addNode("Columbus");
		tree.addNode("Los Angeles");
		assertEquals(tree.size(), 5);
	}
	
	@Test
	void sizeTest2() {
		Tree<Integer> tree = new Tree<>(2);
		tree.addNode(9);
		tree.addNode(23);
		tree.addNode(1);
		tree.addNode(42);
		assertEquals(tree.size(), 5);
	}
	
	@Test
	void sizeTest3() {
		Tree<Integer> tree = new Tree<>(2);
		assertEquals(tree.size(), 1);
	}

	/*
	 * Testing {@link Tree.code()} method
	*/
	@Test
	void deleleteTest1() {
		Tree<Integer> tree = new Tree<>(2);
		tree.addNode(9);
		tree.addNode(23);
		tree.addNode(1);
		tree.addNode(42);
		assertEquals(tree.deleteNode(1), 1);
	}
	
	@Test
	void deleleteTest2() {
		Tree<String> tree = new Tree<>("LA");
		tree.addNode("Brooklin");
		tree.addNode("New York");
		tree.addNode("Columbus");
		tree.addNode("Los Angeles");
		assertEquals(tree.deleteNode("Columbus"), "Columbus");
	}
	
	@Test
	void deleleteTest3() {
		Tree<String> tree = new Tree<>("LA");
		assertEquals(tree.deleteNode("LA"), "LA");
	}
}
