package Com.NopCommerece.PageObj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Com.NopCommerce.BaseClass.NopCommerece_BaseClass;

public class Nop_Commerece_Registration extends NopCommerece_BaseClass {
	
	public Nop_Commerece_Registration()
	{
		System.out.println("Starting registation Page");
		PageFactory.initElements(driver	,this);
		
	}
	
	//Page Factory
	
	
	@FindBy(xpath = "//input[@name = 'FirstName']")
	WebElement firstname;
	
	@FindBy(xpath = "//input[@name = 'LastName']")
	WebElement lastname;
	
	@FindBy(xpath = "//select[@name = 'DateOfBirthDay']")
	WebElement day;
	
	@FindBy(xpath = "//select[@name = 'DateOfBirthMonth']")
	WebElement month;
	
	@FindBy(xpath = "//select[@name = 'DateOfBirthYear']")
	WebElement year;
	
	@FindBy(id = "Email")
	WebElement email;
	
	@FindBy(id = "Company")
	WebElement company;
	
	
	@FindBy(id = "Password")
	WebElement password;
	
	@FindBy(id = "ConfirmPassword")
	WebElement confirmpassword;
	
	@FindBy(id = "register-button")
	WebElement registerbutton;
	
	@FindBy(xpath = "//div[text() = 'Your registration completed']")
	WebElement registrationconfirmation;

	
	//Actions
	
	public void SendFirstName(String FirstName)
	{
		firstname.sendKeys(FirstName);
		
	}
	public void SendLastName(String LastName)
	{
		lastname.sendKeys(LastName);
	}
	
	public void SelectDate()
	{
		Select select = new Select(day);
		select.selectByVisibleText("25");
		select = new Select(month);
		select.selectByVisibleText("July");
		select = new Select(year);
		select.selectByVisibleText("1992");
	}
	
	public void SendEmail(String Email) {
		
		email.sendKeys(Email);
	}
	
	public void SendCompany(String Company)
	{
		company.sendKeys(Company);
	}
	
	public void SendPasswords(String Password, String ConfirmPassword)
	{
		password.sendKeys(Password);
		confirmpassword.sendKeys(ConfirmPassword);
	}
	public void ClickOnRegisterbutton()
	{
		registerbutton.click();
	}
	public String Confirmationmessage()
	{
		return registrationconfirmation.getText();
	}
	
	

}
