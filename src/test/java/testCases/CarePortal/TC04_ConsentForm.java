package testCases.CarePortal;
import baseTest.baseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CarePortal.consentForm;
import pages.loginPage;

public class TC04_ConsentForm extends baseClass {

    @Test
    public static void addConsent() throws InterruptedException {
        url = "https://epicsystem.qa.care.eamata.com/auth/login";
        username = "yogesh.jadhav+pgadmin@thinkitive.com";
        password = "Test@123";
        // Login to the application
        loginPage.loginUser(url, username, password);
        
        // Navigate to Consent Form
        consentForm.navigateToTheSettingsTab();
        consentForm.navigateToTheConsentForm();
        
        // Verify Consent Form page is loaded
       // Assert.assertTrue(consentForm.isConsentFormPageLoaded(), "Consent Form page is not loaded");

        // Click on Add Consent Form
        consentForm.ClickOnTheAddConsentForm();
        consentForm.addConsentForm("Conset To Call", "C:/Users/LNV-24/Downloads/consentFormPDF.pdf");
        Assert.assertTrue(consentForm.isUploadSuccessful(), "Consent form upload failed!");
    }
}
