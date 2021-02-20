package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Context;
import enums.UserRole;
import org.junit.Assert;
import pageObjects.CMSMainPage;

public class CMSMainPageSteps {

    CMSMainPage cmsMainPage;
    TestContext testContext;

    public CMSMainPageSteps(TestContext context) {
        testContext = context;
        cmsMainPage = testContext.getPageObjectManager().getCMSMainPage();
    }

    @Given("I am on the CMS Main Home Page")
    public void iAmOnCMSHomePage() {
        cmsMainPage.navigate_to_MainHomePage();
    }

    @When("I register for a free account")
    public void iRegisterForAFreeAccount() {
        cmsMainPage.navigate_to_RegistrationPage();
    }

    @Then("The account should be created successfully verified with message {string}")
    public void theAccountShouldBeCreatedSuccessfullyVerifiedWithMessage(String expMessage) {
        String actualMessage = cmsMainPage.get_flash_message();
        Assert.assertEquals(expMessage, actualMessage);
    }

    @Then("I should see my account logged in successfully")
    public void iShouldSeeMyAccountLoggedInSuccessfully() {
        // Get user role
        String user_role = (String) testContext.getScenarioContext().getContext(Context.USER_ROLE);
        String sayHiMessage = cmsMainPage.getLoginSuccessMessageSayHi();
        // Common Handle
        // Assert.assertTrue(sayHiMessage.matches("^Hi.*!"));
        Assert.assertTrue(cmsMainPage.isDisplayedMyAccountLink());
        Assert.assertTrue(cmsMainPage.isDisplayedLogoutLink());
        // Handle user role with specific role
        switch (UserRole.valueOf(user_role)) {
            case admin: {
                // Add more code to verify with this role here

                System.out.println("Verifying with admin role");
                break;
            }
            case sale_manager: {
                // Add more code to verify with this role here

                System.out.println("Verifying with sale_manager role");
                break;
            }
            case contact_point: {
                System.out.println("Verifying with contact_point role");
                break;
            }
            case warehouse_manager: {
                System.out.println("Verifying with warehouse_manager role");
                break;
            }
            case finance_manager: {
                System.out.println("Verifying with finance_manager role");
                break;
            }
            default: {
                Assert.fail("This role dis not handle : " + user_role);
                break;
            }
        }
    }
}
