package pages.service.identity.citizenship.residense;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.service.BaseServicePage;
import org.testng.Assert;

public class InternationalPassportPage extends BaseServicePage {

    public static String referenceNumber;

    //---------------- Элементы страницы------------------// 
    @FindBy(name = "have_passport")
    private WebElement havePassportField; // поле "У Вас на даний момент є загранпаспорт?"

    @FindBy(name = "biometrical")
    private WebElement biometricalField; // поле "Ви бажаєте замовити біометричний паспорт?"

    @FindBy(name = "email")
    private WebElement emailField; //поле эмейла

    @FindBy(name = "area")
    private WebElement areaField; // поле выбора раённого отделения

    @FindBy(xpath = "//select[@ng-model='selected.date']")
    private WebElement dayField; // поле выбора даты визита

    @FindBy(xpath = "//select[@ng-disabled='!selected.date || slotsLoading']")
    private WebElement timeField; // поле выбора времени визита

    @FindBy(xpath = "//div[@class='text-center ng-binding ng-scope']")
    private WebElement successText; //текст удачной создании заявки

    public InternationalPassportPage() {
        PageFactory.initElements(driver, this);
    }

    //---------------- Методы ввода данных в поля------------------//

    public InternationalPassportPage selectHavePassport(String havePassport) {
        new Select(havePassportField).selectByVisibleText(havePassport);
        return this;
    }

    public InternationalPassportPage selectBiometrical(String biometrical) {
        new Select(biometricalField).selectByVisibleText(biometrical);
        return this;
    }

    public InternationalPassportPage typeInPhoneField(String phone) {
        phoneField.clear();
        phoneField.sendKeys(phone); // ввод телефона
        return this;
    }

    public InternationalPassportPage typeInEmailField(String email) {
        emailField.clear();
        emailField.sendKeys(email); // ввод емайла
        return this;
    }

    public InternationalPassportPage selectArea(String area) {
        new Select(areaField).selectByVisibleText(area);
        return this;
    }

    public InternationalPassportPage selectDay() {
        Boolean selected;
        try {
            new Select(dayField).selectByValue("0");
            selected = true;
        } catch (NoSuchElementException e) {
            selected = false;
        }
        Assert.assertTrue(selected, "NO AVAILABLE SLOTS!, NO AVAILABLE SLOTS !, NO AVAILABLE SLOTS!");
        return this;
    }

    public InternationalPassportPage selectTime() {
        Boolean selected;
        try {
            new Select(timeField).selectByValue("0");
            selected = true;
        } catch (NoSuchElementException e) {
            selected = false;
        }
        Assert.assertTrue(selected, "NO AVAILABLE SLOTS!, NO AVAILABLE SLOTS !, NO AVAILABLE SLOTS!");
        return this;
    }

    @Override
    public InternationalPassportPage clickConfirmButton() {
        super.clickConfirmButton();
        return this;
    }

    public InternationalPassportPage verifyServiceSuccessCreated() {
        successText.isDisplayed();// проверка успешного создания заявки
        return this;
    }
//=================методы по работе с номером заявки=======================//

    @Override
    public String saveReferenceNumber() {
        referenceNumber = super.saveReferenceNumber();
        return referenceNumber;
    }
}
