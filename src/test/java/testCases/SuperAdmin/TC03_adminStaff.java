package testCases.SuperAdmin;

import baseTest.baseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SuperAdmin.*;
import pages.loginPage;
import utility.address;
import utility.userDetails;

/**
 * TC03_adminStaff class contains test cases for Admin Staff management functionality.
 * It tests adding, editing, viewing, searching, and sorting staff members.
 */
public class TC03_adminStaff extends baseClass {
    // Test data
    private static final String FIRST_NAME = userDetails.getFirstName();
    private static final String LAST_NAME = userDetails.getLastName();
    private static final String EMAIL = userDetails.getEmail();
    private static final String PHONE_NUMBER = userDetails.getPhoneNumber();
    private static final String ROLE_TYPE = userDetails.getRole();
    private static final String GENDER = userDetails.getGender();
    private static final String ADDRESS_LINE1 = address.getAddressLine1();
    private static final String ADDRESS_LINE2 = address.getAddressLine2();
    private static final String CITY = address.getCity();
    private static final String ZIP_CODE = address.getZipCode();

    /**
     * Tests adding a new staff member
     * @throws InterruptedException if the thread is interrupted
     */
    @Test
    public void addStaffUser() throws InterruptedException {
        // Login and navigate to Admin Staff page
        loginPage.loginUser(url, username, password);
        adminStaff.navigateToAdminStaffPage();

        // Add new staff
        adminStaff.openAddStaffForm();
        adminStaff.enterAdminUserDetails(FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, ROLE_TYPE, GENDER);
        adminStaff.enterAddress(ADDRESS_LINE1, ADDRESS_LINE2, CITY, ZIP_CODE);
        adminStaff.saveStaffDetails();

        // Verify staff is added
        String expectedStaffName = FIRST_NAME + " " + LAST_NAME;
        String actualStaffName = adminStaff.getFirstStaffName();
        Assert.assertEquals(actualStaffName, expectedStaffName, "Staff name mismatch");
    }

    /**
     * Tests editing an existing staff member
     * @throws InterruptedException if the thread is interrupted
     */
    @Test
    public void editStaff() throws InterruptedException {
        // Login and navigate to Admin Staff page
        loginPage.loginUser(url, username, password);
        adminStaff.navigateToAdminStaffPage();

        // Edit staff
        editStaff.openEditStaffForm();
        adminStaff.enterAdminUserDetails(FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, ROLE_TYPE, GENDER);
        editStaff.saveEditedStaffDetails();

        // Verify staff is edited
        String expectedStaffName = FIRST_NAME + " " + LAST_NAME;
        String actualStaffName = editStaff.verifyEditedStaff(FIRST_NAME, LAST_NAME);
        Assert.assertEquals(actualStaffName, expectedStaffName, "Edited staff name mismatch");
    }

    /**
     * Tests viewing staff details
     * @throws InterruptedException if the thread is interrupted
     */
    @Test
    public void viewStaffDetails() throws InterruptedException {
        // Login and navigate to Admin Staff page
        loginPage.loginUser(url, username, password);
        adminStaff.navigateToAdminStaffPage();

        // View staff details
        viewStaff.viewStaffDetails(FIRST_NAME, LAST_NAME);

        // Verify staff details
        String actualFirstName = viewStaff.getFirstName();
        String actualLastName = viewStaff.getLastName();

        Assert.assertEquals(actualFirstName, FIRST_NAME, "First name mismatch");
        Assert.assertEquals(actualLastName, LAST_NAME, "Last name mismatch");
    }

    /**
     * Tests searching for a staff member
     * @throws InterruptedException if the thread is interrupted
     */
    @Test
    public void searchStaffByName() throws InterruptedException {
        String searchName = "Ruben Okuneva";

        // Login and navigate to Admin Staff page
        loginPage.loginUser(url, username, password);
        adminStaff.navigateToAdminStaffPage();

        // Search for staff
        searchStaff.searchStaffByName(searchName);
        String actualName = searchStaff.getFirstSearchResult();

        Assert.assertEquals(actualName, searchName, "Searched staff name mismatch");
    }

    /**
     * Tests sorting staff list by name
     * @throws InterruptedException if the thread is interrupted
     */
    @Test
    public void sortStaffListByName() throws InterruptedException {
        // Login and navigate to Admin Staff page
        loginPage.loginUser(url, username, password);
        adminStaff.navigateToAdminStaffPage();

        // Sort and verify staff list
        sortUser.sortByName();
        sortUser.verifyAscendingOrder();
    }
}
