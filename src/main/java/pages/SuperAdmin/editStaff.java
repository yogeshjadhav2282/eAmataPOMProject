package pages.SuperAdmin;

import baseTest.baseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;


public class editStaff extends baseClass {
    static String clickOnEditIcon = "//table/tbody/tr[1]/td[6]/descendant::button";
    static String clickOnSaveButton = "//p[text()='Edit Staff']/ancestor::div[1]/following-sibling::div/descendant::button[5]";
    static String findNameInList1 = "//table/tbody/tr[";
    static String findNameInList2 = "]/td[1]";

    public static void clickOnEditStaffIcon() throws InterruptedException {
        test.info("Opening Edit Staff Form");
        findByXpath(clickOnEditIcon).click();
        Thread.sleep(timeout);
        test.pass("Edit Staff form is opened");

    }

    public static void clickOnSaveStaffButton() throws InterruptedException {
        test.info("Clicking on the save button to update the user details");
        findByXpath(clickOnSaveButton).click();
        Thread.sleep(timeout);
        test.pass("Clicked on the save button");
    }

    public static String getEditedStaff(String Fname, String Lname) throws InterruptedException {
        String ExpectedName = Fname + " " + Lname;
        String actualName= "";

        test.info("Verifying that the edited staff is displayed in the table");
        adminStaff.clickOnRoleTypeTab();
        driver.navigate().refresh();
        Thread.sleep(2000);
        List<WebElement> rowSize = findByXpath(adminStaff.tablePath, "true");

        for (int i = 1; i <=rowSize.size(); i++) {
            WebElement ele = findByXpath(findNameInList1 + i + findNameInList2);
            actualName = ele.getText();
            if (ExpectedName.equals(actualName)) {
                test.pass("The staff details are edited successfully");
                break;
            }
            else {
                test.fail("The staff details are notedited successfully");
                throw new RuntimeException("Edited Staff User details not exist in the system");
            }
        }

        return actualName;
    }


}
