package task4;

public class Stack {
	
	private StackElement head;
	
	public Stack() {
		head = null;
	}
	
	/**
	 * ���������� ��������
	 * @param value �������� ������������ ��������
	 */
	
	public void push(int value) {
		StackElement newHead = new StackElement();
		newHead.next = head;
		newHead.value = value;
		head = newHead;
	}
	
	/**
	 * �������� ��������
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
	 * ���������� true, ���� ���� ������; false, ���� ���� �� ������
	 */
	
	public boolean isEmpty() {
		return head == null;
	}
	
	/**
	 * 
	 * ���������� �������� ������� �����, ���� ���� �� ����; -1, � ���� ���� ����
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
