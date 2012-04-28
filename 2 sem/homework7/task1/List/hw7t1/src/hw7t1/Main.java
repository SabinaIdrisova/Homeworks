package hw7t1;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new List<Integer>();
        list.addToStart(1);
        list.addToStart(2);
        list.addToStart(3);
        list.addToStart(4);
        ListIterator<Integer> iterator = list.iterator();
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }     
}
