
package hw1t1;


public class Node<T extends Comparable<T>> {
    
    /**
     * conctructor for Node
     */
    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
    
    /**
     * get left son
     * @return left son of the element
     */
    public Node<T> getLeft() {
        return left;
    }
    
    /**
     * get right son
     * @return right son of the element
     */
    public Node<T> getRight() {
        return right;
    }
    
    /**
     * get value
     * @return value of the element
     */
    public T getValue() {
        return value;
    }
    
    /**
     * set left son
     * @param left element which will be left son of the current
     */
    public void setLeft(Node<T> left) {
        this.left = left;
    }
    
    /**
     * set right son
     * @param right element which will be right son of the current
     */
    public void setRight(Node<T> right) {
        this.right = right;
    
    }
    
    /**
     * add new element to the tree
     * @param value value to add
     */
    public void addElement(T value) {
        if (value.compareTo(this.getValue()) <= 0) {
            if (this.getLeft() == null) {
                Node<T> temp = new Node<>(value);
                this.setLeft(temp);
            } else {
                this.getLeft().addElement(value);
            }
        } else {
            if (this.getRight() == null) {
                Node<T> temp = new Node<>(value);
                this.setRight(temp);;
            } else {
                this.getRight().addElement(value);
            }
        }
    }
    
    /**
     * check if the element is in tree
     * @param value value of element 
     * @return true, if element is found, false, if element isn't found
     */
    public boolean findElement(T value) {
        if (this != null) {
            if (value == this.getValue()) {
                return true;
            } else if ((value.compareTo(this.getValue()) < 0) && (this.getLeft() != null)) {
                return this.getLeft().findElement(value);
            } else if ((value.compareTo(this.getValue()) > 0) && (this.getRight() != null)) {
                return this.getRight().findElement(value);
            } else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    
    private Node<T> left;
    
    private Node<T> right;
    
    private T value;
}
