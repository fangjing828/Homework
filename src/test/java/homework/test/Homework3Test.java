package homework.test;

import homework.Homework3;

import org.junit.*;
public class Homework3Test {
	@Test
	public void testSmooth() {
		int[] test1 = {3, 7, 7, 7, 4, 5, 5, 2, 0, 8, 8, 8, 8, 5};
		Homework3.smoosh(test1);
	    Assert.assertEquals("[  3  7  4  5  2  0  8  5  -1  -1  -1  -1  -1  -1  ]", Homework3.stringInts(test1));
	    int[] test2 = {3, 7, 7, 7, 4, 5, 5, 2, 0, 8, 8, 8, 8, 5};
	    Homework3.smoosh(test2);
	    Homework3.smoosh(test2);
	    Assert.assertEquals("[  3  7  4  5  2  0  8  5  -1  -1  -1  -1  -1  -1  ]", Homework3.stringInts(test2));
	}
}
