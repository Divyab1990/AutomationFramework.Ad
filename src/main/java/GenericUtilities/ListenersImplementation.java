package GenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListeners Interface of TestNG
 */
public class ListenersImplementation implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		
		//for every @Test = Test Method
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"---------Test Execution Starts-------");
		
		//Intimation of Test execution to extent reports
		test= report.createTest(methodname);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		//for every @Test is passed
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"---------Test  Passed-------");
		
		//Log the test status as PASS
		test.log(Status.PASS, methodname+"---------Test  Passed-------");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		//for every @Test is failed
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"--------Test failed------");
		
		//print the exception for failure
		System.out.println(result.getThrowable());
		
		//Log the test Status as fail in Extent Reports
		test.log(Status.FAIL,methodname+"--------Test failed------");
		test.log(Status.INFO, result.getThrowable());
		
		//for capturing the screenshot
		SeleniumUtility s = new SeleniumUtility();
		JavaUtility j = new JavaUtility();
		
		String screenshotName = methodname+"-"+j.getsystemdate();
		
		try 
		{
			String path = s.capturescreenshot(Baseclass.sdriver, screenshotName);
			
			//attach screenshot to extent reports
			test.addScreenCaptureFromPath(path);
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		//for @test is skipped
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"--------Test skipped------");
		
		//print the exception for failure
		System.out.println(result.getThrowable());	
		
		//Log the test status as Skip in Extent Reports
		test.log(Status.SKIP, methodname+"--------Test skipped------");
		test.log(Status.INFO, result.getThrowable());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		System.out.println("---------suite Execution Started-------");
		
		//Basic Coonfiguration of Extent Reports
		ExtentSparkReporter htmlRep = new ExtentSparkReporter(".\\ExtentReports\\Report-"+ new JavaUtility().getsystemdate()+".html");
		htmlRep.config().setDocumentTitle("Execution Report");
		htmlRep.config().setTheme(Theme.DARK);
		htmlRep.config().setReportName("Vtiger Execution Report");
		
		//Set System info inside extent Reports
		report= new ExtentReports();
		report.attachReporter(htmlRep);
		report.setSystemInfo("Base Platform", "windows");
		report.setSystemInfo("Base Browser", "Edge");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Reporter name", "Chaitra");
	}

	@Override
	public void onFinish(ITestContext context) {
		
		System.out.println("---------suite Execution Finished-------");
		
		//Generate Extent Report
		report.flush();
		
	}
	
	

}
