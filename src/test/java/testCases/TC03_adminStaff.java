package testCases;

import baseTest.baseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SuperAdmin.*;
import pages.loginPage;
import utility.ConfigReader;
import utility.address;
import utility.userDetails;

public class TC03_adminStaff extends baseClass {
    public static String firstName = userDetails.getFirstName();
    public static String lastName = userDetails.getLastName();
    public static String email = userDetails.getEmail();
    public static String PhoneNumber = userDetails.getPhoneNumber();
    public static String RoleType = userDetails.getRole();
    public static String Gender = userDetails.getGender();
    public static String AddressLine1 = address.getAddressLine1();
    public static String AddressLine2 = address.getAddressLine2();
    public static String city = address.getCity();
    public static String zipCode = address.getZipCode();
    String gender;

    @Test
    public void addStaffUser() throws InterruptedException {
        gender = Gender;
        loginPage.loginUser(url, username, password);
        adminStaff.navigateToAdminStaffPage();
        adminStaff.openAddStaffForm();
        adminStaff.enterAdminUserDetails(firstName, lastName, email, PhoneNumber, RoleType, gender);
        adminStaff.address(AddressLine1, AddressLine2, city, zipCode);
        adminStaff.clickOnSaveButton();

        String expectedStaffName = firstName + " " + lastName;
        String actualStaffName = adminStaff.getStaff();
        Assert.assertEquals(actualStaffName, expectedStaffName);

    }

    String fName = firstName;
    String LName = lastName;

    @Test
    public void editStaff() throws InterruptedException {
        loginPage.loginUser(url, username, password);
        adminStaff.navigateToAdminStaffPage();
        editStaff.clickOnEditStaffIcon();
        adminStaff.enterAdminUserDetails(firstName, lastName, email, PhoneNumber, RoleType, gender);
        //adminStaff.address(AddressLine1,AddressLine2,city,zipCode);
        editStaff.clickOnSaveStaffButton();

        String expectedStaffName = firstName + " " + lastName;
        String actualStaffName = editStaff.getEditedStaff(fName, LName);
        Assert.assertEquals(actualStaffName, expectedStaffName);

    }

    @Test
    public void getStaffDetails() throws InterruptedException {
        loginPage.loginUser(url, username, password);
        adminStaff.navigateToAdminStaffPage();
        viewStaff.clickOnThePatientName(fName, LName);

        String actualFirstName = viewStaff.verifyFirstName();
        String actualLastName = viewStaff.verifyLastName();

        Assert.assertEquals(actualFirstName, firstName);
        Assert.assertEquals(actualLastName, lastName);
    }

    @Test
    public void searchStaffByName() throws InterruptedException {
        String searchByName = "test test";
        loginPage.loginUser(url, username, password);
        adminStaff.navigateToAdminStaffPage();
        searchStaff.clickAndEnterInTheSearchTextField(searchByName);
        String actualName = searchStaff.getSearchedNameByUser();
        Assert.assertEquals(actualName,searchByName);

    }

    @Test
    public void sortingPatientListByName() throws InterruptedException {
        loginPage.loginUser(url, username, password);
        adminStaff.navigateToAdminStaffPage();
        sortUser.clickOnSortToAscend();
        sortUser.verifyListInAscendingOrder();
    }
}
