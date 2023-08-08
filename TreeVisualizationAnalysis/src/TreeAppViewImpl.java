import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
 * View class.
 *
 * @author Daniil Gofman
 */
public final class TreeAppViewImpl extends JFrame implements TreeAppView {

    /*
	 * Place holder of a Serial Version UID. 
	 */
	private static final long serialVersionUID = 1L;

	/*
     * Controller object registered with this view to observe user-interaction
     * events.
     */
    private TreeAppController controller;

    /*
     * Text areas.
     */
    private final JTextArea tTop, tAddParent, tAddNode, tDeleteNode, tCreateTree;

    /*
     * Operator and related buttons.
     */
    private final JButton bCreateTree, bAddNode, bDeleteNode, bPrintTree;

    /*
     * Useful constants.
     */
    private static final int TEXT_AREA_HEIGHT = 25, TEXT_AREA_WIDTH = 25,  SIDE_BUTTON_PANEL_GRID_ROWS = 9,
            SIDE_BUTTON_PANEL_GRID_COLUMNS = 1, CALC_GRID_ROWS = 1,
            CALC_GRID_COLUMNS = 3;

    /*
     * No argument constructor.
     */
    public TreeAppViewImpl() {
        // Create the JFrame being extended

        /*
         * Call the JFrame (superclass) constructor with a String parameter to
         * name the window in its title bar
         */
        super("Tree Application");

        // Set up the GUI widgets --------------------------------------------

        /*
         * Set up initial state of GUI to behave like last event was "Clear";
         * currentState is not a GUI widget per se, but is needed to process
         * digit button events appropriately
         */
//        this.currentState = State.SAW_CLEAR;

        // Set up the GUI widgets --------------------------------------------
        /*
         * Create widgets
         */
        this.tTop = new JTextArea("", TEXT_AREA_HEIGHT, TEXT_AREA_WIDTH);
        this.tAddParent = new JTextArea("");
        this.tAddNode = new JTextArea("");
        this.tDeleteNode = new JTextArea("");
        this.tCreateTree = new JTextArea(""); 
        this.bCreateTree = new JButton("Create Tree");
        this.bAddNode = new JButton("Add Node");
        this.bDeleteNode = new JButton("Delete Node");
        this.bPrintTree = new JButton("Print Tree");
                
        // Set up the GUI widgets --------------------------------------------

        /*
         * Text areas should wrap lines, and should be read-only; they cannot be
         * edited because allowing keyboard entry would require checking whether
         * entries are digits, which we don't want to have to do
         */
        this.tTop.setEditable(false);
        this.tTop.setLineWrap(true);
        this.tTop.setWrapStyleWord(true);
        
        /*
         * Create scroll panes for the text areas in case number is long enough
         * to require scrolling
         */
        JScrollPane inputTextScrollPaneTop = new JScrollPane(this.tTop);

        /*
         * Create main button panel
         */

        /*
         * Create side button panel
         */

        JPanel buttonPanelSide = new JPanel(new GridLayout(
                SIDE_BUTTON_PANEL_GRID_ROWS, SIDE_BUTTON_PANEL_GRID_COLUMNS));

        /*
         * Add the buttons to the side button panel, from left to right and top
         * to bottom
         */

        buttonPanelSide.add(this.bCreateTree);
        buttonPanelSide.add(this.tCreateTree);
        buttonPanelSide.add(this.bAddNode);
        buttonPanelSide.add(this.tAddParent);
        buttonPanelSide.add(this.tAddNode);
        buttonPanelSide.add(this.bDeleteNode);
        buttonPanelSide.add(this.tDeleteNode);
        buttonPanelSide.add(this.bPrintTree);

        /*
         * Create combined button panel organized using flow layout, which is
         * simple and does the right thing: sizes of nested panels are natural,
         * not necessarily equal as with grid layout
         */
        
        JPanel buttonPanel = new JPanel();

        /*
         * Add the other two button panels to the combined button panel
         */

        buttonPanel.add(buttonPanelSide); 

        /*
         * Organize main window
         */

        this.setLayout(new GridLayout(CALC_GRID_ROWS,
        		CALC_GRID_COLUMNS));
        
        buttonPanelSide.setLayout(new GridLayout(SIDE_BUTTON_PANEL_GRID_ROWS,
        		SIDE_BUTTON_PANEL_GRID_COLUMNS));
        /*
         * Add scroll panes and button panel to main window, from left to right
         * and top to bottom
         */
        this.add(inputTextScrollPaneTop);
        this.add(buttonPanel);

        // Set up the observers ----------------------------------------------

        /*
         * Register this object as the observer for all GUI events
         */
        this.bCreateTree.addActionListener(this);
        this.bAddNode.addActionListener(this);
        this.bDeleteNode.addActionListener(this);
        this.bPrintTree.addActionListener(this);

        // Set up the main application window --------------------------------

        /*
         * Make sure the main window is appropriately sized, exits this program
         * on close, and becomes visible to the user
         */
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void registerObserver(TreeAppController controller) {
    	/*
         * Update model in response to this event
         */
    	this.controller = controller;
    }

    @Override
    public void updateTopDisplay(String n) {
    	/*
         * Update model in response to this event
         */
    	this.tTop.setText(n);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        /*
         * Set cursor to indicate computation on-going; this matters only if
         * processing the event might take a noticeable amount of time as seen
         * by the user
         */
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        /*
         * Determine which event has occurred that we are being notified of by
         * this callback; in this case, the source of the event (i.e, the widget
         * calling actionPerformed) is all we need because only buttons are
         * involved here, so the event must be a button press; in each case,
         * tell the controller to do whatever is needed to update the model and
         * to refresh the view
         */
        Object source = event.getSource();
        if (source == this.bCreateTree) {
            this.controller.processCreateEvent(this.tCreateTree.getText());
//            this.currentState = State.SAW_CLEAR;
        } else if (source == this.bAddNode) {
            this.controller.processAddNodeEvent(this.tAddParent.getText(), this.tAddNode.getText());
//            this.currentState = State.SAW_ENTER_OR_SWAP;
        } else if (source == this.bDeleteNode) {
        	this.controller.processDeleteNodeEvent(this.tDeleteNode.getText());
//            this.currentState = State.SAW_ENTER_OR_SWAP;
        } else if (source == this.bPrintTree) {
        	Tree tree = this.controller.processPrintTreeEvent();
        	printHelper(tree.getRoot(), "", "|---");
//        	this.currentState = State.SAW_ENTER_OR_SWAP;
        }
        
        /*
         * Set the cursor back to normal (because we changed it at the beginning
         * of the method body)
         */
        this.setCursor(Cursor.getDefaultCursor());
    }

	/*
	 * Print tree helper.
	 * @param {@code Node root}
	 * 			root node.
	 * @param {@code String parentPrefix}
	 * 			parent prefix.
	 * @param {@code String prefix}
	 * 			prefix of a string to be printed.
	*/
    private void printHelper(Node root, String parentPrefix, String prefix) {
		String childPrefix = "\t";
		int len = root.getChildren().size();
		this.tTop.append(String.format("%s%s%s\n", parentPrefix, prefix, root.getTitle()));
		prefix = "|---"; 
		for (int i = 0; i < len; i++) {
			if (i == len - 1) {
				prefix = "---";
			}
			printHelper(root.getChildren().get(i), parentPrefix+childPrefix, prefix);
		}
	}

}
