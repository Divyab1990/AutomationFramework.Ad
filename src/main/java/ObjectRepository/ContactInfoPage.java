package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {// Rule1
	
	//Rule2 Declaration	
	@FindBy(css = "[class=\"dvHeaderText\"]")
	private WebElement header;
	
	//Rule3 Initialization
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule4 Utilization
	public WebElement getHeader()
	{
		return header;
	}
	
	//Business Library
	/**
	 * This method will print the header text
	 * @return
	 */
	public String captureHeaderText()
	{
		return header.getText();
	}
	
	

}
