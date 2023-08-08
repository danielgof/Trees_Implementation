package tree;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		FileSystem fsystem = new FileSystemImpl();
		Scanner scan = new Scanner(System.in);
		String command = "";
		while (!command.equals("end")) {
			System.out.print(fsystem.getPath() + " ");
			command = scan.nextLine();
			String[] commands = command.split(" ");
			switch(commands[0]) {
			case "ls":	
				fsystem.printDir();
				break;
			case "..":
				break;
			case "mkdir":
				fsystem.addDir(commands[1]);
				break;
			case "touch":
				fsystem.addFile(commands[1]);
				break;
			case "cd":
				fsystem.chooseDir(commands[1]);
				break;
			case "rm":
				fsystem.rmFile(commands[1]);
				break;
			case "rmdir":
				fsystem.rmDir(commands[1]);
				break;	
			default:
				System.out.println("Unknow command");
				break;
			}
		}
		scan.close();
	}
}
