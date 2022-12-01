package Com.NopCommerece.PageObj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.NopCommerce.BaseClass.NopCommerece_BaseClass;

public class Nop_Commerce_WishList extends NopCommerece_BaseClass {
	
	
	public Nop_Commerce_WishList()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class = 'product-name']")
	WebElement Wishlistitems;
	

	
	
	
	
	
	public String WishListItemName()
	{
		return Wishlistitems.getText();
	}
	

}
