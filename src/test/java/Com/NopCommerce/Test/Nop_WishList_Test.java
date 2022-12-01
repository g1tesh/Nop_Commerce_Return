package Com.NopCommerce.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.NopCommerce.BaseClass.NopCommerece_BaseClass;
import Com.NopCommerece.PageObj.Nop_Commerce_Search;
import Com.NopCommerece.PageObj.Nop_Commerce_WishList;

public class Nop_WishList_Test extends NopCommerece_BaseClass {
	
	
	
	
	Nop_Commerce_Search np;
	Nop_Commerce_WishList wish;
	
	@BeforeMethod
	public void setupwish()
	{
		np = new Nop_Commerce_Search();
		wish = new Nop_Commerce_WishList();
		np.SearchItems("Apple");
		
	}
	
	@Test
	public void CheckWishListItems()
	{
		String searchItem = np.SeachItemName();
		System.out.println("Items Searched : "+searchItem);
		np.clickOnSearch();
		np.clickOnaddWishList();
		np.clickOnWishList();
		String wishListItemName = wish.WishListItemName();
		System.out.println("WishListItem : "+wishListItemName);
		
		Assert.assertEquals(searchItem, wishListItemName);
	}
	

}
