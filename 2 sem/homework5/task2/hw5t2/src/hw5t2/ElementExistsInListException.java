package hw5t2;

public class ElementExistsInListException extends Exception {

    /**
     * Creates a new instance of
     * <code>ElementExistsInListException</code> without detail message.
     */
    public ElementExistsInListException() {
    }

    /**
     * Constructs an instance of
     * <code>ElementExistsInListException</code> with the specified detail
     * message.
     *
     * @param msg the detail message.
     */
    public ElementExistsInListException(String msg) {
        super(msg);
    }
}
