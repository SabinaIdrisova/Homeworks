/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1t1;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;


/**
 *
 * @param <T> 
 * @author 1
 */
public class TreeIterator<T> implements Iterator<T> {
    
    /**
     * 
     * @param tree
     */
    public TreeIterator(Tree tree) {
        this.current = tree.getRoot();
        stack.push(current);
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        current = stack.pop();
        T value = (T) current.getValue();
        if (current.getRight() != null) {
            stack.push(current.getRight());
        }
        if (current.getLeft() != null) {
            stack.push(current.getLeft());
        }
        if (stack.empty()) {
            current = null;
        }
        return value;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private Node current;
    private Stack<Node> stack = new Stack<>();
}
