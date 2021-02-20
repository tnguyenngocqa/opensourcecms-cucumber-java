package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Waits;

public class CMSRegistrationPage {

    WebDriver driver;
    Waits wait;

    @FindBy(id = "s_name")
    public WebElement regNameInput;

    @FindBy(id = "s_email")
    public WebElement regEmailInput;

    @FindBy(id = "s_password")
    public WebElement regPasswordInput;

    @FindBy(id = "s_password2")
    public WebElement regRepeatPasswordInput;

    @FindBy(xpath = "//button[text()='Create']")
    public WebElement regCreateBtn;


    public CMSRegistrationPage(WebDriver driver) {
        this.driver = driver;
        wait = new Waits();
        PageFactory.initElements(driver, this);
    }

    public void fill_name(String name) {
        regNameInput.sendKeys(name);
    }

    public void fill_email(String email) {
        regEmailInput.sendKeys(email);
    }

    public void fill_password(String password) {
        regPasswordInput.sendKeys(password);
    }

    public void fill_repeat_password(String repeat_password) {
        regRepeatPasswordInput.sendKeys(repeat_password);
    }

    public void attempt_to_create_account() {
        regCreateBtn.click();
    }
}
