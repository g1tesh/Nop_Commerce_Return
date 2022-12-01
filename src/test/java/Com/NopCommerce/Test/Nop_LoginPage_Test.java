package Com.NopCommerce.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.NopCommerce.BaseClass.NopCommerece_BaseClass;
import Com.NopCommerce.Utilities.XLSManagerutility;
import Com.NopCommerece.PageObj.Nop_Commerece_Login;

public class Nop_LoginPage_Test extends NopCommerece_BaseClass {
	
	public Nop_Commerece_Login login;
	public XLSManagerutility xls;
	
	@BeforeMethod()
	public void prerequisites()
	{
		login = new Nop_Commerece_Login();
		login.ClickOnHomePageLogin();
	}
	
	@Test(dataProvider = "LoginData", priority = 0)
	public void TestLogin(String email, String Password, String exp) throws IOException, InterruptedException
	{
		login = new Nop_Commerece_Login();
		
		login.EnterUserPassword(email, Password);
		
		login.ClickOnSubmitLogin();
		Thread.sleep(1000);
		System.out.println("------"+exp);
		//System.out.println("Status of logout: " +login.CheckLogout());
		
		
		if(exp.equals("Valid"))
		{
		
			logger.info("Login was successfull");
			Assert.assertEquals(login.CheckLogout(),true);
			System.out.println("Status again :"+login.CheckLogout());
			login.ClickOnLogout();
			logger.info("Clicked on Logout");
			logger.info("Details Valid and logout is true");
			
		
		}
		else if(exp.equals("Invalid"))
		{
			System.out.println("Status in else if -- ");
			Assert.assertEquals(true, true);
			logger.info("Details Invalid and logout is false");
		}
		else
		{
			logger.info("Calling screenShot");
			GetScreenShot();
			//Assert.assertTrue(false,"Login Failed");
		}
		
	}
	@DataProvider(name = "LoginData")
	public String[][] ReadXLSData() throws IOException
	{
		xls = new XLSManagerutility();
		int rows = xls.GetRowCount(".//TestData//Test_Login_Data.xlsx", "Sheet1");
		int cols = xls.GetColCount(".//TestData//Test_Login_Data.xlsx", "Sheet1");
		String data[][] = new String[rows][cols];
		for(int i = 1; i<=rows; i++)
		{
			for(int j = 0; j<cols; j++ )
			{
				 data[i-1][j] = xls.GetXLSData(".//TestData//Test_Login_Data.xlsx", "Sheet1", i, j);
			}
		}
		System.out.println(data);
		return data;
		
	}
	
	
	@Test(priority = 1)
	public void WrongEmailTest()
	{
		
		login.EnterUserPassword("Gitesh", "");
		
		Assert.assertEquals(login.WrongEmail(), true);
		
	}
	
	@Test(priority = 3)
	public void validlogin()
	{
		login.EnterUserPassword("Admin1@gmail.com", "Talent_123");
		login.ClickOnSubmitLogin();
		Assert.assertEquals(login.CheckLogout(),true);
		
		
	}
	
	
	


}
