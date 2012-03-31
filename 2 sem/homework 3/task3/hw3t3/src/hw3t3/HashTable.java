
package hw3t3;

public class HashTable {
    
    public HashTable() {
        hashTable = new List[hashLength];
        for (int i = 0; i < hashLength; i++)
            hashTable[i] = new List();
    }
    
    /**
     * Добавление элемента в хэш-таблицу
     * @param word 
     */
    public void addEl(String word) {
        int index = word.hashCode() % hashLength;
        hashTable[index].addToEnd(word);
    }
    
    /**
     * Удаление элемента из хэш-таблицы
     * @param word
     */
    public void delEl(String word) {
        int index = word.hashCode() % hashLength;
        ListElement temp = hashTable[index].findPosition(word);
        if (temp != null) {
            hashTable[index].deleteElement(temp);
        }
        else
            System.out.println ("Element doesn't exist");
    }
    
    /**
     * Проверка на существование элемента в хэш-таблице
     * @param word
     * @return true - элемент существует, false - элемента нет
     */
    public boolean findElement(String word) {
        int index = word.hashCode() % hashLength;
        return hashTable[index].findElement(word);
    }
    
    private int hashLength = 40;
    
    private List[] hashTable;
}

