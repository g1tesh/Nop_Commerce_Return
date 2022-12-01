package Com.NopCommerce.Test;

import org.testng.Assert;

import org.testng.annotations.Test;

import Com.NopCommerce.BaseClass.NopCommerece_BaseClass;
import Com.NopCommerece.PageObj.Nop_Commerece_HomePage;

public class Nop_HomePage_Test extends NopCommerece_BaseClass  {
	
	Nop_Commerece_HomePage homepage;
	
	@Test
	public void validatetitle()
	{
		//System.out.println(driver.getTitle());
		
		System.out.println("In test Method");
		homepage = new Nop_Commerece_HomePage();
		//System.out.println(homepage.Validatelogovisibility());
		logger.info(homepage.Validatelogovisibility()+" Returning logo visibility");
		
		Assert.assertTrue(homepage.Validatelogovisibility());
		
		
		
	}

}
