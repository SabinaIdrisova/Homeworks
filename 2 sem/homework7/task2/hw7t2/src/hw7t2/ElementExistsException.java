/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw7t2;

/**
 *
 * @author 1
 */
public class ElementExistsException extends Exception {

    /**
     * Creates a new instance of
     * <code>ElementExistsException</code> without detail message.
     */
    public ElementExistsException() {
    }

    /**
     * Constructs an instance of
     * <code>ElementExistsException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ElementExistsException(String msg) {
        super(msg);
    }
}
