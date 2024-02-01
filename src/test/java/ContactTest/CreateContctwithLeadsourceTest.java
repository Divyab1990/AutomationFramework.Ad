package ContactTest;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericUtilities.Exceldatautility;
import GenericUtilities.PropertyfileUtility;
import GenericUtilities.SeleniumUtility;
import ObjectRepository.ContactInfoPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateNewContactPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContctwithLeadsourceTest {
	
	@Test
	public void CreatecontactwithLeadsource() throws IOException, InterruptedException
	{
		
		//Create object utilities
		Exceldatautility e = new Exceldatautility();
		PropertyfileUtility p = new PropertyfileUtility();
		SeleniumUtility s = new SeleniumUtility();
		
		//Read all the required data
		//Read common data from property file
		String URL = p.readdatafromPropertyfile("url");
		String USERNAME = p.readdatafromPropertyfile("username");
		String PASSWORD = p.readdatafromPropertyfile("password");
		
		//Read Testdata from Excel file
		String LASTNAME = e.readdatafromExceldata("Contacts", 5, 2);
		String LEADSOURCE = e.readdatafromExceldata("Contacts", 5, 3);
		
		//Step1: Launching the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		s.maximizeWindow(driver);
		s.addImplicitlywait(driver);
		
		//Step2 Load the URL
		driver.get(URL);
		
		//Step3 : Login to application
		//From Business Library
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//Step4: Navigate to contactslink
		HomePage hp = new HomePage(driver);
		hp.clickonContactslink();
		
		//Step5: Click on create contact lookup image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactlookUp();
		
		//Step6: Create contact with lead source dropdown
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.CreatenewConact(LASTNAME, LEADSOURCE);
		
		//Step7: Validate
		ContactInfoPage cip = new ContactInfoPage(driver);
		String conheader = cip.captureHeaderText();
		
		if (conheader.contains(LASTNAME)) 
		{
			System.out.println("PASS");
			System.out.println(conheader);
		}
		else 
		{
			System.out.println("FAIL");
		}
		
		//Step8: Logout to APP
		hp.logoutofAPP(driver);
		
		//step9: Close the browser
		driver.quit();
		
	}

}
