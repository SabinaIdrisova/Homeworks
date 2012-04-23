package hw7t1stack;

public class Stack<T> {
    
    public Stack() {
        head = null;
    }
    
    /**
     * Добавление элемента
     * @param value значение добавляемого элемента
     */	
    public void push(T value) {
	StackElement newHead = new StackElement(value, head);
	head = newHead;
    }
	
    /**
     * Удаление элемента
     * @return удаляемый элемент
     * @throws EmptyStackException бросает исключение, если стек пуст
     */
    public T pop() throws EmptyStackException {
        if (isEmpty()) {
	    throw new EmptyStackException();
	}
	else {
            T result = head.value;
	    head = head.next;
	    return result;
	}
    }
	
    /**
     * Проверка стека на пустоту
     * @return true - стек пуст, false - стек не пуст
     */
    public boolean isEmpty() {
	return head == null;
    }
	
    /**
     * 
     * Вершина стека
     * @return значение вершины стека
     * @throws EmptyStackException бросает исключение, если стек пуст
     */
    public T top() throws EmptyStackException {
        if (!isEmpty()) {
            return head.value;
        }
        else {
            throw new EmptyStackException();
        }	
    }
    
    private StackElement head;
    
    private class StackElement {
       
        public StackElement(T value, StackElement next) {
            this.value = value;
            this.next = next;
        }
       
        private T value;
       
        private StackElement next;
    }
}
