package com.hms.medvite.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.WebDriverUtility;

public class deletedoctorpage {
		WebDriverUtility wdU=new WebDriverUtility();

@FindBy(xpath="//table/tbody/tr[last()-2]/td/child::div/a/i[@class='fa fa-times fa fa-white']")
private WebElement delbtn;

@FindBy(xpath="//h5[@class='over-title margin-bottom-15']/following-sibling::p")
private WebElement text;

public deletedoctorpage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}
public WebElement getdelbtn()
{
	return delbtn;
}
public WebElement gettext()
{
	return text;
}


public String deldoctor(WebDriver driver, String expText)
{
	delbtn.click();
	wdU.alertaccept(driver);
	String actText = text.getText();
	if (actText.contains(expText))
	{
		System.out.println("record deleted successfully");
	}
	else
	{
		System.out.println("record not deleted ");
	}
  
    return actText;
	}

}
