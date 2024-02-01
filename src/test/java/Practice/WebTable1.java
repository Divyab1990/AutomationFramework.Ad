package Practice;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import GenericUtilities.Baseclass;
import ObjectRepository.HomePage;

public class WebTable1 extends Baseclass{
	@Test
	public void checkbox() {
		
	HomePage hp = new HomePage(driver);
	hp.clickonContactslink();
	
	driver.findElement(By.xpath("//table[@class=\"lvt small\"]/tbody/tr[*]/td[1]")).click();
		
		
		
	}

}
