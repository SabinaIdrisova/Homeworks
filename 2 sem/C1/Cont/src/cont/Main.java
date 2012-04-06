package cont;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.println("Choose command:\n" + "1 - add value\n" + "2 - delete value\n" + "3 - print\n" + "4 - exit\n");
            int command = in.nextInt();
            switch(command) {
                case 1:
                    System.out.println("Input value");
                    String str = in.next();
                    System.out.println("Input priority > 0");
                    int priority = in.nextInt();
                    queue.enqueue(str, priority);
                    break;
                case 2:
                    try {
                        System.out.println("removed value = " + queue.dequeue());
                    } catch (EmptyQueueException ex) {
                        System.out.println("Empty queue!");
                    }
                    break;
                case 3:
                    try {
                        queue.print();
                    } catch (EmptyQueueException ex) {
                        System.out.println("Empty queue!");
                    }
                    break;
                case 4:
                    System.out.println("good bye!");
                    return;
            }    
        }      
    }
}
