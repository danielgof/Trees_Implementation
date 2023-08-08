package tree;

/*
 * The {@code} Interface to describe behavior of file system
*/
public interface FileSystem {
	public void addDir(String dir);
	public void addFile(String fileName);
	public void rmDir(String dir);
	public void rmFile(String fileName);

	/*
	 * Prints into console all files and directories in current directory
	*/
	public void printDir();
	public void chooseDir(String pathChoose);
	
	public String getPath();
}
