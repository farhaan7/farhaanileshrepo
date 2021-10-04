package myTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Extent_report {
	public static ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./Reports/extent.html");
	public static ExtentReports extent = new ExtentReports();
	public static ExtentTest logger1,logger2,logger3,logger4,logger5;
	WebDriver wd;
	
	@BeforeSuite
	public void setup() throws InterruptedException
	{
		extent.attachReporter(htmlReporter);
		logger1=extent.createTest("Browser");
		logger2=extent.createTest("Title Verification Test");
		logger3=extent.createTest("LoginTest");
		logger4=extent.createTest("Teardown");
		logger5=extent.createTest("demo");
		WebDriverManager.chromedriver().setup();
	//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		wd=new ChromeDriver();
		wd.get("http://automationpractice.com/index.php");
		Thread.sleep(5000);
		logger1.log(Status.PASS, "Website launch successfully");
		wd.manage().window().maximize();
		logger1.log(Status.PASS, "window got maximize successfully");
		Thread.sleep(3000);
	}
	
	@Test(priority=1)
	public void titleverification_Test()
	{
		String actualtitle="My Store1";
		Assert.assertEquals(wd.getTitle(), actualtitle);
		System.out.println("Title is:- "+wd.getTitle());
		logger2.log(Status.PASS, "Title is verified of Mytsore");
	}
	
	@Parameters({"username","password"})
	@Test(priority=2)
	public void login(String username, String password) throws InterruptedException
	{
		wd.findElement(By.xpath("//div[@class='header_user_info']//a")).click();
		Thread.sleep(5000);
		wd.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
		Thread.sleep(1000);
		logger3.log(Status.PASS, "Username got entered successfully");

		wd.findElement(By.xpath("//input[@name='passwd']")).sendKeys(password);
		Thread.sleep(1000);
		logger3.log(Status.PASS, "Password got entered successully");

		wd.findElement(By.xpath("//button[@name='SubmitLogin']")).click();
		Thread.sleep(1000);
		System.out.println("Signin done successfully");
		logger3.log(Status.PASS, "Signin done successfully");
		Thread.sleep(6000);
	}


	@AfterSuite
	public void teardown()
	{
		wd.close();
		logger4.log(Status.PASS, "Website is closed successfully");
		logger5.log(Status.PASS, "This is for demo test");
		extent.flush();
	}

}