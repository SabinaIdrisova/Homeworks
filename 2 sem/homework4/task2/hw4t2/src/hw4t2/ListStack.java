package hw4t2;

public class ListStack implements StackInterface {
    
    public ListStack() {
        head = null;
    }
    
    public void push(int value) {
        StackElement newHead = new StackElement(value, head);
        head = newHead;    
    }

    public void pop() {
        if (isEmpty())
            System.out.println("Empty stack!");
        else
            head = head.next;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int top() {
        if (isEmpty())
            return -1;
        else
            return head.value;
    }
    
    private StackElement head;
    
    private class StackElement {
        
        private StackElement(int value, StackElement pointer) {
            this.value = value;
            this.next = pointer;
        }
        
        private int value;
        
        private StackElement next;
    }
       
}
