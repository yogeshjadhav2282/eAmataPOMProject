package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReport {
    static ExtentTest test;
    public static ExtentReports extent;


    public static ExtentTest Extent() {
        // Set up ExtentReports and attach a reporter
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("C:/Users/LNV-24/IdeaProjects/eAmataPOMFramework/src/test/resources/reports/report.html");

        sparkReporter.config().setDocumentTitle("Eamata Automation Test Report");
        sparkReporter.config().setReportName("Eamata Test Report");
        sparkReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        test = extent.createTest("Eamata Test Report", "A simple Eamata Test Report to demonstrate the functionality");
        test.info("Starting Test");
        return test;

    }



}
