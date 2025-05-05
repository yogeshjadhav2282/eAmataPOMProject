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

/**
 * AdminStaff class represents the Admin Staff management page in the application.
 * It contains methods to interact with the Admin Staff page elements and perform actions.
 */
public class adminStaff extends baseClass {
    // Locators
    private static final String SETTINGS_BUTTON = "//span[text()='Settings']/parent::a";
    private static final String ADMIN_USERS_TAB = "//button[text()='Admin Users']";
    private static final String ADD_STAFF_BUTTON = "//span[text()='Add Staff']/parent::button";
    private static final String FIRST_NAME_FIELD = "firstName";
    private static final String LAST_NAME_FIELD = "lastName";
    private static final String EMAIL_FIELD = "email";
    private static final String PHONE_FIELD = "phone";
    private static final String ROLE_DROPDOWN = "//span[text()='Select Staff Role']/parent::button";
    private static final String ROLE_OPTION = "//span[text()='Select Staff Role']/parent::button/following-sibling::ul/li[text()='%s']";
    private static final String GENDER_DROPDOWN = "//span[text()='Select Gender']/parent::button";
    private static final String GENDER_OPTION = "//span[text()='Select Gender']/parent::button/following-sibling::ul/li[text()='%s']";
    private static final String ADDRESS_LINE1 = "address.line1";
    private static final String ADDRESS_LINE2 = "address.line2";
    private static final String STATE_SEARCH = "//input[@placeholder='Select State']";
    private static final String STATE_OPTION = "//input[@placeholder='Select State']/parent::div/following-sibling::ul/li[text()='%s']";
    private static final String CITY_FIELD = "address.city";
    private static final String ZIP_CODE_FIELD = "address.zipcode";
    private static final String SAVE_BUTTON = "//div[@class='MuiBox-root css-lb61rc']//button[text()='Add Staff']";
    public static final String STAFF_TABLE = "//table/tbody/tr";
    public static final String FIRST_STAFF_NAME = "//table/tbody/tr[1]/td[1]";

    // Static data
    private static final String STATE = address.getState();
    private static final String GENDER = userDetails.getGender();
    public static final String ROLE = userDetails.getRole();

    /**
     * Navigates to the Admin Staff page
     * @throws InterruptedException if the thread is interrupted
     */
    public static void navigateToAdminStaffPage() throws InterruptedException {
        test.info("Navigating to the Admin User tab");
        clickOnSettings();
        clickOnAdminUser();
        clickOnRoleTypeTab();
        Thread.sleep(timeout);
        test.pass("Admin User tab is opened successfully");
    }

    /**
     * Opens the Add Staff form
     * @throws InterruptedException if the thread is interrupted
     */
    public static void openAddStaffForm() throws InterruptedException {
        test.info("Opening Add Staff Form");
        findByXpath(ADD_STAFF_BUTTON).click();
        Thread.sleep(timeout);
        test.pass("Add Staff form is opened");
    }

    /**
     * Enters staff details in the form
     * @param firstName First name of the staff
     * @param lastName Last name of the staff
     * @param email Email of the staff
     * @param phoneNumber Phone number of the staff
     * @param role Role of the staff
     * @param gender Gender of the staff
     * @throws InterruptedException if the thread is interrupted
     */
    public static void enterAdminUserDetails(String firstName, String lastName, String email, 
                                           String phoneNumber, String role, String gender) throws InterruptedException {
        test.info("Entering user's details in the fields");
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterPhoneNumber(phoneNumber);
        selectRole(role);
        selectGender(gender);
        test.pass("Entered User details in the fields");
    }

    /**
     * Enters address details in the form
     * @param line1 Address line 1
     * @param line2 Address line 2
     * @param city City
     * @param zipCode Zip code
     * @throws InterruptedException if the thread is interrupted
     */
    public static void enterAddress(String line1, String line2, String city, String zipCode) throws InterruptedException {
        test.info("Entering address of the user");
        findByName(ADDRESS_LINE1).sendKeys(line1);
        findByName(ADDRESS_LINE2).sendKeys(line2);

        WebElement stateInput = findByXpath(STATE_SEARCH);
        stateInput.click();
        stateInput.sendKeys(STATE);
        try {
            findByXpath(String.format(STATE_OPTION, STATE), true).click();
        } catch (Exception e) {
            throw new RuntimeException("State does not match please find");
        }

        findByName(CITY_FIELD).sendKeys(city);
        findByName(ZIP_CODE_FIELD).sendKeys(zipCode);
        Thread.sleep(timeout);
        test.pass("Entered user's address successfully");
    }

