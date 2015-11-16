package pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import appLogic.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ServicePages.CriminalRecordPage;
import ServicePages.SubsidyPage;


public class StatusPage extends ApplicationManager {

    private WebDriver driver;


    public StatusPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    


    //    ------------------- Элементы ID Bank------------------------------//

    @FindBy(id = "code")
    public WebElement refIdField;          // поле ввода реф
    
    @FindBy(xpath = "//a[contains(.,'Переглянути')]")
    public WebElement viewStatusButton;    //кнопка просмотра статуса


    // =============================================== МЕТОДЫ  =================================================//


    public StatusPage inputReferenceNumberForSubsidy(){
    	refIdField.sendKeys(SubsidyPage.referenceNumber);
    	return this;
    }
    public StatusPage inputReferenceNumberForCriminalRecord(){
    	refIdField.sendKeys(CriminalRecordPage.referenceNumber);
    	return this;
    }


	public StatusPage clickViewStatusButton() {
		viewStatusButton.click();
		return this;
	}


	public void verifyStatus(String status) {
	driver.findElement(By.xpath("//td[contains(.,'"+status+"')]")).isDisplayed();
		
	}



}
