package task3;

public class List {
    
    public List() {
        count = 0;
	head = null;
	tail = null;
    }
	
    /**
     * Добавление элемента в начало списка
     * @param value значение добавляемого элемента 
     */
    public void addToStart(int value) {
        if (count == 0) {
            ListElement newEl = new ListElement(value, null);
            head = newEl;
            tail = newEl;
            count++;
        }
        else {
           ListElement newEl = new ListElement(value, head);
           head = newEl;
           count++;
        }
    }
	
    /**
     * Добавление элемента в конец списка
     * @param value значение добавляемого элемента
     */
    public void addToEnd(int value) {
	if (count == 0) {
	    ListElement newEl = new ListElement(value, null);
	    head = newEl;
	    tail = newEl;
	    count++;
	}
	else {
	    ListElement newEl = new ListElement(value, null);
	    tail.setNext(newEl);
	    tail = newEl;
	    count++;
	}	
    }
	
    /**
     * Добавление элемента на указанную позицию
     * @param value значение добавляемого элемента
     * @param position позиция, на которую нужно добавить
     */
    public void insert(int value, ListElement position) {
	if (position == head) {
	    addToStart(value);         
	}
	else
            if (position == tail) {
	        addToEnd(value);
	    }
	    else {
		    ListElement temp = new ListElement(position.getValue(), position.getNext());
		    position.setValue(value);
		    position.setNext(temp);
		    count++;
	    }	
    }
	
    /**
     * Удаление элемента
     * @param position позиция элемента, который необходимо удалить
     */
    public void deleteElement(ListElement position) {
        if (count != 1) {
	    if (position != head && position != tail) {
		prevPosition(position).setNext(position.getNext());
		position.setValue(nextPosition(position).getValue());
		position.setNext(nextPosition(position).getNext());
		count--;
	    }
	    else
		if (position == head) {
		    position.setValue(nextPosition(position).getValue());
		    position.setNext(nextPosition(position).getNext());
		    count--;
	        }
		else {
                    if (count != 2) {
	                position.setValue(prevPosition(position).getValue());
			prevPosition(prevPosition(position)).setNext(position);
			count--;
                    }
                    else {
                        position.setValue(prevPosition(position).getValue());
                        deleteElement(prevPosition(position));
                    }
		}
        }
        else {
            deleteList();
        }
    }
	
    /**
     * Удаление списка
     */
    public void deleteList() {
	head = null;
	tail = null;
	count = 0;
    }
	
    /**
     * Длина списка
     */
    public int lengthOfList() {
	return count;
    }
	
    /**
     * Печать списка
     */
    public void printList() {
        if (head == null) {
	    System.out.println("No list!");
	}
	else {
	    ListElement printEl = head;
	    while (printEl != null) {
	        System.out.print(printEl.getValue() + " ");
	        printEl = printEl.getNext();
	    }
	    System.out.println();
	}
    }
	
    /**
     * 
     * @return первый элемент списка
     */
    public ListElement firstPosition() {
	return head;
    }
	
    /**
     * 
     * @return последний элемент списка
     */
    public ListElement lastPosition() {
	return tail;
    }
	
    /**
     * 
     * @param position позиция элемента
     * @return следующий элемент
     */
    public ListElement nextPosition(ListElement position) {
	return position.getNext();
    }
	
    /**
      * 
      * @param position позиция элемента
      * @return предыдущий элемент
      */
    public ListElement prevPosition(ListElement position) {
	ListElement cur = head;
	while (cur.getNext() != position) {
	    cur = cur.getNext();
	}
	return cur;
    }
	
    public int getValue(ListElement position) {
	return position.getValue();
    }
    
    private ListElement head;
	
    private ListElement tail;
	
    private int count;
}
