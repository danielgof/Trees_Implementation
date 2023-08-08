package tree;

import java.io.File;

/*
 * Tree class implementation using generic data types
 */
public class Tree {
	private Node root;
	
	public Tree() {
		this.root = new Node("./");
		this.root.setDirs();
		this.root.setFiles();
	}

	/*
	 * Returns the root {@code} Node
	*/
	public Node getRoot() {
		return this.root;
	}

	/*
	 * Search for existence of {@code} String title in a tree
	*/
	public boolean searchNode(String nodeTitle) {
		return searchNodeHelper(this.root, nodeTitle);
	}

	/*
	 * Server as helper method to {@code} search method
	 * 
	 * @param root {@code} Node
	 * 				root Node of a tree
	 * 
	 * @param nodeTitle {@code} String  
	 * 				to represent title of Node that is searched
	*/
	private boolean searchNodeHelper(Node root, String nodeTitle) {
		boolean result = false;
		if (root != null) {
//			Go through all children
			if (root.getTitle().equals(nodeTitle)) {
				result = true;
			} else if (root.getDirs().size() > 0) {
//		    Calculate number of entities in a node
				int dirsLen = root.getDirs().size();
				int i = 0;
				while (i < dirsLen && result != true) {
					result = searchNodeHelper(root.getDirs().get(i), nodeTitle);
					i++;
				}				
			}
		} 
		return result;
	}

	/*
	 * Method to search for file in all directories
	*/
	public boolean searchFile(String fileName) {
		return searchFileHelper(this.root, fileName);
	}

	/*
	 * Serves as a helper method to {@code} searchFile 
	*/
	private boolean searchFileHelper(Node root, String fileTitle) {
		boolean result = false;
		if (root != null) {
//			Go through all children
			if (root.getFiles() != null && root.getFiles().contains(new File(fileTitle))) {
				result = true;
			} else if (root.getDirs() != null) {
//		    Calculate number of entities in a node
				int dirsLen = root.getDirs().size();
				int i = 0;
				while(result != true && i < dirsLen) {
					result = searchFileHelper(root.getDirs().get(i), fileTitle);
					i++;
				}				
			}
		}
		return result;
	}
	
	/*
	 * Adds a new {@code} Node to a {@code} Node with the provided title
	 * 
	 * @param {@code} String
	 * 			title of a {@code} Node to add a new {@code} Node 
	*/
	public void addNode(String titleSearch, String nodeTitle) {
		addNodeHelper(this.root, titleSearch, nodeTitle);
	}
	private void addNodeHelper(Node root, String titleSearch, String nodeTitle) {
		if (searchNode(titleSearch)) {
			if (root.getTitle().equals(titleSearch)) {
				Node tmp = new Node(nodeTitle);
				tmp.setDirs();
				tmp.setFiles();
				root.getDirs().add(tmp);
			} else if (root.getDirs() != null) {
				int len = root.getDirs().size();
				for (int i = 0; i < len; i++) {
					addNodeHelper(root.getDirs().get(i), titleSearch, nodeTitle);
				}
			}
		}
	}

	/* 
	 * Adds a new {@code} File to 
	 * 			the {@code} List of {@code} Nodes
	*/
	public void addFile(String rootSearch, String fileName) {
		addFileHelper(this.root, rootSearch, fileName);
	}
	private void addFileHelper(Node root, String rootSearch, String fileName) {
		if (root.getTitle().equals(rootSearch)) {
			root.getFiles().add(new File(fileName));
		} else if (root.getDirs() != null) {
			int len = root.getDirs().size();
			for (int i = 0; i < len; i++) {
				addFileHelper(root.getDirs().get(i), rootSearch, fileName);
			}
		}
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
			} else if (root.getDirs().size() > 0) {
//		    Calculate number of entities in a node
				int dirsLen = root.getDirs().size();
				int i = 0;
				while (i < dirsLen && result != true) {
					result = searchNodeHelper(root.getDirs().get(i), nodeTitle);
					if (result == true) {
						root.getDirs().remove(i);
					}
					i++;
				}				
			}
		} 
		return result;
	}
	
	/*
	 * Deletes {@code} File by provided title
	 * 
	 * @param fileTitle
	 * 			{@code} String title of a {@code} File to delete 
	*/
	public void deleteFile(String fileTitle) {
		deleteFileHelper(this.root, fileTitle);
	}
	private void deleteFileHelper(Node root, String fileTitle) {
		if(searchFile(fileTitle)) {
			if (root.getFiles() != null) {
				if (root.getFiles().contains(new File(fileTitle))) {
					root.getFiles().remove(new File(fileTitle));
				} else {
					int len = root.getDirs().size();
					for (int i = 0; i < len; i++) {
						deleteFileHelper(root.getDirs().get(i), fileTitle);
					}
				}
			}
		}
	}

	/*
	 * Prints all {@code} Nodes in a particular Node
	*/
	public void printNodes(String nodeTitle) {
		printNodesHelper(this.root, nodeTitle);
	}
	private void printNodesHelper(Node root, String nodeTitle) {
		if (searchNode(nodeTitle)) {
			if (root.getTitle().equals(nodeTitle)) {
				int len = root.getDirs().size();
				for (int i = 0; i < len; i++) {
					System.out.println("directory: " + root.getDirs().get(i).getTitle() + " " );											
				}
			} else {
				int len = root.getDirs().size();
				for (int i = 0; i < len; i++) {
					printNodesHelper(root.getDirs().get(i), nodeTitle);
				}
			}
		}
	}
	
	public void printFiles(String nodeTitle) {
		printFilesHelper(this.root, nodeTitle);
	}
	
	private void printFilesHelper(Node root, String nodeTitle) {
		if (searchNode(nodeTitle)) {
			if (root.getTitle().equals(nodeTitle)) {
				if (root.getFiles() != null) {
					int len = root.getFiles().size();
					for (int i = 0; i < len; i++) {
						System.out.println("file: " + root.getFiles().get(i).getName() 
								+ " size: " + root.getFiles().get(i).length() + " bytes");											
					}
				}
			} else if (root.getDirs() != null) {
				int len = root.getDirs().size();
				for (int i = 0; i < len; i++) {
					printFilesHelper(root.getDirs().get(i), nodeTitle);
				}
			}
		}
	}
}

