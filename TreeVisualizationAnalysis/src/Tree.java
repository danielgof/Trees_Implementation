
/*
 * Class to represent {@code Tree} data structure.
*/
public class Tree {

	private Node root;

	/*
	 * No argument constructor. Set root Node to null. 
	*/
	public Tree() {
		this.root = null;
	}

	/*
	 * Parameterized constructor. Set root a new node with a given title.
	 * @param title
	 * 			title of a root Node to insert. 
	*/
	public Tree(String title) {
		this.root = new Node(title);
	}

	/*
	 * Get for root {@code Node}.
	*/
	public Node getRoot() {
		return this.root;
	}

	/*
	 * Insert new Node into the tree to give root Node
	 * @param titleSearch
	 * 			title of a root Node to search.
	 * @param title
	 * 			title of a new Node.
	*/
	public void addNode(String titleSearch, String title) {
		addNodeHelper(this.root, titleSearch, title);
	}
	
	private void addNodeHelper(Node root, String titleSearch, String title) {
		if (root.getTitle().equals(titleSearch)) {
			root.getChildren().add(new Node(title));
		} else {
			int len = root.getChildren().size();
			for (int i = 0; i < len; i++) {
				addNodeHelper(root.getChildren().get(i), titleSearch, title);
			}
		}
	}

	/*
	 * Prints a tree to the console
	*/
	public void print() {
		printHelper(this.root, "", "|---");
	}
	
	private void printHelper(Node root, String parentPrefix, String prefix) {
		String childPrefix = "\t";
		int len = root.getChildren().size();
		System.out.println(String.format("%s%s%s", parentPrefix, prefix, root.getTitle()));
		prefix = "|---"; 
		for (int i = 0; i < len; i++) {
			if (i == len - 1) {
				prefix = "---";
			}
			printHelper(root.getChildren().get(i), parentPrefix+childPrefix, prefix);
		}
	}

	/*
	 * Method to search a node in a tree by given {@code String title}
	 * @param {@code String title}
	 * 				title of the node to search in a tree.
	 * @return {@code boolean}
	 * 				the result of existence of a {@code String title} in a tree.
	*/
	public boolean search(String title) {
		return searchHelper(this.root, title);
	}
	
	private boolean searchHelper(Node root, String title) {
		boolean result = false;
		if (root.getTitle().equals(title)) {
			result = true;
		} else {
			int len = root.getChildren().size();
			int i = 0;
			while (!result && i < len) {
				result = searchHelper(root.getChildren().get(i), title);
				i++;
			}
		}
		return result;
	}
	/*
	 * Deletes {@code} Node by provided title
	 * 
	 * @param nodeTitle
	 * 			{@code} String title of a {@code} Node to delete 
	*/
	public boolean deleteNode(String nodeTitle) {
		return deleteNodeHelper(this.root, nodeTitle);
	}
	private boolean deleteNodeHelper(Node root, String nodeTitle) {
		boolean result = false;
		if (root != null) {
//			Go through all children
			if (root.getTitle().equals(nodeTitle)) {
				result = true;
			} else {
//		    Calculate number of entities in a node
				int dirsLen = root.getChildren().size();
				int i = 0;
				while (i < dirsLen && result != true) {
					result = deleteNodeHelper(root.getChildren().get(i), nodeTitle);
					if (result == true) {
						root.getChildren().remove(i);
					}
					i++;
				}				
			}
		} 
		return result;
	}

}
