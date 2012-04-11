
package hw3t4;

public class HashTable {
    
    public HashTable() {
        this.hashTable = new List[hashLength];
        for (int i = 0; i < hashLength; i++)
            hashTable[i] = new List();
    }
    
    /**
     * Добавление элемента в хэш-таблицу
     * @param word значение элемента, который нужно добавить
     */
    public void addEl(String word) {
        int index = hashFunction.hashFunction(word, hashLength);
        hashTable[index].addToEnd(word);
    }
    
    /**
     * Удаление элемента из хэш-таблицы
     * @param word значение элемента, который нужно удалить
     */
    public void delEl(String word) {
        int index = hashFunction.hashFunction(word, hashLength);
        ListElement temp = hashTable[index].findPosition(word);
        if (temp != null) {
            hashTable[index].deleteElement(temp);
        }
        else
            System.out.println ("Element doesn't exist");
    }
    
    /**
     * Проверка на существование элемента в хэш-таблице
     * @param word значение элемента, который нужно проверить на существование в хэш-таблице
     * @return true - элемент существует, false - элемента нет
     */
    public boolean findEl(String word) {
        for (int index = 0; index < hashLength; index++) {
            if (hashTable[index].findElement(word))
                return true;
        }
        return false;
    }
    
    public void setHashFunction(InterfaceOfHashFunction hashFunction) {
        this.hashFunction = hashFunction;
    }
    
    private int hashLength = 40;
    
    private List[] hashTable;   
    
    private InterfaceOfHashFunction hashFunction;
}
