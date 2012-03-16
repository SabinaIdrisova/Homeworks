package task2;

import java.util.Scanner;

public class ColSort {
	
    /**
     * Fill an array with random numbers
     * @param array array to fill
     */
	
    private static void initArray(int[][] array) {
    	for (int i = 0; i < array.length; i++) {
    		for (int j = 0; j < array[i].length; j++) {
    			array[i][j] = (int)(Math.random() * 10);
    		}
    	}
    }
	
    /**
     * Print an array
     * @param array array to print
     */
    
    private static void printArray(int[][] array) {
    	for (int i = 0; i < array.length; i++) {
    		for (int j = 0; j < array[i].length; j++)
    			System.out.print(array[i][j] + " ");
    		System.out.println();	
    	}
    }
    
    /**
     * Change locations of two elements of array of different columns and one row
     * @param array array
     * @param col1 column number of first element
     * @param col2 column number of second element
     * @param row row number
     */
    
    public static void swap(int[][] array, int col1, int col2, int row) {
    	int temp = array[row][col1];
    	array[row][col1] = array[row][col2];
    	array[row][col2] = temp;
    }
	
    /**
     * Sort columns of array in ascending order
     * @param array array
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
