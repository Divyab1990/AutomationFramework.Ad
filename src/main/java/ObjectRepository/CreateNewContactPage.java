package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.SeleniumUtility;

public class CreateNewContactPage extends SeleniumUtility { //Rule1
	
	//Rule2 : Declaration
	@FindBy(name = "lastname")
	private WebElement LastNameTxtFld;
	
	@FindBy(name = "leadsource")
	private WebElement leadsoucedropdown;
	
	
	@FindBy(css = "[title=\"Save [Alt+S]\"]")
	private WebElement SaveBtn;
	
	//Rule3 Initializatiion
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule4 Utilization
	public WebElement getLastNameTxtFld() {
		return LastNameTxtFld;
	}
	
	public WebElement getLeadsoucedropdown() {
		return leadsoucedropdown;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	//Business Library
	/**
	 * This method will create the contact with mandatory details
	 * @param LASTNAME
	 */
	public void CreatenewContact(String LASTNAME)
	{
		LastNameTxtFld.sendKeys(LASTNAME);
		SaveBtn.click();
	}
	/**
	 * This method will Create a contact with leadsouce dropdown
	 * @param LASTNAME
	 * @param LEADSOURCEValue
	 */
	public void CreatenewConact(String LASTNAME, String LEADSOURCEValue)
	{
		LastNameTxtFld.sendKeys(LASTNAME);
		handledropdown(leadsoucedropdown, LEADSOURCEValue);
		SaveBtn.click();;
	}
	
	
	

}
