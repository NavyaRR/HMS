package PATIENT;
        import java.io.IOException;
		import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericUtility.Baseclass;
import com.genericUtility.DatabaseUtility;
import com.genericUtility.ExcelUtility;
import com.genericUtility.FileUtility;
import com.genericUtility.JavaUtility;
import com.genericUtility.WebDriverUtility;
import com.hms.medvite.objectrepository.BookappointmentPOM;
import com.hms.medvite.objectrepository.PatientLoginPOM;

@Listeners(com.genericUtility.ListnerImpClass.class)
		public class BookAppointment extends Baseclass
		{
@Test
public void addpat() throws EncryptedDocumentException, IOException, InterruptedException {
	DatabaseUtility dutil = new DatabaseUtility();
	ExcelUtility eutil = new ExcelUtility();
	FileUtility futil = new FileUtility();
	JavaUtility jutil = new JavaUtility();
	WebDriverUtility wutil = new WebDriverUtility();
	
	futil.readDataFromPropertyFile("browser");
	String un=futil.readDataFromPropertyFile("patientusername");
	String pw = futil.readDataFromPropertyFile("patientpassword");

	wutil.maximizeWindow(driver);
	//driver.manage().window().maximize();
	wutil.waitForPageLoad(driver, 2);
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	driver.get("http://rmgtestingserver/domain/Hospital_Management_System/");
	Thread.sleep(3000);
	           //pom
				PatientLoginPOM login = new PatientLoginPOM(driver);
				login.plogin(un,pw);
				Thread.sleep(3000);

				driver.findElement(By.xpath("//span[.=' Book Appointment ']")).click();
				Thread.sleep(3000);

				//String dSpecl = eutil.readDataFromExcelFile("patientsheet",0,1);
				//String doct = eutil.readDataFromExcelFile("patientsheet",1,1);
		

				WebElement dSpec = driver.findElement(By.name("Doctorspecialization"));
				dSpec.click();
				Select s= new Select(dSpec);
				s.selectByVisibleText("Dentist");
				Thread.sleep(3000);

				WebElement doctor = driver.findElement(By.name("doctor"));
				doctor.click();
				Select s1= new Select(doctor);
				s1.selectByVisibleText("varsha1");
				Thread.sleep(3000);
				
				String date1 = eutil.readDataFromExcelFile("patientsheet",3,1);
				String time1 = eutil.readDataFromExcelFile("patientsheet",4,1);
                  //pom
				BookappointmentPOM book = new BookappointmentPOM(driver);
				book.bookapp(date1, time1, driver);

				
			
	}

}
