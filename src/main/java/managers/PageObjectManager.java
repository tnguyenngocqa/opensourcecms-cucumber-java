package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.CMSLoginPage;
import pageObjects.CMSMainPage;
import pageObjects.CMSRegistrationPage;

public class PageObjectManager {

    private WebDriver driver;

    private CMSMainPage cmsMainPage;
    private CMSLoginPage cmsLoginPage;
    private CMSRegistrationPage cmsRegistrationPage;

    // Constructor
    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public CMSMainPage getCMSMainPage() {
        return (cmsMainPage == null) ? cmsMainPage = new CMSMainPage(driver) : cmsMainPage;
    }

    public CMSRegistrationPage getCMSRegistrationPage() {
        return (cmsRegistrationPage == null) ? cmsRegistrationPage = new CMSRegistrationPage(driver) : cmsRegistrationPage;
    }

    public CMSLoginPage getCMSLoginPage() {
        return (cmsLoginPage == null) ? cmsLoginPage = new CMSLoginPage(driver) : cmsLoginPage;
    }
}
