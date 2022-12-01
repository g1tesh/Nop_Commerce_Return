package Com.NopCommerce.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.NopCommerce.BaseClass.NopCommerece_BaseClass;
import Com.NopCommerece.PageObj.Nop_Commerece_HomePage;
import Com.NopCommerece.PageObj.Nop_Commerece_Registration;

public class Nop_Registration_Test extends NopCommerece_BaseClass {
	
	public Nop_Commerece_HomePage homepage;
	public Nop_Commerece_Registration registration;
	
	@BeforeMethod
	public void GotoRegistration()
	{
		homepage = new Nop_Commerece_HomePage();
		homepage.ClickOnRegister();
	}
	
	@Test
	public void FillRegistration() throws IOException
	{
		registration = new Nop_Commerece_Registration();
		registration.SendFirstName("Admin");
		registration.SendLastName("Admin");
		registration.SelectDate();
		registration.SendEmail("Admin1@gmail.com");
		registration.SendCompany("Admin");
		registration.SendPasswords("Talent123", "Talent123");	
		registration.ClickOnRegisterbutton();
		
		
			logger.info("Going for screenshot");
			GetScreenShot();
			System.out.println("Screenshot called");
			logger.info("Screenshotcalled");
			Assert.assertEquals(registration.Confirmationmessage(), "Your registration completed");
		

	}
	

	

}
