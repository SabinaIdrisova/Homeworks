package hw2;

import java.util.Scanner;

public class Spiral {

	/**
	 * Заполнение двухмерного массива случайными числами
	 * @param array массив для заполнения
	 */
	
	private static void initArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				array[i][j] = (int)(Math.random() * 10);
			}
		}
	}
	
	/**
	 * Печать двухмерного массива
	 * @param array массив для печати
	 */
	
	private static void printArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++)
				System.out.print(array[i][j] + " ");
			System.out.println();	
		}
	}
	
	/**
	 * Вывод элементов двухмерного массива по спирали, начиная с центра
	 * @param array массив
	 * @param n количество элементов массива
	 * @param result одномерный массив, в который записываются элементы
	 */
	
	public static void spiral(int[][] array, int n, int[] result) {
		int x = n / 2;
		int y = n / 2;
		int count = 0;
		int index = 0;
		result[index] = array[x][y];
		while (count < (4 * (n / 2) + 1)) {
			switch(count % 4) {
			case 0:
			    y--;
			    index++;
			    result[index] = array[x][y];
			    if (x - 1 == y)
				    count++;
			    else 
				    if (x == 0 && y == 0)
					    count++;
			    break;
		    case 1:
			    x++;
			    index++;
			    result[index] = array[x][y];
			    if (n - x - 1 == y)
				    count++;
			    break;
		    case 2:
			    y++;
			    index++;
			   result[index] = array[x][y];
			    if (x == y)
				    count++;
			    break;
		    case 3:
			    x--;
			    index++;
			    result[index] = array[x][y];
			    if (n - x - 1 == y)
				    count++;
			    break;
		    }
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter size = 2*k + 1");
		int size = in.nextInt();
		int[][] array = new int[size][size];
		int[] result = new int[size * size];
		initArray(array);
		printArray(array);
		spiral(array, size, result);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}	
	}

}
