package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario1 {

	public static void main(String[] args) throws Throwable {
		
		//Step1: Launch the browser
		WebDriverManager.chromedriver().setup();
		//EdgeDriver driver = new EdgeDriver();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Step2: Load the URL
		driver.get("http://localhost:8888");
		
		//Step3: Login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Step4: Navigate to contacts link
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step5: Click on Create Contact lookup image
		driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
		
		//Step6: Create Contact with Mandatory details
		driver.findElement(By.name("lastname")).sendKeys("DivyaRaj");
		
		//Step7: Save
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
		//Step8: Validate
		String conHeader = driver.findElement(By.cssSelector("[class=\"dvHeaderText\"]")).getText();
		if(conHeader.contains("DivyaRaj"))
		{
			System.out.println("PASS");
			System.out.println(conHeader);
		}
		else
		{
			System.out.println("FAIL");
		}
		
		//Step9: Logout to APP
		WebElement ele = driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]"));
		
	    Actions act = new Actions(driver);
	    act.moveToElement(ele).perform();
	    
	    Thread.sleep(1000);
	    
	    driver.findElement(By.linkText("Sign Out")).click();
	    
	    //Step10: Close the Browser
	     driver.quit();		

	}

}
