package hw3t3;

public class ListElement {
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    public ListElement getNext() {
        return next;
    }
    
    public void setNext(ListElement pointer) {
        this.next = pointer;
    }
    	
    public ListElement(String value, ListElement pointer) {
        this.value = value;
        this.next = pointer;
    }
    
    private String value;
    
    private ListElement next;
    
}
