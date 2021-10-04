package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//import helper.Browserfactory;
import io.github.bonigarcia.wdm.WebDriverManager;


public class VerifyLogin 
{
	public static ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./Reports/factory.html");
	public static ExtentReports extent = new ExtentReports();
	public static ExtentTest logger1,logger2,logger3,logger4,logger5;
	static WebDriver driver;

	@BeforeSuite
	public void setup() throws InterruptedException
	{
		extent.attachReporter(htmlReporter);
		logger1=extent.createTest("Browser");
		logger2=extent.createTest("loginTest");
		logger3=extent.createTest("SignInSuccessful");
		logger4=extent.createTest("Teardown");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		logger1.log(Status.PASS, "Website launch successfully");
	}

	@Test
	public void verifyuser()
	{

		LoginPage login_page = PageFactory.initElements(driver, LoginPage.class);
		//call the method
		login_page.login("fkapde@gmail.com", "chatprofile");

	}

	@AfterSuite
	public void teardown()
	{
		driver.close();
		logger4.log(Status.PASS, "Website is closed successfully");

		extent.flush();


	}

}
