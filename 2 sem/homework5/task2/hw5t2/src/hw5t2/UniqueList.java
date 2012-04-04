package hw5t2;

public class UniqueList extends List {
    
     /**
     * Добавление элемента в начало списка
     * @param value значение добавляемого элемента
     * @throws ElementExistsInListException бросает исключение, если элемент с данным значением уже есть в списке
     */
    @Override
    public void addToStart(int value) throws ElementExistsInListException {
        if (ElementExists(value)) 
            throw new ElementExistsInListException();
        else
            super.addToStart(value);
    }
    
    /**
     * Добавление элемента в конец списка
     * @param value значение добавляемого элемента
     * @throws ElementExistsInListException бросает исключение, если элемент с данным значением уже есть в списке  
     */
    @Override
    public void addToEnd(int value) throws ElementExistsInListException {
        if (ElementExists(value)) 
            throw new ElementExistsInListException();
        else
            super.addToEnd(value);
    }
    
    /**
     * Добавление элемента на указанную позицию
     * @param value значение добавляемого элемента
     * @param position позиция, на которую нужно добавить
     * @throws ElementExistsInListException бросает исключение, если элемент с данным значением уже есть в списке  
     */
    @Override
    public void insert (int value, ListElement position) throws ElementExistsInListException {
        if (ElementExists(value)) 
            throw new ElementExistsInListException();
        else
            super.insert(value, position);
    }
   
    /**
     * 
     * @param value значение удаляемого элемента
     * @throws RemoveElementNonexistInListException бросает исключение, если элемента нет в списке
     */
    public void removeElement(int value) throws RemoveElementNonexistInListException {
        if (!ElementExists(value))
            throw new RemoveElementNonexistInListException();
        else {
            ListElement temp = head;
            while (temp!= null) {
                if (temp.getValue() == value) {
                    deleteElement(temp);
                    break;
                } 
                else
                    temp = temp.getNext();
            }
        }
    }	 
}
