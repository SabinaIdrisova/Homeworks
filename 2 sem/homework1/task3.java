import java.util.Scanner;
public class hw1t3 {
	private static void swap(int[] array, int i, int j){
		 int temp = array[i];
		 array[i] = array[j];
		 array[j] = temp;
	}
	
    private static void sort(int[] array){
    	for (int i = array.length - 1; i >= 0; i--){
    		for (int j = 0; j < i; j++){
    			if (array[j] > array[j + 1])
    				swap(array, j, j + 1);
    		}	
    	}
    }
    
	public static void main(String[] args) {
		int[] array = new int[10];
		System.out.println("Введите массив для сортировки");
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < array.length; i++)
			array[i] = in.nextInt();
		in.close();
		sort(array);
		System.out.println("Отсортированный массив ");
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
	}
}
