	package com.hms.medvite.objectrepository;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class DocLoginPOM {


		@FindBy(xpath="//a[@href='hms/doctor/']")
		private WebElement doclogin;
		
		@FindBy(name="username")
		private WebElement utx;
		
		@FindBy(name="password")
		private WebElement ptx;
		
		@FindBy(name="submit")
		private WebElement sbtn;
		
		
		public DocLoginPOM(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		
		
		public void addpat(String un,String pw)
		{
			doclogin.click();
			utx.sendKeys(un);
			ptx.sendKeys(pw);
			sbtn.click();
		}

	}
