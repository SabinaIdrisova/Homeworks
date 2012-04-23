package hw7t1stack;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        try {
            System.out.println(stack.top());
        } catch (EmptyStackException ex) {
            System.out.println("Stack is Empty!");
        }
        try {
            stack.pop();
        } catch (EmptyStackException ex) {
            System.out.println("Stack is Empty!");
        }
        try {
            stack.pop();
        } catch (EmptyStackException ex) {
            System.out.println("Stack is Empty!");
        }
        try {
            System.out.println(stack.top());
        } catch (EmptyStackException ex) {
            System.out.println("Stack is Empty!");
        }
    }
}
