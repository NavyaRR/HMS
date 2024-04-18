package TestNG;

import static org.testng.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HardAssertTest{
@Test
	public void hardassert() 
	{
		String expdata = "https://www.facebook.com/";
WebDriver driver = new ChromeDriver();
driver.get("https://www.facebook.com/");
String acdata = driver.getTitle();
assertEquals(acdata, expdata, "satisfied");
System.out.println(acdata);

	}

}
