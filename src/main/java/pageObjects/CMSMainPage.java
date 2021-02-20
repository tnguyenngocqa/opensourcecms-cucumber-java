package pageObjects;

import managers.FileReaderManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Waits;

import java.util.List;

public class CMSMainPage {

    WebDriver driver;
    Waits wait;

    @FindBy(id = "logo")
    public WebElement logo;

    @FindBy(linkText = "Login")
    public WebElement loginLink;

    @FindBy(linkText = "Register for a free account")
    public WebElement registerLink;

    @FindBy(linkText = "Publish your ad for free")
    public WebElement adPublishLink;

    @FindBy(linkText = "My account")
    public WebElement myAccountLink;

    @FindBy(linkText = "Logout")
    public WebElement logoutLink;

    @FindBy(id = "flashmessage")
    public WebElement flashMessage;

    @FindBy(xpath = "//*[@class='nav']//span[contains(text(),'Hi')]")
    public WebElement messageSayHi;

    public CMSMainPage(WebDriver driver) {
        this.driver = driver;
        wait = new Waits();
        PageFactory.initElements(driver, this);
    }

    public void navigate_to_MainHomePage() {
        this.driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }

    public void navigate_to_RegistrationPage() {
        registerLink.click();
    }

    public void navigate_to_LoginPage() {
        loginLink.click();
    }

    public void navigate_to_PublishAdsPage() {
        registerLink.click();
    }

    public String get_flash_message() {
        return getTextNode(flashMessage);
    }


    public String getLoginSuccessMessageSayHi() {
        return messageSayHi.getText();
    }

    public boolean isDisplayedMyAccountLink() {
        return myAccountLink.isDisplayed();
    }

    public boolean isDisplayedLogoutLink() {
        return logoutLink.isDisplayed();
    }

    public boolean isDisplayedLogoMainHomePage() {
        return logo.isDisplayed();
    }

    private String getTextNode(WebElement e) {
        String text = e.getText().trim();
        List<WebElement> children = e.findElements(By.xpath("./*"));
        for (WebElement child : children) {
            text = text.replaceFirst(child.getText(), "").trim();
        }
        return text;
    }
}
