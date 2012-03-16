package task4;

public class Stack {
	
	private StackElement head;
	
	public Stack() {
		head = null;
	}
	
	/**
	 * Add element
	 * @param value element value
	 */
	
	public void push(int value) {
		StackElement newHead = new StackElement();
		newHead.next = head;
		newHead.value = value;
		head = newHead;
	}
	
	/**
	 * Remove element
	 */
	
	public int pop() {
		if (isEmpty()) {
			return -1;
		}
		else {
			int result = head.value;
			head = head.next;
			return result;
		}
	}
	
	/**
	 * @return true if stack is empty, false if stack is not empty
	 */
	
	public boolean isEmpty() {
		return head == null;
	}
	
	/**
	 * 
	 * @return top value if stack is not empty, -1 if stack is empty
	 */
	
	public int top() {
		if (!isEmpty()) {
			return head.value;
		}
		else {
			return -1;
		}	
	}
}
