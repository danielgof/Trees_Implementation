/**
 * Model interface.
 *
 * The Natural Number Calculator model consists of the top and bottom operands
 * (which have only getter methods).
 *
 * @author Daniil Gofman
 *
 * @mathmodel <pre>
 * type NNCalcModel is modeled by
 *   (top: NATURAL_NUMBER,
 *    bottom: NATURAL_NUMBER)
 * </pre>
 * @initially <pre>
 * ():
 *  ensures
 *   this = (0, 0)
 * </pre>
 */
public interface TreeAppModel {

    /*
     * Reports top operand.
     *
     * @return this.top
     * @aliases reference returned by {@code top}
     * @ensures top = this.top
     */
    String top();

    /*
     * Reports bottom operand.
     *
     * @return this.bottom
     * @aliases reference returned by {@code bottom}
     * @ensures bottom = this.bottom
     */
    String bottom();

	/*
	*/
    void setBottom(String text);
}
