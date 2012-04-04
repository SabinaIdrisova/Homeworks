package hw4t2;

public class ArrayStack implements StackInterface {
    
    public void push(int value) {
        for (int i = count - 1; i >= 0; i--)
            stack[i + 1] = stack[i];
        stack[0] = value;
        count++;
    }
    
    public void pop() {
        for (int i = 0; i < count; i++)
            stack[i] = stack[i + 1];
        count--;
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public int top() {
        return stack[0];
    }
    
    private int count;
    
    private final int size = 100;
    
    private int[] stack = new int[size];
}
