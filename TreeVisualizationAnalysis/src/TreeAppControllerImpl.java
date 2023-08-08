/*
 * Controller class.
 *
 * @author Daniil Gofman
 */
public final class TreeAppControllerImpl implements TreeAppController {

    /*
     * Model object.
     */
    private final TreeAppModel model;

    /*
     * View object.
     */
    private final TreeAppView view;
    
    /*
	 * Tree representation.
	*/
    private Tree tree;

    /*
     * Updates this.view to display this.model, and to allow only operations
     * that are legal given this.model.
     *
     * @param model
     *            the model
     * @param view
     *            the view
     * @ensures [view has been updated to be consistent with model]
     */
    private static void updateViewToMatchModel(TreeAppModel model,
            TreeAppView view) {
    	
        /*
         * Update view to reflect changes in model
         */
        view.updateTopDisplay(model.top());
    }

    /*
     * Constructor.
     *
     * @param model
     *            model to connect to
     * @param view
     *            view to connect to
     */
    public TreeAppControllerImpl(TreeAppModel model, TreeAppView view) {
        this.model = model;
        this.view = view;
        updateViewToMatchModel(model, view);
    }

    @Override
    public void processCreateEvent(String root) {
    	/*
         * Update model in response to this event
         */
    	tree = new Tree(root);
    	/*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processAddNodeEvent(String parentNode, String node) {
    	/*
         * Update model in response to this event.
         */
    	tree.addNode(parentNode, node);
    	/*
         * Update view to reflect changes in model.
         */
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processDeleteNodeEvent(String node) {

		/*
		 * Deletes {@code Node} from a tree by title.
		*/
    	tree.deleteNode(node);
    	/*
         * Update view to reflect changes in model.
         */
        updateViewToMatchModel(this.model, this.view);

    }

	@Override
	public Tree processPrintTreeEvent() {
		return tree;
	}

}
