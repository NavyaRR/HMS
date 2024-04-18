package com.hms.medvite.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientLoginPOM {

	@FindBy(xpath="//h3[.='Patients']/parent::div[@class='text list_1_of_2']//child::a[.='Click Here']")
	private WebElement plbtn;
	
	@FindBy(name="username")
	private WebElement uname;
	
	@FindBy(name="password")
	private WebElement pword;
	
	@FindBy(name="submit")
	private WebElement sbtn;
	
	public PatientLoginPOM(WebDriver driver) 
	{
	PageFactory.initElements(driver,this);	
	}

	public void plogin(String un,String pw)
	{
		plbtn.click();
		uname.sendKeys(un);
		pword.sendKeys(pw);
		sbtn.click();
	}
}
