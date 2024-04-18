package com.hms.medvite.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addpatient1page {

	@FindBy(name="patname")
	private WebElement pname;
	@FindBy(name="patcontact")
	private WebElement pcon;
	@FindBy(name="patemail")
	private WebElement pmail;
	@FindBy(name="pataddress")
	private WebElement padd;
	@FindBy(name="patage")
	private WebElement page;
	@FindBy(name="medhis")
	private WebElement mhistory;
	@FindBy(xpath="//label[@for='rg-male']")
    private WebElement gender;
	@FindBy(id="submit")
	private WebElement submit;
	
	public addpatient1page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void addp1(String nam,String contact,String mail,String address,String age,String medhistory,WebDriver driver)
	{
		pname.sendKeys(nam);
		pcon.sendKeys(contact);
		pmail.sendKeys(mail);
		padd.sendKeys(address);
		page.sendKeys(age);
		mhistory.sendKeys(medhistory);
	    String Gen = gender.getText();
	    if(Gen.equalsIgnoreCase("female"))
		{
			driver.findElement(By.xpath("//label[@for='rg-male']")).click();
		
		}
		else
		{
			driver.findElement(By.xpath("//label[@for='rg-female']")).click();
		}
	    System.out.println("patient added successfully");
	    submit.click();
		
}

}
