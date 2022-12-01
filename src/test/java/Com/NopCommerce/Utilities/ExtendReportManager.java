package Com.NopCommerce.Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReportManager implements ITestListener {
	
	ExtentSparkReporter spark;
	ExtentReports reports;
	ExtentTest test;
	

	
	 public void onStart(ITestContext context)
	{
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		 
		 Date date = new Date();
		 String currentdate =  sdf.format(date);
		 
		String ReportName = "TestReport-"+currentdate+".html";
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/"+ReportName);
		spark.config().setDocumentTitle("NopCommerce_Report");
		spark.config().setReportName("Nop_Commerece_functional_Test");
		spark.config().setTheme(Theme.DARK);
		
		reports = new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("ApplicationName", "NopCommerce");
		reports.setSystemInfo("ModuleName", "Ecommerece");
		reports.setSystemInfo("MachineName", System.getProperty("os.name"));
		reports.setSystemInfo("UserName", System.getProperty("user.name"));
		reports.setSystemInfo("QaName", "Gitesh Patil");
	}
	 
	 public void onTestSuccess(ITestResult result)
	 {
		 test = reports.createTest(result.getName());
		 test.log(Status.PASS, "Test Passed");
		 
	 }
	 
	 public void onTestFailure(ITestResult result)
	 {
		 Random random = new Random();
		 String screenshotName = ""+random.nextInt(10);
		 test = reports.createTest(result.getName());
		 try {
			 test.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\Screenshots\\FailedScreenshot--"+screenshotName+".png");

			 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
			 System.out.println("catch");
		 }
		 
		 test.log(Status.FAIL, "Test is failed"+result.getThrowable().getMessage());
		 
	 }
	 
	 public void onTestSkip(ITestResult result)
	 {
		 test = reports.createTest(result.getName());
		 test.log(Status.SKIP, result.getThrowable().getMessage());
	 }
	
	 public void onFinish(ITestContext context)
	 {
		 reports.flush();
	 }

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	

}
