package pages.SuperAdmin;

import baseTest.baseClass;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * SortUser class represents the Staff Sorting functionality in the application.
 * It contains methods to sort and verify staff list order.
 */
public class sortUser extends baseClass {
    // Locators
    private static final String SORT_BUTTON = "//table/thead/tr/th[1]/a/descendant::p";
    private static final String STAFF_NAME_PATTERN = "//table/tbody/tr[%d]/td[1]";
    private static final String PAGINATION_LIST = "//table/ancestor::div[1]/following-sibling::div/descendant::div[4]/child::nav/ul/li";
    private static final String PAGINATION_BUTTON_PATTERN = PAGINATION_LIST + "[%d]";

    // State
    private static final List<String> staffNames = new ArrayList<>();
    private static int currentPage = 2;

    /**
     * Clicks on the sort button to sort staff by name
     * @throws InterruptedException if the thread is interrupted
     */
    public static void sortByName() throws InterruptedException {
        findByXpath(SORT_BUTTON).click();
        Thread.sleep(timeout);
    }

    /**
     * Navigates to the next page in the pagination
     * @throws InterruptedException if the thread is interrupted
     */
    private static void navigateToNextPage() throws InterruptedException {
        findByXpath(String.format(PAGINATION_BUTTON_PATTERN, currentPage)).click();
        Thread.sleep(3000);
    }

    /**
     * Verifies if the staff list is sorted in ascending order
     * @throws InterruptedException if the thread is interrupted
     */
    public static void verifyAscendingOrder() throws InterruptedException {
        List<WebElement> paginationElements = findByXpath(PAGINATION_LIST, "true");
        int totalPages = paginationElements.size();
        
        // Collect names from first page
        collectStaffNames();
        
        // Collect names from middle pages
        while (currentPage < totalPages - 1) {
            navigateToNextPage();
            collectStaffNames();
            currentPage++;
        }
        
        // Collect names from last page if it exists
        if (totalPages > 1) {
            navigateToNextPage();
            collectStaffNames();
        }

        verifySortOrder();
    }

    /**
     * Collects staff names from the current page
     * @throws InterruptedException if the thread is interrupted
     */
    private static void collectStaffNames() throws InterruptedException {
        List<WebElement> staffElements = findByXpath(adminStaff.STAFF_TABLE, "true");
        for (int i = 1; i <= staffElements.size(); i++) {
            WebElement staffElement = findByXpath(String.format(STAFF_NAME_PATTERN, i));
            staffNames.add(staffElement.getText());
        }
    }

    /**
     * Verifies if the collected names are in ascending order
     */
    private static void verifySortOrder() {
        System.out.println("Actual Sorted Names: "+staffNames);
        List<String> sortedNames = new ArrayList<>(staffNames);
        Collections.sort(sortedNames);
        System.out.println("Sorted Names: "+ sortedNames);

        if (!staffNames.equals(sortedNames)) {
            throw new RuntimeException("Staff list is not sorted in ascending order");
        }
    }
}
