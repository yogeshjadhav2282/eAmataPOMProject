package pages.SuperAdmin;

import baseTest.baseClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ViewStaff class represents the View Staff functionality in the application.
 * It contains methods to view and verify staff details.
 */
public class viewStaff extends baseClass {
    private static final Logger log = LoggerFactory.getLogger(viewStaff.class);

    // Locators
    private static final String STAFF_NAME_LINK = "//span[text()='%s']/parent::a";
    private static final String FIRST_NAME = "//span[text()='First Name']/following-sibling::span";
    private static final String LAST_NAME = "//span[text()='Last Name']/following-sibling::span";
    private static final String EMAIL = "//span[text()='Email']/following-sibling::span";
    private static final String PHONE = "//span[text()='Phone']/following-sibling::span";
    private static final String ROLE = "//span[text()='Role']/following-sibling::span";
    private static final String GENDER = "//span[text()='Gender']/following-sibling::span";
    private static final String ADDRESS_LINE1 = "//span[text()='Line 1']/following-sibling::span";
    private static final String ADDRESS_LINE2 = "//span[text()='Line 2']/following-sibling::span";
    private static final String STATE = "//span[text()='State']/following-sibling::span";
    private static final String CITY = "//span[text()='City']/following-sibling::span";
    private static final String COUNTRY = "//span[text()='Country']/following-sibling::span";
    private static final String ZIP_CODE = "//span[text()='Zip Code']/following-sibling::span";

    /**
     * Clicks on the staff name to view details
     * @param firstName First name of the staff
     * @param lastName Last name of the staff
     * @throws InterruptedException if the thread is interrupted
     */
    public static void viewStaffDetails(String firstName, String lastName) throws InterruptedException {
        test.info("Clicking on the staff name");
        findByXpath(String.format(STAFF_NAME_LINK, firstName + " " + lastName)).click();
        Thread.sleep(timeout);
        test.pass("View staff page is opened after clicking on the staff name");
    }

    /**
     * Verifies the first name of the staff
     * @return First name of the staff
     */
    public static String getFirstName() {
        String firstName = findByXpath(FIRST_NAME).getText();
        log.info("First Name: {}", firstName);
        return firstName;
    }

    /**
     * Verifies the last name of the staff
     * @return Last name of the staff
     */
    public static String getLastName() {
        String lastName = findByXpath(LAST_NAME).getText();
        log.info("Last Name: {}", lastName);
        return lastName;
    }

    /**
     * Verifies the email of the staff
     * @return Email of the staff
     */
    public static String getEmail() {
        return findByXpath(EMAIL).getText();
    }

    /**
     * Verifies the phone number of the staff
     * @return Phone number of the staff
     */
    public static String getPhone() {
        return findByXpath(PHONE).getText();
    }

    /**
     * Verifies the role of the staff
     * @return Role of the staff
     */
    public static String getRole() {
        return findByXpath(ROLE).getText();
    }

    /**
     * Verifies the gender of the staff
     * @return Gender of the staff
     */
    public static String getGender() {
        return findByXpath(GENDER).getText();
    }

    /**
     * Verifies the address line 1 of the staff
     * @return Address line 1 of the staff
     */
    public static String getAddressLine1() {
        return findByXpath(ADDRESS_LINE1).getText();
    }

    /**
     * Verifies the address line 2 of the staff
     * @return Address line 2 of the staff
     */
    public static String getAddressLine2() {
        return findByXpath(ADDRESS_LINE2).getText();
    }

    /**
     * Verifies the city of the staff
     * @return City of the staff
     */
    public static String getCity() {
        return findByXpath(CITY).getText();
    }

    /**
     * Verifies the zip code of the staff
     * @return Zip code of the staff
     */
    public static String getZipCode() {
        return findByXpath(ZIP_CODE).getText();
    }

    /**
     * Verifies the state of the staff
     * @return State of the staff
     */
    public static String getState() {
        return findByXpath(STATE).getText();
    }

    /**
     * Verifies the country of the staff
     * @return Country of the staff
     */
    public static String getCountry() {
        return findByXpath(COUNTRY).getText();
    }
}
