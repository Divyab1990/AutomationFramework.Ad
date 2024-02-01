package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {//Rule1
	
	//Rule2 Declaration	
	@FindBy(css= "[alt=\"Create Contact...\"]")
	private WebElement CreateContactLookupimg;
	
	//Rule3 Initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4 Utilization
	public WebElement getCreateContactLookupimg() {
		return CreateContactLookupimg;
	}
	
	//Business Library
	/**
	 * This method will perform click on create contact lookup img
	 */
	public void clickOnCreateContactlookUp()
	{
		CreateContactLookupimg.click();
	}

}
