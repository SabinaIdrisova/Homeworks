import java.util.Scanner;

public class Spiral {

	private static void initArray(int[][] array, int size){
		for (int i = 0; i < size; i++){
			for (int j = 0; j < size; j++){
				array[i][j] = (int)(Math.random() * 10);
		    }
		}
	}
	
	private static void printArray(int[][] array, int size){
		for (int i = 0; i < size; i++){
			for (int j = 0; j < size; j++)
				System.out.print(array[i][j] + " ");
			System.out.println();	
		}
	}
	
	private static void spiral(int[][] array, int n) {
		int x = n / 2;
		int y = n / 2;
		System.out.print(array[x][y] + " ");
		int count = 0;
		while (count < (4 * (n / 2) + 1)){
	        switch(count % 4){
		    case 0:
			    y--;
			    System.out.print(array[x][y] + " ");
			    if (x - 1 == y)
				    count++;
			    else 
				    if (x == 0 && y == 0)
					    count++;
			    break;
		    case 1:
			    x++;
			    System.out.print(array[x][y]+ " ");
			    if (n - x - 1 == y)
				    count++;
			    break;
		    case 2:
			    y++;
			    System.out.print(array[x][y] + " ");
			    if (x == y)
				    count++;
			    break;
		    case 3:
			    x--;
			    System.out.print(array[x][y] + " ");
			    if (n - x - 1 == y)
				    count++;
			    break;
		    }
		}
	}
	
	public static void main(String[] args) {
		int size;
		int array[][];
		Scanner in = new Scanner(System.in);
		System.out.println("Enter size = 2*k + 1");
		size = in.nextInt();
		array = new int[size][size];
		initArray(array, size);
		printArray(array, size);
		spiral(array, size);
	}

}
