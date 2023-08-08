import java.awt.event.ActionListener;


/**
 * View interface.
 *
 * @author Daniil Gofman
 */
public interface TreeAppView extends ActionListener {

    /**
     * Register argument as observer/listener of this; this must be done first,
     * before any other methods of this class are called.
     *
     * @param controller
     *            controller to register
     */
    void registerObserver(TreeAppController controller);

    /**
     * Updates top operand display based on NaturalNumber provided as argument.
     *
     * @param n
     *            new value of top operand display
     */
    void updateTopDisplay(String n);

}
