package ContactTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class CreateContactwithMandatoryTest {
	

	@Test
	public void CreatecontactwithMandatory() throws IOException, InterruptedException
	{
		
		//Create object utilities
		PropertyfileUtility p = new PropertyfileUtility();
		Exceldatautility e = new Exceldatautility();
		SeleniumUtility s = new SeleniumUtility();
		
		//Read all the required data
		//Read common data from property file
		String URL = p.readdatafromPropertyfile("url");
		String USERNAME = p.readdatafromPropertyfile("username");
		String PASSWORD = p.readdatafromPropertyfile("password");
		
		
		//Read test data from Excel file
		String LASTNAME = e.readdatafromExceldata("Contacts", 1, 2);
		
	    
	        //Step1: Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
	  		
	  		s.maximizeWindow(driver);
	  		s.addImplicitlywait(driver);
	  		
	  		//Step2: Load the URL
	  		driver.get(URL);
	  		
	  		//Step3: Login to application
	  		
	  		//From Business Library
	  		LoginPage lp1 = new LoginPage(driver);
	  		lp1.loginToApp(USERNAME, PASSWORD);
	  		
	  		
	  		//Step4: Navigate to contacts link
	  		HomePage hp = new HomePage(driver);
	  		hp.clickonContactslink();
	  		
	  		//Step5: Click on Create Contact lookup image
	  		ContactsPage cp = new ContactsPage(driver);
	  		cp.clickOnCreateContactlookUp();
	  		
	  		//Step6: Create Contact with Mandatory details
	  	     CreateNewContactPage cncp = new CreateNewContactPage(driver);
	  	     cncp.CreatenewContact(LASTNAME);
	  		
	  		
	  		//Step8: Validate
	  		ContactInfoPage cip = new ContactInfoPage(driver);  
	  		String conHeader= cip.captureHeaderText();
	  		 
	  		if(conHeader.contains(LASTNAME))
	  		{
	  			System.out.println("PASS");
	  			System.out.println(conHeader);
	  		}
	  		else
	  		{
	  			System.out.println("FAIL");
	  		}
	  		
	  		//Step9: Logout to APP
	  		hp.logoutofAPP(driver);
	  		
	  	    //Step10: Close the Browser
	  	     driver.quit();		

	     
	}


}
