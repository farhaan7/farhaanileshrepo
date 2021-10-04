package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;


public class LoginPage extends VerifyLogin
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(linkText="Sign in") 
	WebElement linkText;
	
	@FindBy(xpath="//input[@id='email']") 
	WebElement username;
	
	@FindBy(xpath="//input[@id='passwd']") 
	WebElement password;
	
	@FindBy(xpath="//i[@class='icon-lock left']") 
	WebElement login_button;


public void login(String userid,String pass)
{
	linkText.click();
	username.sendKeys(userid);
	logger2.log(Status.PASS, "Username got entered successfully");
	password.sendKeys(pass);
	logger2.log(Status.PASS, "Password got entered successully");
	login_button.click();
	logger3.log(Status.PASS, "Signin done successfully");	
}
}