package tree;

/*
 * 
 * Author Daniil Gofman
 */
public class Main {

	public static void main(String[] args) {
		Tree<String> tree = new Tree<>("LA");
		tree.addNode("Brooklin");
		tree.addNode("Amsterdam");
		tree.addNode("New York");
		tree.addNode("Columbus");
		tree.addNode("Los Angeles");
		System.out.println("Tree size: " + tree.size());
		System.out.println("Tree height: " + tree.height());
		System.out.println("Columbus is in the tree: " + tree.search("Columbus"));
		System.out.println("Depth to Columbus: " + tree.depth("Columbus"));
	}
}

