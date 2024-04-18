package com.genericUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;


public class Baseclass {
DatabaseUtility dutil = new DatabaseUtility();
ExcelUtility eutil = new ExcelUtility();
FileUtility futil = new FileUtility();
WebDriverUtility wutil = new WebDriverUtility();
JavaUtility jutil = new JavaUtility();

public WebDriver driver ;
public static WebDriver sdriver;
@BeforeSuite

public void connecttoDB() throws SQLException
{
	dutil.connectToDB();
	Reporter.log("DB CONNECTED",true);
}

//@Parameters("BROWSER")--->for cross browser suite file(parallel execution)
//public void launchbrowser(String BROWSER) throws IOException(parallel execution)

@BeforeClass(alwaysRun = true)
public void launchbrowser() throws IOException
{
	String BROWSER = futil.readDataFromPropertyFile("browser");
//String BROWSER = System.getProperty("browser");(parallel execution)
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver = new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		driver = new FirefoxDriver();
	}
	else
	{
		driver = new EdgeDriver();
	}
	sdriver = driver;
}


 
	
	@AfterClass
	public void closebrowser()
	{
		driver.quit();
		Reporter.log("closed the browser",true);
	}

	@AfterSuite
	public void closeDB() throws SQLException
	{
 dutil.closeDB();
	}	
	}


