package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Waits;

import java.util.ArrayList;
import java.util.List;

public class CMSLoginPage {

    WebDriver driver;
    Waits wait;

    public CMSLoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new Waits();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='main']//*[text()='Access to your account']")
    public WebElement loginAccessToAccountFormHeader;

    @FindBy(id = "email")
    public WebElement loginEmailInput;

    @FindBy(id = "password")
    public WebElement loginPasswordInput;

    @FindBy(id = "remember")
    public WebElement loginRememberMeCheckbox;

    @FindBy(xpath = "//button[text()='Log in']")
    public WebElement loginButton;

    @FindAll(@FindBy(id = ".flashmessage"))
    public List<WebElement> errorFlashMessages;

    public boolean isDisplayed() {
        return loginAccessToAccountFormHeader.isDisplayed();
    }

    public void fill_in_username(String email) {
        loginEmailInput.sendKeys(email);
    }

    public void fill_in_password(String password) {
        loginPasswordInput.sendKeys(password);
    }

    public void perform_login() {
        loginButton.click();
    }

    public List<String> getErrorMessages() {
        List<String> errorMessages = new ArrayList<>();
        for (WebElement element : errorFlashMessages) {
            errorMessages.add(element.getText());
        }
        return errorMessages;
    }

}
