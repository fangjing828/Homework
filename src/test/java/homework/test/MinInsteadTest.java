package homework.test;
import homework.MinInstead;

import org.junit.*;

public class MinInsteadTest {
	@Test
	public void testMinInstead() {
		int[] arr1 = {1,7,2,20,22};
		Assert.assertEquals(1, MinInstead.minInstead(arr1));
		int[] arr2 = {4, 10, 20};
		Assert.assertEquals(0, MinInstead.minInstead(arr2));
		
		int[] arr3 ={20, 11, 12, 13, 14, 0};
		Assert.assertEquals(2, MinInstead.minInstead(arr3));
		
		int[] arr4 ={5, 4, 3, 2, 1};
		Assert.assertEquals(4, MinInstead.minInstead(arr4));
		int[] arr5 ={1, 2, 3, 4, 5};
		Assert.assertEquals(0, MinInstead.minInstead(arr5));
		
		int[] arr6 ={4, 3, 2, 1, 5};
		Assert.assertEquals(3, MinInstead.minInstead(arr6));
		
		int[] arr7 ={3, 4, 2, 1, 5};
		Assert.assertEquals(2, MinInstead.minInstead(arr7));
	}
}
