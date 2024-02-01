package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScenariowithDDT {

	public static void main(String[] args) throws Throwable {
		
		//Read all the required data
		//Read common data from property file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties pro = new Properties();
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		
		//Read test data from Excel file
		FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\Ad.Sele Test Data.xlsx");
	     Workbook wb = WorkbookFactory.create(fis1);
	     /*Sheet sheet = wb.getSheet("Contacts");
	     Row row = sheet.getRow(1);
	     Cell cel = row.getCell(2);
	     String LASTNAME = cel.getStringCellValue();*/
	    String LASTNAME = wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
	    
	        //Step1: Launch the browser
	  		EdgeDriver driver = new EdgeDriver();
	  		//ChromeDriver driver = new ChromeDriver();
	  		driver.manage().window().maximize();
	  		driver.manage().timeouts().implicitlyWait(Duration
	  				.ofSeconds(10));
	  		
	  		//Step2: Load the URL
	  		driver.get(URL);
	  		
	  		//Step3: Login to application
	  		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	  		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	  		driver.findElement(By.id("submitButton")).click();
	  		
	  		//Step4: Navigate to contacts link
	  		driver.findElement(By.linkText("Contacts")).click();
	  		
	  		//Step5: Click on Create Contact lookup image
	  		driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
	  		
	  		//Step6: Create Contact with Mandatory details
	  		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
	  		
	  		//Step7: Save
	  		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
	  		
	  		//Step8: Validate
	  		String conHeader = driver.findElement(By.cssSelector("[class=\"dvHeaderText\"]")).getText();
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
	  		WebElement ele = driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]"));
	  		
	  	    Actions act = new Actions(driver);
	  	    act.moveToElement(ele).perform();
	  	    
	  	    Thread.sleep(1000);
	  	    
	  	    driver.findElement(By.linkText("Sign Out")).click();
	  	    
	  	    //Step10: Close the Browser
	  	     driver.quit();		

	     
	}

}
