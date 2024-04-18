package com.hms.medvite.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
//declaration

@FindBy(name="username")
private WebElement usernametxf;

@FindBy(name="password")
private WebElement passtxf;

@FindBy(name="submit")
private WebElement subbtn;


//initialization
public Loginpage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}

//utilization
public WebElement getusernametxf()
{
	return usernametxf;
}

public WebElement getpasstxf()
{
	return passtxf;
}

public WebElement getsubbtn()
{
	return subbtn;
}

//business libraries
public void LoginToApp(String un,String pw)
{
	usernametxf.sendKeys(un);
	passtxf.sendKeys(pw);
	subbtn.click();
}
	

		
			
		
	}

