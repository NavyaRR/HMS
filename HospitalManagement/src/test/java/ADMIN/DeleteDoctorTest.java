package ADMIN;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericUtility.Baseclass;
import com.genericUtility.DatabaseUtility;
import com.genericUtility.ExcelUtility;
import com.genericUtility.FileUtility;
import com.genericUtility.JavaUtility;
import com.genericUtility.WebDriverUtility;
import com.hms.medvite.objectrepository.Loginpage;
import com.hms.medvite.objectrepository.deletedoctorpage;
@Listeners(com.genericUtility.ListnerImpClass.class)
public class DeleteDoctorTest extends Baseclass {
	@Test

	public void deldoc() throws EncryptedDocumentException, IOException, InterruptedException {
		DatabaseUtility dutil = new DatabaseUtility();
		ExcelUtility eutil = new ExcelUtility();
		FileUtility futil = new FileUtility();
		JavaUtility jutil = new JavaUtility();
		WebDriverUtility wutil = new WebDriverUtility();
		
		futil.readDataFromPropertyFile("brower");
		String un=futil.readDataFromPropertyFile("adminusername");
		String pw = futil.readDataFromPropertyFile("adminpassword");

		wutil.maximizeWindow(driver);
		//driver.manage().window().maximize();
		wutil.waitForPageLoad(driver, 2);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("http://rmgtestingserver/domain/Hospital_Management_System/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h3[.='Admin Login']/parent::div[@class='text list_1_of_2']//child::a[.='Click Here']")).click();
		Loginpage login = new Loginpage(driver);
		login.LoginToApp(un, pw);
		
		
		driver.findElement(By.xpath("//span[.=' Doctors ']")).click();
		driver.findElement(By.xpath(" //span[.=' Manage Doctors ']")).click();
		//pom
		deletedoctorpage dd = new deletedoctorpage(driver);
		String expText= "data deleted !!";
		dd.deldoctor(driver, expText);
		
		 
		  
		
		
		  
		  
	}

}
