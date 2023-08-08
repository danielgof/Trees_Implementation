/**
 * Controller interface.
 *
 * @author Daniil Gofman
 *
 * @mathmodel <pre>
 * type NNCalcController is modeled by
 *   (model: NNCalcModel,
 *    view: NNCalcView)
 * </pre>
 * @initially <pre>
 * (TreeAppModel model, TreeAppView view):
 *   ensures
 *     this.model = model  and
 *     this.view = view
 * </pre>
 */
public interface TreeAppController {

    /*
     * Processes event to do an add operation.
     *
     * @updates this.model, this.view
     * @param {@code String} root
     */
    void processCreateEvent(String root);

    /**
     * Processes event to do a subtract operation.
     *
     * @updates this.model, this.view
     * @requires this.model.view.tree.getRoot != null
     * @param {@code String parentNode}
     * 			title of parent node to which new one will be added.
     * @param {@code String node}
     * 			a title of a new node
     */
    void processAddNodeEvent(String parentNode, String node);

    /**
     * Processes event to do a multiply operation.
     *
     * @updates this.model, this.view
     * @requires {@code Node node} node.getTitle() != null
     * @param {@code String node}
     * 			title of a node to delete
     */
    void processDeleteNodeEvent(String node);

	/*
	 * Prints tree.
	 * @returns {@code Tree}
	*/
    Tree processPrintTreeEvent();
}
