import java.util.Scanner;

public class hw1t1 {
	private static int factorial(int n){
		if (n <= 1)
			return 1;
		return n * factorial(n - 1);	
	}
	
    public static void main(String[] args){
    	System.out.println("������� �����");
	    Scanner in = new Scanner(System.in);
	    int number = in.nextInt();
	    in.close();
	    System.out.println("��������� = " + factorial(number));
	}
}
