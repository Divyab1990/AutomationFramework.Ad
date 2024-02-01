package Practice;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericUtilities.PropertyfileUtility;
import GenericUtilities.SeleniumUtility;
import ObjectRepository.ContactsPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class WebTables {
	@Test
	public void checkbox() throws IOException {
		SeleniumUtility s = new SeleniumUtility();
		PropertyfileUtility p = new PropertyfileUtility();
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		s.maximizeWindow(driver);
		s.addImplicitlywait(driver);
		
		String URL = p.readdatafromPropertyfile("url");
		String USERNAME = p.readdatafromPropertyfile("username");
		String PASSWORD = p.readdatafromPropertyfile("password");
		
		driver.get(URL);
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		HomePage hp = new HomePage(driver);
		hp.clickonContactslink();
		
		
		
	
		
	}

}
