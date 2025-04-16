package pages.SuperAdmin;

import baseTest.baseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.address;
import utility.userDetails;

import java.util.List;
import java.util.Objects;

public class adminStaff extends baseClass {

    static String state = address.getState();
    static String gender = userDetails.getGender();
    public static String role = userDetails.getRole();

    static String clickOnSettings = "//span[text()='Settings']/parent::a";
    static String clickOnAdminUserTab = "//button[text()='Admin Users']";
    static String clickOnAddStaff = "//span[text()='Add Staff']/parent::button";
    static String enterFirstName = "firstName";
    static String enterLastName = "lastName";
    static String enterEmail = "email";
    static String enterPhone = "phone";
    static String clickOnRoleType = "//span[text()='Select Staff Role']/parent::button";
    static String selectRoleFormDropdown = "//span[text()='Select Staff Role']/parent::button/following-sibling::ul/li[text()='" + role + "']";
    static String verifyRoleIsPresent = "//label[text()='Role']//following-sibling::button";
    static String clickOnTheGenderField = "//span[text()='Select Gender']/parent::button";
    static String selectGender = "//span[text()='Select Gender']/parent::button/following-sibling::ul/li[text()='" + gender + "']";
    static String enterAddressLine1 = "address.line1";
    static String enterAddressLine2 = "address.line2";
    static String searchState = "//input[@placeholder='Select State']";
    static String stateOption = "//input[@placeholder='Select State']/parent::div/following-sibling::ul/li[text()='" + state + "']";
    static String enterCity = "address.city";
    //   String enterCountry = By.name(""); // because country is bydefault selected
    static String enterZipCode = "address.zipcode";
    static String clickSaveButton = "//div[@class='MuiBox-root css-lb61rc']//button[text()='Add Staff']";
    public static String tablePath = "//table/tbody/tr";
    public static String getFullName = "//table/tbody/tr[1]/td[1]";

    static String clickAdminStaffUser = "//span[text()='" + role + "']/ancestor::button";


    public static void clickOnTheSettings() {
        findByXpath(clickOnSettings).click();

    }

    public static void clickOnTheAdminUser() {
        findByXpath(clickOnAdminUserTab).click();

    }

    public static void clickOnRoleTypeTab() {
        findByXpath(clickAdminStaffUser).click();

    }

    public static void openAddStaffForm() throws InterruptedException {
        test.info("Opening Add Staff Form");
        findByXpath(clickOnAddStaff).click();
        Thread.sleep(timeout);
        test.pass("Add Staff form is opened");

    }

    public static void firstName(String firstName) throws InterruptedException {
        WebElement ele = findByName(enterFirstName);
        if (ele.getAttribute("value").isEmpty()) {
            ele.sendKeys(firstName);
        } else {
            //ele.clear(); // Try clearing first
            ele.sendKeys(Keys.CONTROL + "a"); // Select all text   // If the field still retains old text, send BACKSPACE multiple times
            ele.sendKeys(Keys.BACK_SPACE);
            Thread.sleep(3000);
            ele.sendKeys(firstName);
            //  Thread.sleep(2000);
        }
    }

    public static void lastName(String lastname) throws InterruptedException {
        WebElement ele = findByName(enterLastName);
        if (ele.getAttribute("value").isEmpty()) {
            ele.sendKeys(lastname);
        } else {
            //ele.clear(); // Try clearing first
            ele.sendKeys(Keys.CONTROL + "a"); // Select all text
            ele.sendKeys(Keys.BACK_SPACE);
            Thread.sleep(3000);
            ele.sendKeys(lastname);
            // Thread.sleep(2000);
        }
    }

    public static void email(String email) throws InterruptedException {
        WebElement ele = findByName(enterEmail);
        if (ele.getAttribute("value").isEmpty()) {
            ele.sendKeys(email);
        }

    }

