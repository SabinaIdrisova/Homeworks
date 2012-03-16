package task2;

import java.util.Scanner;

public class ColSort {
	
    /**
     * ���������� ����������� ������� ���������� �������
     * @param array ������ ��� ����������
     */
	
    private static void initArray(int[][] array) {
    	for (int i = 0; i < array.length; i++) {
    		for (int j = 0; j < array[i].length; j++) {
    			array[i][j] = (int)(Math.random() * 10);
    		}
    	}
    }
	
    /**
     * ������ ����������� �������
     * @param array ������ ��� ������
     */
    
    private static void printArray(int[][] array) {
    	for (int i = 0; i < array.length; i++) {
    		for (int j = 0; j < array[i].length; j++)
    			System.out.print(array[i][j] + " ");
    		System.out.println();	
    	}
    }
    
    /**
     * �������� ���� ���� ��������� ������� �� ������ ��������, �� ����� ������
     * @param array ������
     * @param col1 ����� ������� ������� ��������
     * @param col2 ����� ������� ������� ��������
     * @param row ����� ������
     */
    
    public static void swap(int[][] array, int col1, int col2, int row) {
    	int temp = array[row][col1];
    	array[row][col1] = array[row][col2];
    	array[row][col2] = temp;
    }
	
    /**
     * ���������� �������� ������� �� �����������
     * @param array ������
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
