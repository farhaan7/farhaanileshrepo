package myTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest {

	
	@Test
	public void sum()
	{
		System.out.println("add");
		int a=10;
		int b=20;
		Assert.assertEquals(30, a+b);
	}
	@Test
	public void sub()
	{
		System.out.println("sub");
		int a=10;
		int b=20;
		Assert.assertEquals(10, b-a);
	}
	@Test
	public void multiply()
	{
		System.out.println("mul");
		int a=10;
		int b=20;
		Assert.assertEquals(200, a*b);
	}
	@Test
	public void div()
	{
		System.out.println("div");
		int a=10;
		int b=20;
		Assert.assertEquals(2, b/a);
	}
}
