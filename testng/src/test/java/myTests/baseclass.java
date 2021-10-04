package myTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;




public class baseclass 
{
	 static Properties prop;
		

		public static void load_property_file() throws IOException
		{
			
	     prop=new Properties();
	     
	     try {
		InputStream input=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		prop.load(input);

	     } catch (FileNotFoundException e) {
		
		e.printStackTrace();//
	     }
		}
		
		public static String getobject(String Data) throws IOException
		{
			load_property_file();
			String data= prop.getProperty(Data);
			return data;
		}
}