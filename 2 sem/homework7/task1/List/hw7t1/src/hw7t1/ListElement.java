package hw7t1;

public class ListElement<T> {
    
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
    	
    public ListElement(T value, ListElement pointer) {
        this.value = value;
        this.next = pointer;
    }
    
    private T value;
    
    private ListElement next;
    
}