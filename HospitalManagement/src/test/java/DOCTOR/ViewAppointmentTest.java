package DOCTOR;

		import java.io.File;
import java.io.IOException;
		import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericUtility.Baseclass;
import com.genericUtility.DatabaseUtility;
import com.genericUtility.ExcelUtility;
import com.genericUtility.FileUtility;
import com.genericUtility.JavaUtility;
import com.genericUtility.WebDriverUtility;
import com.hms.medvite.objectrepository.DocLoginPOM;
@Listeners(com.genericUtility.ListnerImpClass.class)
		public class ViewAppointmentTest extends Baseclass
		{
@Test
public void addpat() throws EncryptedDocumentException, IOException, InterruptedException {
	DatabaseUtility dutil = new DatabaseUtility();
	ExcelUtility eutil = new ExcelUtility();
	FileUtility futil = new FileUtility();
	JavaUtility jutil = new JavaUtility();
	WebDriverUtility wutil = new WebDriverUtility();
	
	futil.readDataFromPropertyFile("browser");
	String un=futil.readDataFromPropertyFile("doctorusername");
	String pw = futil.readDataFromPropertyFile("doctorpassword");

	wutil.maximizeWindow(driver);
	//driver.manage().window().maximize();
	wutil.waitForPageLoad(driver, 2);
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	driver.get("http://rmgtestingserver/domain/Hospital_Management_System/");
	Thread.sleep(3000);
		//pom
		DocLoginPOM login = new DocLoginPOM(driver);
		login.addpat(un,pw);
		Thread.sleep(3000);
WebElement app = driver.findElement(By.xpath("//span[.=' Appointment History ']"));
app.click();


}
}
