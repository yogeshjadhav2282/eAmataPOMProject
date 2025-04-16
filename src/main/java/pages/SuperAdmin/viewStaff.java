package pages.SuperAdmin;

import baseTest.baseClass;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class viewStaff extends baseClass {
    private static final Logger log = LoggerFactory.getLogger(viewStaff.class);

    static String PatientFirstName = "//span[text()='"; static String PatientLastname = "']/parent::a";
    static String getFirstName = "//span[text()='First Name']/following-sibling::span";
    static String getLastName = "//span[text()='Last Name']/following-sibling::span";
    static String getEmail = "//span[text()='Email']/following-sibling::span";
    static String getPhone = "//span[text()='Phone']/following-sibling::span";
    static String getRole = "//span[text()='Role']/following-sibling::span";
    static String getGender = "//span[text()='Gender']/following-sibling::span";
    static String getLine1 = "//span[text()='Line 1']/following-sibling::span";
    static String getLine2 = "//span[text()='Line 2']/following-sibling::span";
    static String getState = "//span[text()='State']/following-sibling::span";
    static String getCity = "//span[text()='City']/following-sibling::span";
    static String getCountry = "//span[text()='Country']/following-sibling::span";
    static String getZipCode = "//span[text()='Zip Code']/following-sibling::span";


    public static void clickOnThePatientName(String firstname, String lastaname) throws InterruptedException {
        test.info("clicking on the patient name");
        findByXpath(PatientFirstName+ firstname+" "+lastaname+PatientLastname).click();
        Thread.sleep(timeout);
        test.pass("view patient page is opened after clicking on the patient name");

    }

    public static String verifyFirstName(){
        String firstName = findByXpath(getFirstName).getText();
        log.info(firstName);
        return firstName;
    }

    public static String verifyLastName(){
        String LastName = findByXpath(getLastName).getText();
        log.info(LastName);
        return LastName;
    }

    public static String verifyEmail(){
        return findByXpath(getEmail).getText();

    }

    public static String verifyPhone(){
        return findByXpath(getPhone).getText();

    }

    public static String verifyRole(){
        return findByXpath(getRole).getText();

    }

    public static String verifyGender(){
        return findByXpath(getGender).getText();

    }

    public static String verifyAddressLine1(){
        return findByXpath(getLine1).getText();

    }

    public static String verifyAddressLine2(){
         return findByXpath(getLine2).getText();

    }

    public static String verifyCity(){
        return findByXpath(getCity).getText();

    }

    public static String verifyZipCode(){
        return findByXpath(getZipCode).getText();

    }

    public static String verifyState(){
        return findByXpath(getState).getText();

    }

    public static String verifyCountry(){
        return findByXpath(getCountry).getText();

    }
}
