package myTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TestngDemo 
{

	WebDriver driver;
	//parallel testing using two browsers
	@Parameters("browser")
	@BeforeTest
	public void setup(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\user\\Downloads\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		/*	WebDriverManager.firefoxdriver().setup();
		WebDriverManager.operadriver().setup();
		WebDriverManager.phantomjs().setup();
		WebDriverManager.edgedriver().setup();
		WebDriverManager.iedriver().setup(); */
		//WebDriverManager.chromedriver().browserVersion("").setup();is used to run on specific browser version!!!!!
		// shortcut to launch browsers,easy to maintain



		driver.manage().window().maximize(); driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://automationpractice.com/index.php");
	}

	@Test(priority=1)
	public void gettitle()
	{
		String title = driver.getTitle();
		Assert.assertEquals(title, "My Store");
		System.out.println(title);
	}

	@Parameters({"username","password"})
	@Test(priority=2)
	public void login(String username, String password)
	{
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(password);
		driver.findElement(By.xpath("//i[@class='icon-lock left']")).click();

	}

	@Test(priority=3)
	public void printtop()
	{
		String text = driver.findElement(By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']")).getText();
		System.out.println(text);
	}

	@AfterTest
	public void close()
	{
		driver.quit();
	}
}
