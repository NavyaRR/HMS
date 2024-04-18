package com.hms.medvite.objectrepository;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.JavaUtility;

public class AppHisCheckedByPatient {

	@FindBy(xpath="//span[.=' Appointment History ']")
	private WebElement apphis;
	
	@FindBy(xpath="//table/tbody/tr[1]/td[last()-1]")
	private WebElement cancel1;
	
	public AppHisCheckedByPatient(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
 public void cancelapp(WebDriver driver) throws InterruptedException, IOException
 {
	 apphis.click();
		Thread.sleep(3000);
	 String text = cancel1.getText();
	 if(text.equalsIgnoreCase("Cancel by Doctor"))
		{
			System.out.println("appoitment was cancled by doctor");
		}
		else
		{
			System.out.println("appoitment is active");
		
	 
			JavaUtility jutil = new JavaUtility();
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
		 File dst = new File("./screenshot/"+"report"+""+jutil.getSystemDateInformat()+".png");
		 String srcpath = dst.getAbsolutePath();
		FileUtils.copyFile(src, dst);
		  
		}
 }
}
