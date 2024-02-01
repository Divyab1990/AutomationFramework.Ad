package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //Rule1
	
	//Rule2 - Declaration
	@FindBy(name = "user_name") 
	private WebElement userNameEdt;
	
	@FindBy(name = "user_password")
	private WebElement passWordEdt;
	
	@FindBy(id= "submitButton")
	private WebElement loginBtn;
	
	//Rule3 - Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule4 -Utilization
	public WebElement getUserNameEdt() 
	{
		return userNameEdt;
	}

	public WebElement getPassWordEdt() 
	{
		return passWordEdt;
	}

	public WebElement getLoginBtn() 
	{
		return loginBtn;
	}
	
   //Business Library
	/**
	 * This method will login to Application
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApp(String USERNAME, String PASSWORD)
	{
		userNameEdt.sendKeys(USERNAME);
		passWordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
}
