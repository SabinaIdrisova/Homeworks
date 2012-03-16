package task4;

public class Stack {
	
	private StackElement head;
	
	public Stack() {
		head = null;
	}
	
	/**
	 * Добавление элемента
	 * @param value значение добавляемого элемента
	 */
	
	public void push(int value) {
		StackElement newHead = new StackElement();
		newHead.next = head;
		newHead.value = value;
		head = newHead;
	}
	
	/**
	 * Удаление элемента
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
	 * Возвращает true, если стек пустой; false, если стек не пустой
	 */
	
	public boolean isEmpty() {
		return head == null;
	}
	
	/**
	 * 
	 * Возвращает значение вершины стека, если стек не пуст; -1, в если стек пуст
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
