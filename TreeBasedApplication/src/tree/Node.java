package tree;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Node {
	private String title;
	private List<File> files;
	private List<Node> dirs;

	/*
	 * Constructor for the class
	*/
	public Node(String dir) {
		this.title = dir;
		this.files = null;
		this.dirs = null;
	}

	/*
	 * Returns title of a {@code} Node
	*/
	public String getTitle() {
		return this.title;
	}

	/* 
	 * Returns all files in a directory
	*/
	public List<File> getFiles() {
		return this.files;
	}

	/*
	 * Set an empty list of files
	*/
	public void setFiles() {
		this.files = new ArrayList<File>();
	}

	/*
	 * Returns all sub-directories a directory 
	*/
	public List<Node> getDirs() {
		return this.dirs;
	}

	/*
	 * Initiate list of directories for a given Node
	*/
	public void setDirs() {
		this.dirs = new ArrayList<Node>();
	}
}
