package GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class consists of all basic configuration Annotations of TestNG
 */
public class Baseclass {
	
	public Exceldatautility eUtil= new Exceldatautility();
	public PropertyfileUtility pUtil = new PropertyfileUtility();
	public SeleniumUtility sUtil= new SeleniumUtility();
	public JavaUtility jUtil= new JavaUtility();
	
	public WebDriver driver;
	
	//For listeners
	public static WebDriver sdriver;
	
	@BeforeSuite(groups= {"smokesuite","regressionsuite"})
	public void bsConfig()
	{
		System.out.println("============DB Connection Susscessful=========");
	}
	
	//@Parameters("Browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String BROWSER*/) throws IOException
	{
		String URL = pUtil.readdatafromPropertyfile("url");
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
			/*if (BROWSER.equals("Chrome")) 
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
			else if (BROWSER.equals("Edge")) 
			{
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			}*/
		
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlywait(driver);
		
		driver.get(URL);
		
	  System.out.println("============Browser Launch Susscessful=========");
	  
	  sdriver= driver;
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readdatafromPropertyfile("username");
		String PASSWORD = pUtil.readdatafromPropertyfile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("============Login To App Susscessful=========");
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.logoutofAPP(driver);
		
		System.out.println("============Logout of App Susscessful=========");
	}
	
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		
		System.out.println("============Browser Closure Susscessful=========");	
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("============DB Closure Susscessful=========");
	}

}
