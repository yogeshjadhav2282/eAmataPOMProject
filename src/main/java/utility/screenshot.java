package utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class screenshot {
    public static String captureScreenshot(WebDriver driver, String testName) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = formatter.format(new Date());
        String screenshotPath = "./screenshots/" + testName + "_" + timestamp + ".png";

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File(screenshotPath);

        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotPath;
    }

}
