package myTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions 
{
	
	//hard assertions : hard validation if a hard assertion is getting failed--->immediately test case will be marked as failed
	//and test case will be terminated.
	//soft assertion : soft validation:  if a soft assertion is getting failed--->test case will not be marked as passed as well as
	//next lines will be executed!!
	//assert all() : used to mark the test case as failed,if any soft assertion is getting failed
	SoftAssert softassert = new SoftAssert();
	

	@Test
	public void test1()
	{
		
		SoftAssert softassert1 = new SoftAssert();
		System.out.println("open browser");
		Assert.assertEquals(true, true);
		System.out.println("enter username");
		System.out.println("enter password");
		System.out.println("click on signin button");
		Assert.assertEquals(true, true);
		System.out.println("validate homepage");
		softassert1.assertEquals(true, false,"homepage title is missing");		//soft assertion
		
		System.out.println("go to deals page");
		System.out.println("create a deal");
		softassert1.assertEquals(true, false,"not able to create a deal");
		
		System.out.println("go to contacts page");
		System.out.println("create a contact");
		System.out.println("close browser");
		
		softassert1.assertEquals(true, false,"not able to create contact");
		softassert1.assertAll();
		
	}
	
	
	@Test
	public void test2()
	{
		System.out.println("logout");
		softassert.assertEquals(true, false);//these should faule as true is not equal to false
		//softassert.assertAll(); if these line is not added than this failed test case would be shown as passed.!!	
	}
	
	
}