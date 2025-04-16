package pages;

import baseTest.baseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ConfigReader;

import java.time.Duration;
import java.util.Objects;

public class loginPage extends baseClass {
    static WebElement ele;

    static String username = "email";
    static String password = "password";
    static String loginButton = "//button[text()='Login']";
    String gettext = "//div/header//div/a[1]/span[text()='Provider Groups']";
    static String errorMessage = "//*[@id='root']//div/span[contains(text(), 'Cannot find user with emailId')]";
    String noEmailErrorMessage = "//form//div/span[text()= 'Email is required']";
    String noPasswordErrorMessage = "//form//div/span[text()= 'Password is required']";

    public static void enterEmail(String Email) {
        test.info("Entering user email in the username textfield");
        findByName(username).sendKeys(Email);
        test.pass("Entered user email successfully");

    }

    public static void enterPassword(String Password) {
        test.info("entering password in the password field");
        findByName(password).sendKeys(Password);
        test.pass("Entered user password successfully");

    }

    public static void clickLoginButton() throws InterruptedException {
        test.info("clicking on the login button");
        findByXpath(loginButton).click();
        test.pass("clicked on the login button");
        Thread.sleep(3000);

    }

    public String getGettext() {
        test.info("verifying user is logged in!....");
        ele = findByXpath(gettext,true);
        test.pass("User logged in Successfully");

        return ele.getText();
    }

    public static String getErrorMessage() {
        test.info("Verifying email is present in the system");
        ele = findByXpath(errorMessage);

        if(Objects.isNull(ele.getText())){
            test.fail("The entered email is exist");
        }
        else {
            test.pass("Entered Email verified successfully");
        }

        return ele.getText();
    }

    public String NoEmailMessage() {
        test.info("verifying error message for no email entered");
        ele = findByXpath(noEmailErrorMessage);

        if(Objects.isNull(ele.getText())){
            test.fail("The error message for no email is not displayed");
        }
        else {
            test.pass("The error message for no Email is displayed successfully");
        }

        return ele.getText();
    }

    public String NoPasswordMessage() {
        test.info("Verifying Password is not enter in the field");
        ele = findByXpath(noPasswordErrorMessage);

        if(Objects.isNull(ele.getText())){
            test.fail("The error message for no password is not displayed");
        }
        else {
            test.pass("The error message for no password is displayed successfully");
        }
        return ele.getText();
    }

    public static void loginUser(String url, String email, String password) throws InterruptedException {
        test.info("Navigating user to the portal");
        openUrl(url);
        test.pass("Navigated user to the web portal successfully");
        test.info("Loggin user by entering username and password");
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
        Thread.sleep(timeout);
        test.pass("Verified the logged in process successfully");

    }

}
