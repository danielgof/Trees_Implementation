
public class BinarySearchTree {
	
	Node root;
	
	public void insert(Node node) {
		root = insertHelper(root, node);
	}
	private Node insertHelper(Node root, Node node) {
		
		int data = node.data;
		if (root == null) {
			root = node;
			return root;
		}  else if (data < root.data) {
			root.left = insertHelper(root.left, node);
		} else {
			root.right = insertHelper(root.right, node);
		}
		return root;
	}
	public boolean search(int data) {
		return searchHelper(root, data);
	}
	private boolean searchHelper(Node root, int data) {
		if (root == null) {
			return false;
		} else if (root.data == data) {
			return true;
		} else if (root.data > data) {
			return searchHelper(root.left, data);
		} else {
			return searchHelper(root.right, data);
		}
	}
	public void display() {
		displayHelper(root);
	}
	private void displayHelper(Node root) {
		if (root != null) {
			displayHelper(root.left);
			System.out.println(root.data);
			displayHelper(root.right);
		}
	}
	public void delete(int data) {
		if (search(data)) {
			root = deleteHelper(root, data);
		} else {
			System.out.println(data + " could not be found");
		}
	}
	private Node deleteHelper(Node root, int data) {
		
		if (root == null) {
			return root;
		} else if (root.data < data) {
			root.left = deleteHelper(root.left, data);
		} else if (root.data > data) {
			root.right = deleteHelper(root.right, data);
		} else {
			if (root.left == null && root.right == null) {
				root = null;
			} else if (root.right != null) {
				root.data = successor(root);
				root.right = deleteHelper(root.right, root.data);
			} else {
				root.data = predecessor(root);
				root.left = deleteHelper(root.left, root.data);
			}
		}
		return null;
	}
	private int successor(Node root) {
		
		root = root.right;
		while(root.left != null) {
			root = root.left;
		}
		return root.data;
	}
	private int predecessor(Node root) {
		root = root.left;
		while(root.right != null) {
			root = root.right;
		}
		return root.data;
	}
} 
