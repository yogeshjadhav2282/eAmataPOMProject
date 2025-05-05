package pages.SuperAdmin;

import baseTest.baseClass;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

/**
 * EditStaff class represents the Edit Staff functionality in the application.
 * It contains methods to interact with the Edit Staff form and perform actions.
 */
public class editStaff extends baseClass {
    // Locators
    private static final String EDIT_ICON = "//table/tbody/tr[1]/td[6]/descendant::button";
    private static final String SAVE_BUTTON = "//p[text()='Edit Staff']/ancestor::div[1]/following-sibling::div/descendant::button[5]";
    private static final String STAFF_NAME_PATTERN = "//table/tbody/tr[%d]/td[1]";

    /**
     * Opens the Edit Staff form
     * @throws InterruptedException if the thread is interrupted
     */
    public static void openEditStaffForm() throws InterruptedException {
        test.info("Opening Edit Staff Form");
        findByXpath(EDIT_ICON).click();
        Thread.sleep(timeout);
        test.pass("Edit Staff form is opened");
    }

    /**
     * Saves the edited staff details
     * @throws InterruptedException if the thread is interrupted
     */
    public static void saveEditedStaffDetails() throws InterruptedException {
        test.info("Clicking on the save button to update the user details");
        findByXpath(SAVE_BUTTON).click();
        Thread.sleep(timeout);
        test.pass("Clicked on the save button");
    }

    /**
     * Verifies if the edited staff is displayed in the list
     * @param firstName First name of the staff
     * @param lastName Last name of the staff
     * @return Name of the edited staff if found
     * @throws InterruptedException if the thread is interrupted
     */
    public static String verifyEditedStaff(String firstName, String lastName) throws InterruptedException {
        String expectedName = firstName + " " + lastName;
        String actualName = "";

        test.info("Verifying that the edited staff is displayed in the table");
        adminStaff.clickOnRoleTypeTab();
        driver.navigate().refresh();
        Thread.sleep(2000);
        List<WebElement> staffList = findByXpath(adminStaff.STAFF_TABLE, "true");

        for (int i = 1; i <= staffList.size(); i++) {
            WebElement staffElement = findByXpath(String.format(STAFF_NAME_PATTERN, i));
            actualName = staffElement.getText();
            if (expectedName.equals(actualName)) {
                test.pass("The staff details are edited successfully");
                break;
            }
        }

        if (!expectedName.equals(actualName)) {
            test.fail("The staff details are not edited successfully");
            throw new RuntimeException("Edited Staff User details not exist in the system");
        }

        return actualName;
    }
}
