package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.SeleniumUtility;

public class HomePage extends SeleniumUtility {//Rule1
	
	//Rule2 Declaration
	@FindBy(xpath = "//a[text()=\"Contacts\"]") 
	private WebElement Contactslink;
	
	@FindBy(css = "[src=\"themes/softed/images/user.PNG\"]")
	private WebElement Administratorimg;
	
	@FindBy(xpath = "//a[text()=\"Sign Out\"]")
	private WebElement Signoutlink;
	
	//Rule3 Intialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule4 Utilization
	
	public WebElement getContactslink() 
	{
		return Contactslink;
	}

	public WebElement getAdministratorimg() 
	{
		return Administratorimg;
	}

	public WebElement getSignoutlink() 
	{
		return Signoutlink;
	}
	
    //Business Library
	/**
	 * This method will click on contacts link in the homepage
	 */
	public void clickonContactslink()
	{
		Contactslink.click();
	}
	/**
	 * This method will perform logout operation
	 * @param driver
	 * @throws InterruptedException
	 */
	public void logoutofAPP(WebDriver driver) throws InterruptedException
	{
		mouseoveraction(driver, Administratorimg);
		Thread.sleep(1000);
		Signoutlink.click();
	}

}
