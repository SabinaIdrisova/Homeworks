import java.util.Scanner;
public class hw1t2 {
    private static int fib(int index){
        if (index == 1) {
            return 1;
        } else if (index == 2) {
            return 1;
        } else {
            return fib(index - 1) + fib(index - 2);
        }		
    }
	public static void main(String[] args){
		System.out.println("Сколько чисел Фибоначчи вывести?");
		Scanner in = new Scanner(System.in);
	    int value = in.nextInt();
	    in.close();
	    for (int i = 1; i <= value; i++){
	    	System.out.print(fib(i) + " ");
	    }
	}
}
