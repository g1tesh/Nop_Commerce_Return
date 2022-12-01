package Com.NopCommerce.Utilities;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extend_Report implements ITestListener
{
	ExtentSparkReporter spark;
	ExtentReports report;
	ExtentTest test;
	
	

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		test = report.createTest(result.getName());
		test.log(Status.PASS, "passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		test = report.createTest(result.getName());
		test.log(Status.FAIL, "failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		spark = new ExtentSparkReporter(".\\Reports\\name.html");
		
		spark.config().setDocumentTitle("kuch bhi");
		spark.config().setReportName("123");
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		
		report.attachReporter(spark);
		
		report.setSystemInfo("Tester Name", "Gitesh");
		report.setSystemInfo("OS", "os.name");
		report.setSystemInfo("Username", "user.name");
		
		
		
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		report.flush();
		
	}

}
