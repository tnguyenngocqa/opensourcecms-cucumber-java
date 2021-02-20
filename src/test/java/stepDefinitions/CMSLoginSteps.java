package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Context;
import org.junit.Assert;
import pageObjects.CMSLoginPage;
import pageObjects.CMSMainPage;

import java.util.Arrays;
import java.util.List;

public class CMSLoginSteps {

    CMSLoginPage cmsLoginPage;
    CMSMainPage cmsMainPage;
    TestContext testContext;

    public CMSLoginSteps(TestContext testContext) {
        this.testContext = testContext;
        cmsMainPage = testContext.getPageObjectManager().getCMSMainPage();
        cmsLoginPage = testContext.getPageObjectManager().getCMSLoginPage();
    }

    @And("I am on the CMS Login Page")
    public void iAmOnTheCMSLoginPage() {
        cmsMainPage.navigate_to_LoginPage();
        Assert.assertTrue(cmsLoginPage.isDisplayed());
    }

    @When("I attempt to login as {string} with {string} and {string}")
    public void iAttemptToLoginAsWithAnd(String user_role, String email, String password) {
        testContext.getScenarioContext().setContext(Context.USER_ROLE, user_role);
        cmsLoginPage.fill_in_username(email);
        cmsLoginPage.fill_in_password(password);
        cmsLoginPage.perform_login();
    }

    @Then("I should see the error messages {string}")
    public void iShouldSeeTheErrorMessages(String error_message) {
        String[] error_messages = error_message.split("/n");
        List<String> expErrorMessages = Arrays.asList(error_messages);//it converts to immutable list
        // Print list to console
        expErrorMessages.stream().forEach(System.out::println);
        List<String> actErrorMessages = cmsLoginPage.getErrorMessages();
        Assert.assertEquals(expErrorMessages, actErrorMessages);
    }
}
