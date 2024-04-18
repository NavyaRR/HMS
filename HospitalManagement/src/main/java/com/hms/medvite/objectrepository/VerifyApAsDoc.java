package com.hms.medvite.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyApAsDoc {

	@FindBy(xpath="//h3[.='Doctors Login']/parent::div[@class='text list_1_of_2']//child::a[.='Click Here']\\")
	private WebElement dlogin;
	
	@FindBy(name="username")
	private WebElement uname;
	
	@FindBy(name="password")
	private WebElement pword;
	
	@FindBy(name="submit")
	private WebElement sbtn;
	
	public VerifyApAsDoc(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
public void doclogin(String DUSERNAME,String DPASSWORD)
{
	dlogin.click();
	uname.sendKeys(DUSERNAME);
	pword.sendKeys(DPASSWORD);
	sbtn.click();
}
}
