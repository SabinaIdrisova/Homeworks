package task3;

public class ListElement {
    
    public int value;
	
    public ListElement next;
    
    public ListElement(int value, ListElement pointer) {
        this.value = value;
        this.next = pointer;
    }
}
