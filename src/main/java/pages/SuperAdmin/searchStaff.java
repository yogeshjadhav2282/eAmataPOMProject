package pages.SuperAdmin;

import baseTest.baseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Scanner;

public class searchStaff extends baseClass {
    static String clickOnTheSearchField = "searchString";
   static Scanner sc = new Scanner(System.in);

    public static void clickAndEnterInTheSearchTextField(String searchName) throws InterruptedException {
        test.info("Verifying the patient search functionality");
        WebElement ele = findByName(clickOnTheSearchField);
        ele.click();

        if (searchName.isEmpty()) {
            System.out.print("Enter the search term: ");
            String searchByName = sc.nextLine();

            ele.sendKeys(searchByName);
            Thread.sleep(timeout);
        } else {
            ele.sendKeys(searchName);
            Thread.sleep(3000);
        }
        test.pass("Entered name in the search text field");
        sc.close();
    }

    public static String getSearchedNameByUser() {
        WebElement ele = findByXpath(adminStaff.getFullName);
        String name = "";
        if (!ele.getText().isEmpty()) {
            name = ele.getText();
        } else {
            throw new RuntimeException("User not found As searched by name");
        }
        return name;
    }


}
