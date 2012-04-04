package hw4t2;

public interface StackInterface {
    
    /**
     * Add element
     * @param value value to add
     */
    public void push(int value);
    
    /**
     * Remove element
     */
    public void pop();
    
    /**
     * Checks the stack is empty
     * @return true if stack is empty, false if stack isn't empty
     */
    public boolean isEmpty();
    
    /**
     * Top of stack
     * @return top value
     */
    public int top();

}
