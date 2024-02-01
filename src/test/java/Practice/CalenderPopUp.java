package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import GenericUtilities.SeleniumUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPopUp extends SeleniumUtility{
	@Test
	public void currentDOM() throws InterruptedException
	{
		SeleniumUtility s = new SeleniumUtility();
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.makemytrip.com/");
		
		s.addImplicitlywait(driver);
		s.maximizeWindow(driver);
		
		//Thread.sleep(1000);
		//Actions act = new Actions(driver);
		//act.moveByOffset(20, 10).perform();
		
		driver.findElement(By.cssSelector("[class=\"close\"]")).click();
		
		
		//driver.findElement(By.xpath("//span[text()=\"Departure\"]")).click();
		
	
		
		
		
		
		
	}

}
