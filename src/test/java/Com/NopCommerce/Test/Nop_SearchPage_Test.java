package Com.NopCommerce.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.NopCommerce.BaseClass.NopCommerece_BaseClass;
import Com.NopCommerece.PageObj.Nop_Commerce_Search;


public class Nop_SearchPage_Test  extends NopCommerece_BaseClass{
	
	
	Nop_Commerce_Search nopsearch;
	
	@BeforeMethod
	public void setupsearch()
	{
		
		nopsearch = new Nop_Commerce_Search();
	}
	
	@Test(priority = 0)
	public void seachvalidation()
	{
		nopsearch.SearchItems("Apple");
		int num = nopsearch.suggestionsize();
		System.out.println(num);
		boolean flag = false;
		if(num>0)
		{
			flag = true;
		}
		else
		{
			flag = false;
		}
		Assert.assertEquals(flag, true);
		
	}
	@Test(priority = 1)
	public void TestClickonSearch()
	{
		int resultsearch = nopsearch.clickOnSearch();
		Assert.assertEquals(resultsearch,3);
	}
	
	
	
	
	

}
