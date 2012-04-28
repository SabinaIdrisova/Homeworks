package hw7t1;

import java.util.Iterator;
import java.util.Collection;

public class List<T> implements Iterable<T> {
    
    public List() {
        count = 0;
	head = null;
	tail = null;
    }
	
    /**
     * Добавление элемента в начало списка
     * @param value значение добавляемого элемента 
     */
    public void addToStart(T value) {
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
    public void addToEnd(T value) {
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
    public void insert(T value, ListElement position) {
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
	
    public T getValue(ListElement position) {
	return position.getValue();
    }
    
    @Override
    public ListIterator<T> iterator() {
        return new MyIterator();
    }
    
    private ListElement head;
	
    private ListElement tail;
	
    private int count;
    
    private class ListElement {
    
        public T getValue() {
            return value;
        }
    
        public void setValue(T value) {
            this.value = value;
        }
    
        public ListElement getNext() {
            return next;
        }
    
        public void setNext(ListElement pointer) {
            this.next = pointer;
        }
    	
        private ListElement(T value, ListElement pointer) {
            this.value = value;
            this.next = pointer;
        }
    
        private T value;
    
        private ListElement next;
    }
    
    public class MyIterator<T> implements ListIterator<T> {
        
        public MyIterator() {
            next = null;
            cur = null;
            prev = null;
        }
        
        @Override
        public boolean hasNext() {
            if (cur == null && prev == null)
                return head != null;
            return next != null;
        }


        @Override
        public T next() {
            if (cur == null && prev == null) {
                cur = head;
                next = cur.getNext();
                return (T) cur.getValue();
            }
            else if (next == null)
                return null;
            else {
                prev = cur;
                cur = cur.getNext();
                next = cur.getNext();
                return (T) cur.getValue();
            }
        }

        @Override
        public void remove() {
            if (cur != null && prev == null ) {
                cur = cur.getNext();
            }
            else {
                prev.setNext(cur.getNext());
            }
        }
        
        private ListElement next;
        
        private ListElement cur;
        
        private ListElement prev;
    }
    
}