    public static void PhoneNumber(String phoneNumber) throws InterruptedException {
        WebElement ele = findByName(enterPhone);
        if (ele.getAttribute("value").isEmpty()) {
            ele.sendKeys(phoneNumber);
        } else {
            //ele.clear(); // Try clearing first
            ele.sendKeys(Keys.CONTROL + "a"); // Select all text
            ele.sendKeys(Keys.BACK_SPACE);
            Thread.sleep(timeout);
            ele.sendKeys(phoneNumber);
            // Thread.sleep(timeout);
        }
    }

    public static void roleType(String role) throws InterruptedException {
        WebElement ele = findByXpath(verifyRoleIsPresent);

        if (!ele.getText().equals(role)) {
            findByXpath(clickOnRoleType).click();
            findByXpath(selectRoleFormDropdown, true).click();
        }

    }

    public static void gender(String Gender) {
        WebElement ele = findByXpath("//label[text()='Gender']//following-sibling::button");

        if(!ele.getText().equals(Gender)) {
            findByXpath(clickOnTheGenderField).click();
            findByXpath(selectGender).click();
        }
    }

    public static void address(String line1, String line2, String city, String zipCode) throws InterruptedException {
        test.info("entering address of the user");
        findByName(enterAddressLine1).sendKeys(line1);
        findByName(enterAddressLine2).sendKeys(line2);

        WebElement stateInput = findByXpath(searchState);
        stateInput.click();
        stateInput.sendKeys(state);
        try {
            findByXpath(stateOption, true).click();
        } catch (Exception e) {
            throw new RuntimeException("State does not match please find");
        }

        findByName(enterCity).sendKeys(city);
        //   driver.findElement(enterCountry).sendKeys();
        findByName(enterZipCode).sendKeys(zipCode);
        Thread.sleep(timeout);
        test.pass("Entered user's address successfully");

    }

    public static void clickOnSaveButton() throws InterruptedException {
        test.info("clicking on the save button");
        findByXpath(clickSaveButton).click();
        Thread.sleep(8000);
        test.pass("clicked on the save button");
    }

    public static String getStaff() throws InterruptedException {
        String actualName;

        if (role.equalsIgnoreCase("Super Admin")) {
            test.info("Verifying that the added staff is displayed in the table");
            findByXpath(clickOnAdminUserTab).click();
            driver.navigate().refresh();
            Thread.sleep(2000);
            List<WebElement> rowData = findByXpath(tablePath, "true");
            int rowSize = rowData.size();
            actualName = findByXpath(getFullName).getText();
//            int columnSize = columnData.size();
//            System.out.println("rowSize:" + rowSize + ", columnSize: " + columnSize);
//
//            for (WebElement getData : columnData) {
//                System.out.println(getData.getText());
//            }

        } else if (role.equalsIgnoreCase("Front Desk")) {
            clickOnRoleTypeTab();   // navigate to the partcular staff page
            driver.navigate().refresh();
            Thread.sleep(2000);
            List<WebElement> rowData = findByXpath(tablePath, "true");
            int rowSize = rowData.size();
            actualName = findByXpath(getFullName).getText();
            // int columnSize = columnData.size();
            // System.out.println("rowSize:" + rowSize + ", columnSize: " + columnSize);

//            for (WebElement getData : columnData) {
//                System.out.println(getData.getText());
//            }
        } else {
            throw new RuntimeException("Role not found");
        }
        if (Objects.nonNull(actualName))
            test.pass("Added staff is displayed successfully");
        else
            test.fail("The added staff is not displayed in the list");

        return actualName;
    }

    public static void navigateToAdminStaffPage() throws InterruptedException {
        test.info("Navigating to the Admin User tab");
        clickOnTheSettings();
        clickOnTheAdminUser();
        clickOnRoleTypeTab();
        Thread.sleep(timeout);
        test.pass("Admin User tab is opened successfully");
    }

    public static void enterAdminUserDetails(String fName, String lName, String email, String phoneNumber, String role, String Gender) throws InterruptedException {
        test.info("Entering user's details in the fields");
        firstName(fName);
        lastName(lName);
        email(email);
        PhoneNumber(phoneNumber);
        roleType(role);
        gender(Gender);
        test.pass("Entered User details in the fields");

    }
}
