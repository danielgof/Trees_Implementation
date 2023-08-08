public class Main {

	public static void main(String[] args) {
		
		TreeAppModel model = new TreeAppModelImpl();
		TreeAppView view = new TreeAppViewImpl();
		TreeAppController controller = new TreeAppControllerImpl(model, view);
		view.registerObserver(controller);
		
//		Tree tree = new Tree("CEO");
//		tree.addNode("CEO", "CTO");
//		tree.addNode("CEO", "TechLead");
//		tree.addNode("CEO", "Project Manager");
//		tree.addNode("TechLead", "Senior Dev");
//		tree.print();
//		System.out.println(tree.search("CTO"));
//		tree.deleteNode("CTO");
//		System.out.println(tree.search("CTO"));
	}
}
