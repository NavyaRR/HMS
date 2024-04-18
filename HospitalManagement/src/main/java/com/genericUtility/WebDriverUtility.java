package com.genericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * this method is used to maximize window
	 * @param driver
	 */

	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * this method is to wait until page get loaded
	 * @param driver
	 * @param sec
	 */
public void waitForPageLoad(WebDriver driver,int sec)
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

}


//select class
public Select sel(WebElement ele)
{
	 Select select = new Select(ele);
	 return select;	 
}
public void handleDropdownbyIndex(int text1,WebElement ele)
{
	sel(ele).selectByIndex(text1);
}
public void handleDropdownbyVisibleText(WebElement ele,String text)
{
	sel(ele).selectByVisibleText(text);
}
public void handleDropdownbyValue(WebElement ele,String num)
{
	sel(ele).selectByValue(num);
}
public void handleDropdowndeselectbyindex(WebElement ele,int index)
{
	sel(ele).deselectByIndex(index);
}
public void deselectbyvisibletext(WebElement ele,String name)
{
	sel(ele).deselectByVisibleText(name);
}


//javascriptexecutor

public void jseusingsendkeys( WebDriver driver,WebElement ele,String expdate)
{
JavascriptExecutor jse = (JavascriptExecutor)driver;	
jse.executeScript("arguments[0].value=arguments[1]",ele,expdate);
}


//alert popup

public void alertaccept(WebDriver driver)
{
	driver.switchTo().alert().accept();
}
public void alertdismisspopup(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
	}
public void alertgettext(WebDriver driver)
{
	driver.switchTo().alert().getText();
}

//action class
public void mousehover(WebDriver driver,WebElement element)
{
	Actions act = new Actions(driver);
	act.click(element).perform();
}
public Actions performActions(WebDriver driver)
{
	Actions act = new Actions(driver);
	return act;
}
public void enterkeypress(WebDriver driver,WebElement element)
{
	performActions(driver).sendKeys(Keys.ENTER).perform();
}
public void dragAnddrop(WebDriver driver,WebElement src,WebElement dst)
{
	performActions(driver).dragAndDrop(src, dst);
}
public void doubleclick(WebDriver driver,WebElement ele) 
{
	performActions(driver).doubleClick(ele).perform();
}
public void rightclick(WebDriver driver,WebElement ele)
{
	performActions(driver).contextClick(ele).perform();
}


public Robot robotObj() throws AWTException
{
	Robot robot = new Robot();
	return robot;
}
/**
 * press enter key
 * @throws AWTException 
 */
public void enterkey() throws AWTException
{
	robotObj().keyPress(KeyEvent.VK_ENTER);
}
/**
 * RELEASE enter key
 * @throws AWTException 
 */
public void enterkey1() throws AWTException
{
	robotObj().keyRelease(KeyEvent.VK_ENTER);
}
/**
 * TAKE ScreenShot
 * @return 
 * @throws IOException 
 */
	public static String getScreenShot(WebDriver driver,String Methodname) throws IOException
	{
		JavaUtility jutil = new JavaUtility();
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
	 File dst = new File("./screenshot/"+Methodname+""+jutil.getSystemDateInformat()+".png");
	 String srcpath = dst.getAbsolutePath();
	FileUtils.copyFile(src, dst);
	 return srcpath;
	}
	/**
	 * scroll
	 */
	public void scrollbarAction(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,800)", "");
	}
	/**
	 * scroll till the element
	 */
public void scrolltillele(WebDriver driver,WebElement element)
{
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("arguments[0].scrollIntoView()", element);
	}
/**
 * senddata
 */
public void senddata(WebDriver driver,WebElement ele,String expdata)
{
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("arguments[0].value=arguments[1]",ele,expdata);
}
}



