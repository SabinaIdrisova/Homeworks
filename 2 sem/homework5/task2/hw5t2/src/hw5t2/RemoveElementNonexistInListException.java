package hw5t2;

public class RemoveElementNonexistInListException extends Exception {

    /**
     * Creates a new instance of
     * <code>RemoveElementNonexistInListException</code> without detail message.
     */
    public RemoveElementNonexistInListException() {
    }

    /**
     * Constructs an instance of
     * <code>RemoveElementNonexistInListException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public RemoveElementNonexistInListException(String msg) {
        super(msg);
    }
}
