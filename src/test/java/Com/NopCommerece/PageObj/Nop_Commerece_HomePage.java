package Com.NopCommerece.PageObj;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Com.NopCommerce.BaseClass.NopCommerece_BaseClass;

public class Nop_Commerece_HomePage extends NopCommerece_BaseClass {
	

	public Nop_Commerece_HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory
	
	@FindBy(xpath = "//img[@alt = 'nopCommerce demo store']")
	WebElement logo;
	
	@FindBy(xpath = "//a[text() = 'Register']")
	WebElement Register;
	
	//Action
	public boolean Validatelogovisibility()
	{
		System.out.println("In POM home page");
		boolean image = logo.isDisplayed();
		return image;
	}
	
	public void ClickOnRegister()
	{
		Register.click();
	}
}
