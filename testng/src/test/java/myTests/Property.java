package myTests;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Property {

	public static void main(String[] args) throws IOException {

		WebDriver driver = null;
		//how to read propeties file:
		Properties prop = new Properties();
		InputStream input=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		prop.load(input);
		
		System.out.println(prop.getProperty("browser"));
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equals("FF")){
			driver = new FirefoxDriver();
		}
		
		  driver.get(prop.getProperty("url"));
		  driver.manage().window().maximize(); driver.manage().deleteAllCookies();
		  driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.xpath(prop.getProperty("user_name"))).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath(prop.getProperty("password_name"))).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath(prop.getProperty("login_button"))).click();
			
	}

}