package com.hms.medvite.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.genericUtility.WebDriverUtility;

public class BookappointmentPOM {
	WebDriverUtility wutil = new WebDriverUtility();

	@FindBy(name="appdate")
	private WebElement dat;
	
	@FindBy(name="apptime")
	private WebElement tim;
	
	@FindBy(name="submit")
	private WebElement sbtn;
	
	@FindBy(xpath="//i[@class='ti-angle-down']")
	private WebElement icon;
	
	@FindBy(xpath="//a[contains(.,'Log Out')]")
	private WebElement logout;
	
	public BookappointmentPOM(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public void bookapp(String date1,String time1,WebDriver driver)
	{
		dat.sendKeys(date1);
		tim.sendKeys(time1);
		sbtn.click();
		System.out.println("appointment booked successfully");
	}
}
