package com.hms.medvite.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GetReportsPOM {

	@FindBy(id="fromdate")
	private WebElement ftxbox;
	
	@FindBy(id="todate")
	private WebElement ttxtbox;
	
	@FindBy(id="submit")
	private WebElement sbtn;
	
	
	public GetReportsPOM(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
 public void reportdates(String fromdate,String todate)
 {
	ftxbox.click();
	ftxbox.sendKeys(fromdate);
	ttxtbox.click();
	ttxtbox.sendKeys(todate);
	sbtn.click();
 }
}