    /**
     * Saves the staff details
     * @throws InterruptedException if the thread is interrupted
     */
    public static void saveStaffDetails() throws InterruptedException {
        test.info("Clicking on the save button");
        findByXpath(SAVE_BUTTON).click();
        Thread.sleep(8000);
        test.pass("Clicked on the save button");
    }

    /**
     * Gets the name of the first staff in the list
     * @return Name of the first staff
     * @throws InterruptedException if the thread is interrupted
     */
    public static String getFirstStaffName() throws InterruptedException {
        String actualName;

        if (ROLE.equalsIgnoreCase("Super Admin")) {
            test.info("Verifying that the added staff is displayed in the table");
            findByXpath(ADMIN_USERS_TAB).click();
            driver.navigate().refresh();
            Thread.sleep(2000);
            List<WebElement> rowData = findByXpath(STAFF_TABLE, "true");
            actualName = findByXpath(FIRST_STAFF_NAME).getText();
        } else if (ROLE.equalsIgnoreCase("Front Desk")) {
            clickOnRoleTypeTab();
            driver.navigate().refresh();
            Thread.sleep(2000);
            List<WebElement> rowData = findByXpath(STAFF_TABLE, "true");
            actualName = findByXpath(FIRST_STAFF_NAME).getText();
        } else {
            throw new RuntimeException("Role not found");
        }

        if (Objects.nonNull(actualName))
            test.pass("Added staff is displayed successfully");
        else
            test.fail("The added staff is not displayed in the list");

        return actualName;
    }

    /**
     * Clicks on the Role Type tab
     * @throws InterruptedException if the thread is interrupted
     */
    public static void clickOnRoleTypeTab() throws InterruptedException {
        test.info("Clicking on the Role Type tab");
        findByXpath(String.format("//span[text()='%s']/ancestor::button", ROLE)).click();
        Thread.sleep(timeout);
        test.pass("Clicked on the Role Type tab");
    }

    // Private helper methods
    private static void clickOnSettings() {
        findByXpath(SETTINGS_BUTTON).click();
    }

    private static void clickOnAdminUser() {
        findByXpath(ADMIN_USERS_TAB).click();
    }

    private static void enterFirstName(String firstName) throws InterruptedException {
        WebElement ele = findByName(FIRST_NAME_FIELD);
        clearAndEnterText(ele, firstName);
    }

    private static void enterLastName(String lastName) throws InterruptedException {
        WebElement ele = findByName(LAST_NAME_FIELD);
        clearAndEnterText(ele, lastName);
    }

    private static void enterEmail(String email) throws InterruptedException {
        WebElement ele = findByName(EMAIL_FIELD);
        if (ele.getAttribute("value").isEmpty()) {
            ele.sendKeys(email);
        }
    }

    private static void enterPhoneNumber(String phoneNumber) throws InterruptedException {
        WebElement ele = findByName(PHONE_FIELD);
        clearAndEnterText(ele, phoneNumber);
    }

    private static void selectRole(String role) throws InterruptedException {
        WebElement ele = findByXpath("//label[text()='Role']//following-sibling::button");
        if (!ele.getText().equals(role)) {
            findByXpath(ROLE_DROPDOWN).click();
            findByXpath(String.format(ROLE_OPTION, role), true).click();
        }
    }

    private static void selectGender(String gender) {
        WebElement ele = findByXpath("//label[text()='Gender']//following-sibling::button");
        if (!ele.getText().equals(gender)) {
            findByXpath(GENDER_DROPDOWN).click();
            findByXpath(String.format(GENDER_OPTION, gender)).click();
        }
    }

    private static void clearAndEnterText(WebElement element, String text) throws InterruptedException {
        if (element.getAttribute("value").isEmpty()) {
            element.sendKeys(text);
        } else {
            element.sendKeys(Keys.CONTROL + "a");
            element.sendKeys(Keys.BACK_SPACE);
            Thread.sleep(3000);
            element.sendKeys(text);
        }
    }
}
