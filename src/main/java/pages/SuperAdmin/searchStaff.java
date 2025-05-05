package pages.SuperAdmin;

import baseTest.baseClass;
import org.openqa.selenium.WebElement;

/**
 * SearchStaff class represents the Staff Search functionality in the application.
 * It contains methods to search and verify staff details.
 */
public class searchStaff extends baseClass {
    // Locators
    private static final String SEARCH_FIELD = "searchString";
    private static final String FIRST_STAFF_NAME = "//table/tbody/tr[1]/td[1]";

    /**
     * Searches for a staff member by name
     * @param searchName Name to search for
     * @throws InterruptedException if the thread is interrupted
     */
    public static void searchStaffByName(String searchName) throws InterruptedException {
        test.info("Searching for staff by name");
        WebElement searchField = findByName(SEARCH_FIELD);
        searchField.click();
        searchField.sendKeys(searchName);
        Thread.sleep(3000);
        test.pass("Entered name in the search text field");
    }

    /**
     * Gets the name of the first staff member in the search results
     * @return Name of the first staff member
     * @throws RuntimeException if no staff member is found
     */
    public static String getFirstSearchResult() {
        WebElement staffElement = findByXpath(FIRST_STAFF_NAME);
        String name = staffElement.getText();
        
        if (name.equals("No records found")) {
            return name;
        }
        
        if (name.isEmpty()) {
            throw new RuntimeException("No staff member found matching the search criteria");
        }
        
        return name;
    }
}
