package tree;

/*
 * Tree class implementation using generic data types
 */
public class Tree<T extends Comparable<T>> {
    private T value;
    private Tree<T> left;
    private Tree<T> right;
    
    public Tree(T value) {
        this.value = value;
        left = null;
        right = null;
    }

	/*
	 * Add new node into the {@code} Tree
	 * 
	 *@param T value 
	 *		 value to insert into the {@code} Tree
	*/
    public void addNode(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Cannot add null value to the tree");
        }
        
        if (value.compareTo(this.value) < 0) {
            if (left == null) {
                left = new Tree<>(value);
            } else {
                left.addNode(value);
            }
        } else if (value.compareTo(this.value) > 0) {
            if (right == null) {
                right = new Tree<>(value);
            } else {
                right.addNode(value);
            }
        }
        // Ignore if the value already exists in the tree (assuming no duplicates)
    }

	/* 
	 * Deletes node in a {@code} Tree by given value
	 * 
	 * @param T value 
	 *		 value to delete from the {@code} Tree
	*/
    public T deleteNode(T value) {
    	if (value == null) {
            throw new IllegalArgumentException("Cannot add null value to the tree");
        }
    	T result = null;
    	if (value.compareTo(this.value) == 0) {
    		result = this.value;
    		this.value = null;
    	}
    	else if (value.compareTo(this.value) < 0) {
    		result = this.left.deleteNode(value);
//            if (left == null) {
//                left = new Tree<>(value);
//            } else {
//                left.addNode(value);
//            }
        } else if (value.compareTo(this.value) > 0) {
        	result = this.right.deleteNode(value);
//            if (right == null) {
//                right = new Tree<>(value);
//            } else {
//                right.addNode(value);
//            }
        }
    	return result;
    }

	/*
	 * Returns the size of a tree
	*/
    public int size() {
    	int result = 1;
    	if (this.left == null || this.right == null) {
    		if (this.left == null && this.right == null) {
    			result = 1;     			
    		} else if (this.left != null) {
    			result += this.left.size();
    		} else if (this.right != null) {
    			result += this.right.size();
    		}
    	} else {
	    	result += this.left.size();
	    	result += this.right.size();
    	}
    	return result;
    }
}
