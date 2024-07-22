package listeners_Practice;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Test_Listener implements ITestListener {
	
	static ChromeDriver driver;

	@Override
	public void onTestStart(ITestResult result) {
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ITestListener.super.onTestSuccess(result);
		Reporter.log("Test case pass");
		TakesScreenshot ss = driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\MADHURI AVHAD\\Pictures\\TestingScreenshots\\Pass\\".concat(driver.getClass().getName())+"_".concat(dateTimeStamp())+".jpg");
		try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Override
	public void onTestFailure(ITestResult result) {
		ITestListener.super.onTestFailure(result);
		Reporter.log("Test case fail");
		TakesScreenshot ss = driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\MADHURI AVHAD\\Pictures\\TestingScreenshots\\Fail\\TestCaseFail".concat(dateTimeStamp())+".jpg");
		try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		ITestListener.super.onFinish(context);
	}
	
	public static String dateTimeStamp()
	{
		Date d = new Date();
		String dt = d.toString();
//		Wed Jun 05 14:21:58 IST 2024
		String date = dt.substring(8, 10);
		String month = dt.substring(4, 7);
		String year = dt.substring(24, dt.length());
		String hr = dt.substring(11, 13);
		String mt = dt.substring(14, 16);
		String sec = dt.substring(17, 19);
		
		return date+month+year+hr+mt+sec;
	}


}