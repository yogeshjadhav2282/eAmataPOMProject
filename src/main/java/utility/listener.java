package utility;

import baseTest.baseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static baseTest.baseClass.test;

public class listener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Start test : " + result.getName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test is successfully done : " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test is failed : " + result.getMethod().getMethodName());

//        Object testInstance = result.getInstance();
//        WebDriver driver = ((baseClass) testInstance).getDriver(); // Ensure BaseTest has getDriver()
//
//        String screenshotPath = screenshot.captureScreenshot(driver, result.getName());
//        test.fail("Screenshot of failure:").addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test is skipped : " + result.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Failed test cases details are : " + result.getName());
    }


}
