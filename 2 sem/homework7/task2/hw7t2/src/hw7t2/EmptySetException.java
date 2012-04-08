/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw7t2;

/**
 *
 * @author 1
 */
public class EmptySetException extends Exception {

    /**
     * Creates a new instance of
     * <code>EmptySetException</code> without detail message.
     */
    public EmptySetException() {
    }

    /**
     * Constructs an instance of
     * <code>EmptySetException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public EmptySetException(String msg) {
        super(msg);
    }
}
