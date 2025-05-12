package pages.CarePortal;
import baseTest.baseClass;
import org.openqa.selenium.WebElement;

public class consentForm extends baseClass {
    // Locators
    private static final String SETTINGS_TAB = "//span[text()='Settings']/parent::a";
    private static final String CONSENT_FORM_TAB = "//button[text()='Consent Forms']";
    private static final String ADD_CONSENT_BUTTON = "//span[text()='Add Consent']/parent::button";
    //private static final String CONSENT_FORM_TITLE = "//h1[text()='Consent Forms']";
    private static final String FORM_NAME_INPUT = "//input[@placeholder='Enter document name']";
    private static final String UPLOAD_INPUT = "//input[@type='file']";
    private static final String UPLOAD_BUTTON = "//button[text()='Upload']";
    private static final String SUCCESS_MESSAGE = "//span[contains(text(), 'Consent form template added')]/ancestor::div//div[2]";
    
    /**
     * Navigates to the Settings tab
     * @throws InterruptedException if the thread is interrupted
     */
    public static void navigateToTheSettingsTab() throws InterruptedException {
        test.info("Navigating to the Settings tab");
        findByXpath(SETTINGS_TAB).click();
        Thread.sleep(timeout);
        test.pass("Navigated to Settings tab successfully");
    }

    /**
     * Navigates to the Consent Form section
     * @throws InterruptedException if the thread is interrupted
     */
    public static void navigateToTheConsentForm() throws InterruptedException {
        test.info("Navigating to the Consent Form section");
        findByXpath(CONSENT_FORM_TAB).click();
        Thread.sleep(timeout);
        test.pass("Navigated to Consent Form section successfully");
    }

    /**
     * Clicks on the Add Consent Form button
     * @throws InterruptedException if the thread is interrupted
     */
    public static void ClickOnTheAddConsentForm() throws InterruptedException {
        test.info("Clicking on Add Consent Form button");
        findByXpath(ADD_CONSENT_BUTTON).click();
        Thread.sleep(timeout);
        test.pass("Clicked on Add Consent Form button successfully");
    }

    /**
     * Verifies if the Consent Form page is loaded
     * @return true if the page is loaded, false otherwise
     */
    // public static boolean isConsentFormPageLoaded() {
    //     try {
    //         WebElement titleElement = findByXpath(CONSENT_FORM_TITLE);
    //         return titleElement.isDisplayed();
    //     } catch (Exception e) {
    //         return false;
    //     }
    // }

    public static void enterFormName(String formName) {
        findByXpath(FORM_NAME_INPUT).sendKeys(formName);
    }

    public static void uploadConsentForm(String filePath) {
        WebElement uploadElement = findByXpath(UPLOAD_INPUT);
        uploadElement.sendKeys(filePath); // filePath should be absolute path to the PDF
    }

    public static void clickUploadButton() {
        findByXpath(UPLOAD_BUTTON).click();
    }

    public static boolean isUploadSuccessful() {
        System.out.println("Success Message: "+findByXpath(SUCCESS_MESSAGE).getText());
        try {
            return findByXpath(SUCCESS_MESSAGE).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Complete the add consent form process
     */
    public static void addConsentForm(String formName, String filePath) throws InterruptedException {
        enterFormName(formName);
        uploadConsentForm(filePath);
        Thread.sleep(1000); // Wait for file to be processed if needed
        clickUploadButton();
        Thread.sleep(3000); // Wait for file to be processed if needed
    }
}
