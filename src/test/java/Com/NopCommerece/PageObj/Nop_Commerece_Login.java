package Com.NopCommerece.PageObj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.NopCommerce.BaseClass.NopCommerece_BaseClass;

public class Nop_Commerece_Login extends NopCommerece_BaseClass {
	
	public Nop_Commerece_Login()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@class = 'email']")
	WebElement emailid;
	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement password;
	
	@FindBy(xpath = "//button[text() = 'Log in']")
	WebElement login;
	
	@FindBy(linkText = "Log in")
	WebElement HomePageLogin;
	
	@FindBy(linkText = "Log out")
	WebElement Logout;
	
	@FindBy(xpath = "//span[text() = 'Wrong email']")
	WebElement wrongemail;
	
	public void ClickOnHomePageLogin()
	{
		HomePageLogin.click();
	}
	
	public void EnterUserPassword(String user, String Password)
	{
		
		
			emailid.sendKeys(user);
		password.sendKeys(Password);
		
	}
	
	public void ClickOnSubmitLogin()
	{
		login.click();
	}
	
	public boolean CheckLogout()
	{
		boolean logoutvalue = Logout.isDisplayed();
		return logoutvalue;
	}
	
	public void ClickOnLogout()
	{
		Logout.click();
	}
	
	public boolean WrongEmail()
	{
		return wrongemail.isDisplayed();
	}
}
