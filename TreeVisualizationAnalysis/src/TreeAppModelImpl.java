/*
 * Model class.
 *
 * @author Daniil Gofman
 */
public final class TreeAppModelImpl implements TreeAppModel {

    /*
     * Model variables.
     */
    private String top, bottom;

    /*
     * No argument constructor.
     */
    public TreeAppModelImpl() {
        this.top = "";
        this.bottom = "";
    }

    @Override
    public String top() {
        return this.top;
    }

    @Override
    public String bottom() {
        return this.bottom;
    }
    
    @Override
    public void setBottom(String text) {
    	this.bottom = text;
    }

}
