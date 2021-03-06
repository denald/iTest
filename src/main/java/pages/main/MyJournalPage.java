package pages.main;

import common.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class MyJournalPage extends BasePage {

    // Variables

    @FindBy(linkText = "увійдіть через BankID")
    public WebElement bankIdAuthorizationButton; // кноки входа в BankID

    @FindBy(linkText = "електронно-цифровий підпис")
    public WebElement electronicDigitalSignatureButton;

    @FindBy(xpath = "//h4[@class='form-signin-bankid-heading_']")
    public WebElement formSignInBankId;  // форма входа в журнал

    @FindBy(xpath = "//a[@ng-click='limit = limit +10']")
    public WebElement nextLink;          // ссылка на заявки

    @FindBy(xpath = "//h1[contains(.,'Мій журнал')]")
    public WebElement myLog;             // ссылка на заявки


    // Methods

    public MyJournalPage() {
        PageFactory.initElements(driver, this);
    }
}