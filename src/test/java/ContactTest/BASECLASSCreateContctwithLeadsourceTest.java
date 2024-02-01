package ContactTest;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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

public class BASECLASSCreateContctwithLeadsourceTest extends Baseclass{
	
	@Test(groups="regressionsuite")
	public void CreatecontactwithLeadsource() throws IOException, InterruptedException
	{
		
		//Read Testdata from Excel file
		String LASTNAME = eUtil.readdatafromExceldata("Contacts", 5, 2);
		String LEADSOURCE = eUtil.readdatafromExceldata("Contacts", 5, 3);
			
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
		Assert.assertTrue(conheader.contains(LASTNAME));
		System.out.println(conheader);
		
	}

}
