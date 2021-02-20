package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import pageObjects.CMSRegistrationPage;

public class CMSRegistrationSteps {

    CMSRegistrationPage cmsRegistrationPage;
    TestContext testContext;

    // constructor
    public CMSRegistrationSteps(TestContext context) {
        testContext = context;
        cmsRegistrationPage = testContext.getPageObjectManager().getCMSRegistrationPage();
    }

    @And("I enter account details as follows {string} and {string} and {string} and {string}")
    public void iEnterAccountDetailsAsFollows(String name, String email, String password, String repeat_password) {

        cmsRegistrationPage.fill_name(name);
        cmsRegistrationPage.fill_email(email);
        cmsRegistrationPage.fill_password(password);
        cmsRegistrationPage.fill_repeat_password(repeat_password);
    }

    @And("I attempt to create a new account")
    public void iAttemptToCreateANewAccount() {
        cmsRegistrationPage.attempt_to_create_account();
    }
}
