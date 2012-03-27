package task3;

public class ListElement {
    
    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public ListElement getNext() {
        return next;
    }
    
    public void setNext(ListElement pointer) {
        this.next = pointer;
    }
    	
    public ListElement(int value, ListElement pointer) {
        this.value = value;
        this.next = pointer;
    }
    
    private int value;
    
    private ListElement next;
    
}
