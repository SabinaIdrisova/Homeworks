
package hw1t1;

import java.util.Iterator;

public class Tree<T extends Comparable<T>> implements Iterable<T> {
    
    /**
     * constructor for Tree
     */
    public Tree() {
        this.root = null;
    }
    
    /**
     * check if tree is empty
     * @return true, if tree is empty, false, if tree isn't empty
     */
    public boolean isEmpty() {
        return root == null;
    }
    
    /**
     * add new element to the tree
     * @param value value to add
     */
    public void addElement(T value) {
        if (isEmpty()) {
            root = new Node<>(value);
        } else {
            root.addElement(value);
        }
    }
    
    /**
     * check if the element is in tree
     * @param value value of element 
     * @return true, if element is found, false, if element isn't found
     */
    public boolean findElement(T value) {
        if (!isEmpty()) {
            return root.findElement(value);
        } else {
            return false;
        }
    }
    
    /**
     * root of the tree
     * @return root of the tree
     */
    public Node<T> getRoot() {
        return root;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new TreeIterator<>(this);
    }
    
    private Node<T> root;
}
