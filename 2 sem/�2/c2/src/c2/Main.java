package c2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(7);
        list.add(1);
        list.add(77);
        for (Integer i : list)
            System.out.print(i + " ");
        System.out.println();
        Comparator<Integer> comp = new Comparator<Integer>();
        BubbleSort<Integer> sort = new BubbleSort<Integer>();
        list = sort.bubbleSort(list, comp);
        System.out.println("sorted list: ");
        for (Integer i : list)
            System.out.print(i + " ");  
        System.out.println();
    }
}
