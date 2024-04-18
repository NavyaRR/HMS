package com.hms.medvite.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.WebDriverUtility;

public class addDocpage {
	WebDriverUtility wutil = new WebDriverUtility();
//declarization
@FindBy(name="docname")
private WebElement name;

@FindBy(name="clinicaddress")
private WebElement address;

@FindBy(name="docfees")
private WebElement fees;

@FindBy(xpath="//input[@name='doccontact']")
		private WebElement contact;

@FindBy(name="docemail")
private WebElement email;

@FindBy(name="npass")
private WebElement password;

@FindBy(name="cfpass")
private WebElement conpassword;

@FindBy(name="submit")
private WebElement subtn;

//initiation
public addDocpage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
	}
//utilization
public void addDoctor(String nam,String add,String fee,String cont,String mail,String pass,String conpass,WebDriver driver)
{
	name.sendKeys(nam);
	address.sendKeys(add);
	fees.sendKeys(fee);
	contact.sendKeys(cont);
	email.sendKeys(mail);
	password.sendKeys(pass);
	conpassword.sendKeys(conpass);
	subtn.click();
	wutil.alertaccept(driver);
}

}








