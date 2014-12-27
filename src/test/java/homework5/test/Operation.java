package homework5.test;
import org.junit.*;
public class Operation {
	@Test
	public void testMod() {
		int mod = 5;
		Assert.assertEquals(true, mod % mod == 0);
		Assert.assertEquals(true, - mod % mod >= 0);
		
		mod = -5;
		
		Assert.assertEquals(true, mod % mod == 0);
		Assert.assertEquals(true, - mod % mod >= 0);
	}
}
