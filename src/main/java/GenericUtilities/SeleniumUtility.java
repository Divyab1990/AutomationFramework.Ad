package GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class SeleniumUtility {
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	
	public void maximizeWindow(WebDriver driver) 
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will add 10s of implicit wait
	 * @param driver
	 */
	
	public void addImplicitlywait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void addExplicitwait (WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));	
	}
	/**
	 * This method will handle the dropdown by index
	 * @param element
	 * @param index
	 */
	public void handledropdown(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * This method will handle the dropdown by value
	 * @param element
	 * @param value
	 */
	
	public void handledropdown(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 * This method will handle the dropdown by visibletext
	 * @param Text
	 * @param element
	 */
	public void handledropdown( String Text, WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(Text);
	}
	
	/**
	 * This method will perform the mouse overing action on a webelement
	 * @param driver
	 * @param element
	 */
	public void mouseoveraction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will perform the right click action on a webelement 
	 * @param driver
	 * @param element
	 */
	public void rightclickaction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * This method will perform the drag and drop on a element  
	 * @param driver
	 * @param element
	 * @param src
	 */
	
	public void draganddrop(WebDriver driver, WebElement element, WebElement src)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(element, src).perform();
	}
	/**
	 * this method will perform double click on a element
	 * @param driver
	 * @param element
	 */
	public void doubleclickaction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will perform scroll down action by 500 units
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollby(0,500);", " ");
	}
	/**
	 * This method will handle the frame by using frameindex
	 * @param driver
	 * @param frameindex
	 */
	public void handleFrame(WebDriver driver, int frameindex)
	{
		driver.switchTo().frame(frameindex);
	}
	/**
	 * This method will handle the frame by using framename or ID
	 * @param driver
	 * @param framenumberorID
	 */
	public void handleframe(WebDriver driver, String framenameorID)
	{
		driver.switchTo().frame(framenameorID);
	}
	
	/**
	 * This method will handle the frame by using frameelement
	 * @param element
	 */
    public void handleframe(WebDriver driver, WebElement Frameelement)
    {
    	driver.switchTo().frame(Frameelement);
    }
	/**
	 * This method will capture the screenshot and store it in a folder
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException 
	 */
    public String capturescreenshot(WebDriver driver, String screenShotName) throws IOException
    {
    	TakesScreenshot ts = (TakesScreenshot) driver;
    	File src = ts.getScreenshotAs(OutputType.FILE);
    	File dst= new File(".\\Screenshots\\"+screenShotName+".png");
    	
    	Files.copy(src, dst);
    	
    	return dst.getAbsolutePath(); //for extent report;
    }
	
}
