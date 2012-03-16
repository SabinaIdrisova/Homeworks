package hw2;

import org.junit.*;

public class SpiralTest {

	@Test
	public void testSpiral() {
		int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[] resArray = {5, 4, 7, 8, 9, 6, 3, 2, 1};
		int[] result = new int[9];
		Spiral.spiral(array, 3, result);
		Assert.assertArrayEquals(resArray, result);
	}
}
