package tree;

public class FileSystemImpl implements FileSystem {
	
	private Tree fileSystem;
	private String path;
	private String allPath;
	
	public FileSystemImpl() {
		this.fileSystem = new Tree();
		this.path = this.fileSystem.getRoot().getTitle();
		this.allPath = this.fileSystem.getRoot().getTitle();
	}

	@Override
	public void addDir(String dir) {
		this.fileSystem.addNode(path, dir);
	}

	@Override
	public void addFile(String fileName) {
		this.fileSystem.addFile(this.path, fileName);
	}

	@Override
	public void rmDir(String dir) {
		this.fileSystem.deleteNode(dir);
	}

	@Override
	public void rmFile(String fileName) {
		this.fileSystem.deleteFile(fileName);
	}

	@Override
	public void printDir() {
		this.fileSystem.printNodes(this.path);
		this.fileSystem.printFiles(this.path);
	}

	@Override
	public void chooseDir(String pathChoose) {
		if (pathChoose.equals("..")) {
			String[] dirs = this.allPath.split("/");
			String newPath = "";
			newPath += dirs[0];
			if (dirs[dirs.length - 2].equals(".")) {
				this.path = dirs[dirs.length - 2] + "/";				
			} else {
				this.path = dirs[dirs.length - 2];
			}
			for (int i = 1; i < dirs.length - 1; i++) {
				newPath = newPath + "/" + dirs[i];
			}
			if (newPath.equals(".")) {
				newPath += "/";
			}
			this.allPath = newPath;
		} else {
			this.path = pathChoose;	
			if (this.allPath.equals("./")) {
				this.allPath = this.allPath + pathChoose;			
			} else {
				this.allPath = this.allPath + "/" + pathChoose;
			}			
		}
	}

	@Override
	public String getPath() {
		return this.allPath;
	}	
	
}
