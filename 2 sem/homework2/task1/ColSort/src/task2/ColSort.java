package task2;

import java.util.Scanner;

public class ColSort {
	
    /**
     * Заполнение двухмерного массива случайными числами
     * @param array массив для заполнения
     */
	
    private static void initArray(int[][] array) {
    	for (int i = 0; i < array.length; i++) {
    		for (int j = 0; j < array[i].length; j++) {
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
    		for (int j = 0; j < array[i].length; j++)
    			System.out.print(array[i][j] + " ");
    		System.out.println();	
    	}
    }
    
    /**
     * Перемена мест двух элементов массива из разных столбцов, но одной строки
     * @param array массив
     * @param col1 номер столбца первого элемента
     * @param col2 номер столбца второго элемента
     * @param row номер строки
     */
    
    public static void swap(int[][] array, int col1, int col2, int row) {
    	int temp = array[row][col1];
    	array[row][col1] = array[row][col2];
    	array[row][col2] = temp;
    }
	
    /**
     * Сортировка столбцов массива по возрастанию
     * @param array массив
     */
    
    public static void sort(int[][] array) {
    	for (int i = 0; i < array[0].length; i++) {
    		for (int j = i + 1; j < array[0].length; j++) {
    			if (array[0][i] > array[0][j]) {
    				for (int k = 0; k < array.length; k++)
    					swap(array, i, j, k);
    			}	
    		}
    	}
    }
  
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	System.out.println("Enter the number of rows and columns ");
    	int row = in.nextInt();
    	int col = in.nextInt();
    	int[][] array = new int[row][col];
    	initArray(array);
    	printArray(array);
    	sort(array);
    	System.out.println("New matrix");
    	printArray(array);
    }
}
