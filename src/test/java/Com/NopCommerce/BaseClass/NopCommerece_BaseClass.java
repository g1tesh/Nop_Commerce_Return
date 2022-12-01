package Com.NopCommerce.BaseClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class NopCommerece_BaseClass {
	
	public static  WebDriver driver;
	public ResourceBundle rb;
	public static Logger logger;
	
	@BeforeClass
	public void setup()
	{
		logger = LogManager.getLogger(this.getClass());
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		logger.info("Opening Demo.NopCommerece website");
		ResourceBundle rb = ResourceBundle.getBundle("config");
		
		
		
	}

	@AfterClass
	public void TearDown() throws InterruptedException
	{
		Thread.sleep(4000);
		driver.quit();
	}
	
	
	public void GetScreenShot() throws IOException
	{
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		 Date date = new Date();
		 String screenshotName =  sdf.format(date);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		//File trg = new File(System.getProperty(".\\Screenshots\\"+screenshotName+".png"));
		File trg = new File(System.getProperty("user.dir")+"\\Screenshots\\FailedScreenshot--"+screenshotName+".png");
		org.apache.commons.io.FileUtils.copyFile(scr, trg);

	}
	
	public void GetRandomString()
	{
		String RandomString = RandomStringUtils.randomAlphabetic(5);
	}
}
