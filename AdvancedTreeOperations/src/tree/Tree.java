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
        } else if (value.compareTo(this.value) > 0) {
        	result = this.right.deleteNode(value);
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

	/*
	 * Returns the height of a {@code} tree
	*/
    public int height() {
    	int result;
    	if (this.size() != 0) {
    		result = 1;
    		if (this.left == null || this.right == null) {
        		if (this.left == null && this.right == null) {
        			result = 1;     			
        		} else if (this.left != null) {
        			result += this.left.height();     			
        		} else if (this.right != null) {
        			result += this.right.size();
        		}
        	} else {
    	    	int resLeft = this.left.height();
    	    	int resRight = this.right.height();  
    	    	result += (resLeft > resRight) ? resLeft : resRight;
        	}
    	} else {
    		result = 0;
    	}
    	return result;
    }

	/*
	 * Search for {@code} T value
	 * 			in the tree
	 * 
	 * @param {@code} T
	 * 			value to search in the tree
	*/
    public boolean search(T value) {
    	boolean result = false;
    	if (this.size() != 0) {
    		if (this.value == value) {
    			result = true;
    		} else if (this.value.compareTo(value) > 0) {
    			result = this.left.search(value);
    		} else {
    			result = this.right.search(value);
    		}
    	}
    	return result;
    }
    
    
    public int depth(T value) {
    	int result = 0;
    	if (this.search(value)) {
    		if (this.value == value) {
    			result = 0;
    		} else if (this.value.compareTo(value) > 0) {
    			result = 1 + this.left.depth(value);
    		} else {
    			result = 1 + this.right.depth(value);
    		}
    	}
    	return result;
    }
}
