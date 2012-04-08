package hw7t2;

public class Set<T> {
    
    public Set() {
        first = null;
    }
    
    /**
     * Add element to set
     * @param value value to add
     * @throws ElementExistsException throws exception if element already exists in set
     */
    public void addElement(T value) throws ElementExistsException {
        if (elementExists(value))
            throw new ElementExistsException();
        else {
            if (isEmpty()) {
                SetElement newEl = new SetElement(value, null);
                first = newEl;
            }
            else {
                SetElement newEl = new SetElement(value, first);
                first = newEl;    
            }        
        }
    }
    
    /**
     * Delete element
     * @param value value to delete
     * @throws ElementNotFoundException throws exception if element not found in set
     */
    public void deleteElement(T value) throws ElementNotFoundException {
        if (!elementExists(value))
            throw new ElementNotFoundException();
        else {
            if (first.value == value) {
                first.value = first.next.value;
                first.next = first.next.next;
            }
            else {
                SetElement cur = first;
                while (cur.next.value != value )
                    cur = cur.next;
                cur.next = cur.next.next;
            }  
        }
    }
    
    /**
     * Check element exists in set 
     * @param value value to check
     * @return true if element exists in set, false if element doesn't exist
     */
    public boolean elementExists(T value) {
        SetElement cur = first;
        while (cur != null) {
            if (cur.value == value)
                return true;
            cur = cur.next;
        }
        return false;
    }
    
    /**
     * Intersection of two sets
     * @param set1 first set
     * @param set2 second set
     * @param result intercestion
     * @throws ElementExistsException throws exception if element already exists in set
     */
    public void intersection(Set set1, Set set2, Set result) throws ElementExistsException {
        SetElement cur = set1.first;
        while (cur != null) {
            if (set2.elementExists(cur.value))
                    result.addElement(cur.value);
            cur = cur.next;
        }   
    }
    
    /**
     * Association of two sets
     * @param set1 first set
     * @param set2 second set
     * @param result association
     * @throws ElementExistsException throws exception if element already exists in set
     */
    public void association(Set set1, Set set2, Set result) throws ElementExistsException {
        SetElement cur = set1.first;
        while (cur != null) {
            result.addElement(cur.value);
            cur = cur.next;
        }
        cur = set2.first;
        while (cur != null) {
            result.addElement(cur.value);
            cur = cur.next;
        }
    }
    
    /**
     * Check set is emty
     * @return true if set is empty, false if set isn't empty
     */
    public boolean isEmpty() {
        return first == null;
    }
    
    /**
     * Print set
     * @throws EmptySetException throws exception if set is empty
     */
    public void print() throws EmptySetException {
        if (isEmpty())
            throw new EmptySetException();
        else {
            SetElement printEl = first;
            while (printEl != null) {
                System.out.print(printEl.value + " ");
                printEl = printEl.next;
            }
            System.out.println();
        }    
    }
    
    private SetElement first;
    
    private class SetElement {
        
        public SetElement(T value, SetElement next) {
            this.value = value;
            this.next = next;
        }
        
        private T value;
        
        private SetElement next;
    }
}
