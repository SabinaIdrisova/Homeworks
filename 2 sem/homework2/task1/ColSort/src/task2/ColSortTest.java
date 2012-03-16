package task2;

import org.junit.*;

public class ColSortTest {

	@Test
	public void testSwap() {
		int[][] array = {{2, 1}, {0, 4}};
		int i = 0;
		int j = 1;
		int k = 1;
		int[][] resArray = {{2, 1}, {4, 0}};
		ColSort.swap(array, i, j, k);
		Assert.assertArrayEquals(resArray, array);
	}

	
	@Test
	public void testSort() {
		int[][] array = {{2, 1}, {0, 4}};
		int[][] resArray = {{1, 2}, {4, 0}};
		ColSort.sort(array);
		Assert.assertArrayEquals(resArray, array);
	}
}
