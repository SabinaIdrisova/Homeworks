import java.util.Scanner;

public class ColSort {
	private static void initArray(int[][] array, int row, int col){
		for (int i = 0; i < row; i++){
			for (int j = 0; j < col; j++){
				array[i][j] = (int)(Math.random() * 10);
		    }
		}
	}
    private static void printArray(int[][] array, int row, int col){
    	for (int i = 0; i < row; i++){
			for (int j = 0; j < col; j++)
				System.out.print(array[i][j] + " ");
			System.out.println();	
		}
    }
    
    public static void swap(int[][] array, int i, int j, int k) {
		 int temp = array[k][i];
		 array[k][i] = array[k][j];
		 array[k][j] = temp;
	}
	
   public static void sort(int[][] array, int row, int col) {
       for (int i = 0; i < col; i++){
   		    for (int j = i + 1; j < col; j++){
   			    if (array[0][i] > array[0][j]){
   				    for (int k = 0; k < row; k++)
   				        swap(array, i, j, k);
   		        }	
   	        }
   	   }
   }
	public static void main(String[] args) {
		int row;
		int col;
		int[][] array;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of rows and columns ");
		row = in.nextInt();
		col = in.nextInt();
		array = new int[row][col];
        initArray(array, row, col);
        printArray(array, row, col);
        sort(array, row, col);
        System.out.println("New matrix");
        printArray(array, row, col);
	}
}
