package myTests;

import java.io.IOException;

import org.testng.annotations.Test;

public class dataprovider_using_propertyfile extends baseclass {

	@Test
	public void employee() throws IOException
	{
	        System.out.println("Employee Firstname is - " + getobject("firstname"));
	        System.out.println("Employee  Lastname is - " + getobject("lastname"));
	     
		
	    }
	
}
