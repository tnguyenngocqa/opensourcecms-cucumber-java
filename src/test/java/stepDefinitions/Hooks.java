package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.ExtentReportBuilder;

public class Hooks {

    private TestContext testContext;
    private ExtentReportBuilder reportBuilder;

    public Hooks(TestContext context) {
        testContext = context;
        reportBuilder = new ExtentReportBuilder(context);
    }

    @Before
    public void BeforeSteps() {
        testContext.getWebDriverManager().getDriver();
    }

    @After
    public void tearDownAndScreenShotOnFailure(Scenario scenario) {
        try {
            System.out.println("------ Closing Browsers ------");
            testContext.getWebDriverManager().closeDriver();

            reportBuilder.additionalReportInfo(scenario);
            reportBuilder.captureScreenshot(scenario);
            reportBuilder.copyLatestExtentReport();
        } catch (Exception e) {
            System.out.println("Methods failed: tearDownAndScreenShotOnFailure, Exception:" + e.getMessage());
        }
    }
}
