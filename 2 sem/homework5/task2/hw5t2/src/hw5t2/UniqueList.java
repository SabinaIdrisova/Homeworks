package hw5t2;

public class UniqueList extends List {
    
     /**
     * Добавление элемента в начало списка
     * @param value значение добавляемого элемента
     * @throws ElementExistsInListException бросает исключение, если элемент с данным значением уже есть в списке
     */

    @Override
    public void addToStart(int value) throws ElementExistsInListException {
        if (count == 0) {
            ListElement newEl = new ListElement(value, null);
            head = newEl;
            tail = newEl;
            count++;
        }
        else {
            ListElement temp = head;
            while (temp != null) {
                if (temp.getValue() == value)
                    throw new ElementExistsInListException ("Element already exists in list!");
                else
                    temp = temp.getNext();
            }
            ListElement newEl = new ListElement(value, head);
            head = newEl;
            count++;
        }
    }
    
    /**
     * Добавление элемента в конец списка
     * @param value значение добавляемого элемента
     * @throws ElementExistsInListException бросает исключение, если элемент с данным значением уже есть в списке  
     */
    @Override
    public void addToEnd(int value) throws ElementExistsInListException {
	if (count == 0) {
	    ListElement newEl = new ListElement(value, null);
	    head = newEl;
	    tail = newEl;
	    count++;
	}
	else {
            ListElement temp = head;
            while (temp != null) {
                if (temp.getValue() == value)
                    throw new ElementExistsInListException ("Element already exists in list!");
                else
                    temp = temp.getNext();
            }
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
     * @throws ElementExistsInListException бросает исключение, если элемент с данным значением уже есть в списке  
     */
    @Override
    public void insert (int value, ListElement position) throws ElementExistsInListException {
	if (position == head) {
	    addToStart(value);         
	}
        else if (position == tail) {
	         addToEnd(value);
	     }
	else {
            ListElement temp = head;
            while (temp != null) {
                if (temp.getValue() == value)
                    throw new ElementExistsInListException ("Element already exists in list!");
                else
                    temp = temp.getNext();
            }            
	    ListElement cur = new ListElement(position.getValue(), position.getNext());
	    position.setValue(value);
	    position.setNext(cur);
	    count++;   
	}	
    }
   
    /**
     * 
     * @param value значение удаляемого элемента
     * @throws RemoveElementNonexistInListException бросает исключение, если элемента нет в списке
     */
    public void removeElement(int value) throws RemoveElementNonexistInListException {
        ListElement temp = head;
        boolean exist = false;
        while (temp != null) {
            if (temp.getValue() == value) {
                ListElement cur = head;
                while (cur.getValue() != value)
                    cur = cur.getNext();
                deleteElement(cur);
                exist = true;
                break;
            }
            else {
                temp = temp.getNext();
            }      
        }
        if (!exist) 
            throw new RemoveElementNonexistInListException ("Element non-exist in list");
    }	 
}
