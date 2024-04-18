package com.hms.medvite.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.WebDriverUtility;

public class CancelAppointmentAsDoc {
WebDriverUtility wutil = new WebDriverUtility();
@FindBy(xpath="//table/tbody/tr/td/div/a[@title='Cancel Appointment']")
private WebElement cancel;

@FindBy(xpath="//span[@class='username']")
private WebElement icon;

@FindBy(xpath="//a[contains(.,'Log Out')]")
private WebElement logout;

public CancelAppointmentAsDoc (WebDriver driver)
{
	PageFactory.initElements(driver,this);
	}
public void cancelApp(	WebDriver driver)
{
	cancel.click();
	wutil.alertaccept(driver); //driver.switchTo().alert().accept();
	icon.click();
	logout.click();
}
}
