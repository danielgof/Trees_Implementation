

import java.util.ArrayList;
import java.util.List;

public class Node {
	private String title;
	private List<Node> children;
	
	public Node(String t) {
		this.title = t;
		this.children = new ArrayList<Node>();
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public List<Node> getChildren() {
		return this.children;
	}
}
