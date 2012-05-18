package c2;

import java.util.ArrayList;

public class BubbleSort<T> {
    
    /**
     * Сортировка методом пузырька
     * @param list сортируемый список
     * @param comparator компаратор
     * @return отсортированный список
     */
    public ArrayList<T> bubbleSort(ArrayList<T> list, Comparator<T> comparator) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i; j < list.size(); j++) {
                if (comparator.compare(list.get(i), list.get(j)) > 0) {
                    T temp = list.get(j);
                    list.set(j, list.get(i));
                    list.set(i, temp);
                }
            }
        }
        return list;
    }
}



