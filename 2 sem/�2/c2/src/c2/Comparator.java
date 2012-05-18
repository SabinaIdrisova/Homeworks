package c2;

public class Comparator<T> {
    
    /**
     * Сравнение двух объектов
     * @param object1 первый объект
     * @param object2 второй объект
     * @return результат сравнения
     */
    public int compare (T object1, T object2) {
        return object1.hashCode() - object2.hashCode();
    }
}
