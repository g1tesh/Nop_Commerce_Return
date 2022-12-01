package Com.NopCommerece.PageObj;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.NopCommerce.BaseClass.NopCommerece_BaseClass;

public class Nop_Commerce_Search extends NopCommerece_BaseClass {
	
	public Nop_Commerce_Search()
	{
		PageFactory.initElements(driver, this);
	}
	
	//@PageFactory
	
	@FindBy(xpath = "//input[@type = 'text']")
	WebElement search;
	
	@FindBy(xpath = "//ul[@id = 'ui-id-1']//li")
	List<WebElement> suggestion;
	
	@FindBy(xpath = "//a[@class = 'ui-menu-item-wrapper']/span[text() = 'Apple iCam']")
	WebElement seachclick;
	
	
	@FindBy(xpath = "//img[@alt = 'Picture of Apple MacBook Pro 13-inch']")
	List<WebElement> appleimg;
	
	@FindBy(xpath = "//button[@id = 'add-to-wishlist-button-4']")
	WebElement wishaddclick;
	
	@FindBy(xpath = "//span[text() = 'Wishlist']")
	WebElement clickonWishButton;
	
	@FindBy(xpath = "//span[@id = 'stock-availability-value-17']")
	WebElement availability;
	
	//Action class
	
	public void SearchItems(String entersearch)
	{
		search.sendKeys(entersearch);
		
	}
	
	public int suggestionsize()
	{
		return suggestion.size();
	}
	
	public int clickOnSearch()
	{
		seachclick.click();
		int imgcount = appleimg.size(); 
		return imgcount;
	}
	public String SeachItemName()
	{
		return seachclick.getText();
	}
	
	public void clickOnaddWishList()
	{
		if(availability.getText()!="Out of stock")
		{
			wishaddclick.click();
		}
		else
		{
			System.out.println("Unable to add in Wishlist as it is Out of stock");
		}
		
	}
	
	public void clickOnWishList()
	{
		
		clickonWishButton.click();
	}
	
	
	
	

}
