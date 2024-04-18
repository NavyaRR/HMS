package PATIENT;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericUtility.Baseclass;
import com.genericUtility.DatabaseUtility;
import com.genericUtility.ExcelUtility;
import com.genericUtility.FileUtility;
import com.genericUtility.JavaUtility;
import com.genericUtility.WebDriverUtility;
import com.hms.medvite.objectrepository.AppHisCheckedByPatient;
import com.hms.medvite.objectrepository.PatientLoginPOM;

@Listeners(com.genericUtility.ListnerImpClass.class)
	public class VerifyAppointment extends Baseclass
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
			//pom
			AppHisCheckedByPatient check = new AppHisCheckedByPatient(driver);
			check.cancelapp(driver);
			
			
			/*driver.findElement(By.xpath("//span[.=' Book Appointment ']")).click();

			FileInputStream fixl= new FileInputStream("./src/test/resources/MedviteData.xlsx");
			Workbook wb= WorkbookFactory.create(fixl);
			Sheet sh = wb.getSheet("patientsheet");

			String dSpecl = sh.getRow(0).getCell(1).getStringCellValue();

			String doct = sh.getRow(1).getCell(1).getStringCellValue();

			String date = sh.getRow(3).getCell(1).getStringCellValue();

			String time = sh.getRow(4).getCell(1).getStringCellValue();
			
			driver.findElement(By.xpath("//span[.=' Book Appointment ']")).click();

			WebElement dSpec = driver.findElement(By.name("Doctorspecialization"));
			Select s= new Select(dSpec);
			s.selectByVisibleText("dSpecl");
			
			WebElement doctor = driver.findElement(By.xpath("//select[@id='doctor']"));
			Select s1= new Select(doctor);
			s1.selectByVisibleText("doct");
			
			  //pom
			BookappointmentPOM book = new BookappointmentPOM(driver);
			book.bookapp(date, time, driver);*/
			
			
			
			
			/*//Verify appointment as a doctor(cancelled appointment)
			
			String DUSERNAME= p.getProperty("doctorusername");
			String DPASSWORD= p.getProperty("doctorpassword");
			
			//pom
			VerifyApAsDoc login2 = new VerifyApAsDoc(driver);
			login2.doclogin(DUSERNAME, DPASSWORD);
			
			driver.findElement(By.xpath("//span[.=' Appointment History ']")).click();
			
			//pom
			CancelAppointmentAsDoc cancel = new CancelAppointmentAsDoc(driver);
			cancel.cancelApp();*/
			
			
			
			
			// cancelled appointment, checked by patient
			//pom
			//PatientLoginPOM login1 = new PatientLoginPOM(driver);
			//login1.plogin(PUSERNAME, PPASSWORD);
			
			
		
	}

}
