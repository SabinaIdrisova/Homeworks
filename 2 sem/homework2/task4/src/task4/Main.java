package task4;

public class Main {

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(4);
		stack.push(8);
		System.out.println(stack.top());
		stack.pop();
		System.out.println(stack.top());
	}

}
