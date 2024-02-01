package ContactTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilities.Baseclass;
import GenericUtilities.Exceldatautility;
import GenericUtilities.PropertyfileUtility;
import GenericUtilities.SeleniumUtility;
import ObjectRepository.ContactInfoPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateNewContactPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(GenericUtilities.ListenersImplementation.class)
public class BASECLASSCreateContactwithMandatoryTest extends Baseclass {
	
    
	@Test(groups = "smokesuite")
	public void CreatecontactwithMandatory() throws IOException, InterruptedException
	{
		
		//Read test data from Excel file
		String LASTNAME = eUtil.readdatafromExceldata("Contacts", 1, 2);
	  		
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
	  		Assert.assertTrue(conHeader.contains(LASTNAME)); 
	  		System.out.println(conHeader);		
	     
	}
@Test	
public void demotest()
{
	Assert.fail();
	System.out.println("Hi");
}

}
