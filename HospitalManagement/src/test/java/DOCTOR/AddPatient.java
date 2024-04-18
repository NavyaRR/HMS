package DOCTOR;

	import static org.testng.Assert.fail;

import java.io.IOException;
	import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericUtility.Baseclass;
import com.genericUtility.DatabaseUtility;
import com.genericUtility.ExcelUtility;
import com.genericUtility.FileUtility;
import com.genericUtility.JavaUtility;
import com.genericUtility.WebDriverUtility;
import com.hms.medvite.objectrepository.DocLoginPOM;
import com.hms.medvite.objectrepository.addpatient1page;
	
@Listeners(com.genericUtility.ListnerImpClass.class)
	public class AddPatient extends Baseclass 
	{
	@Test
	public void addpat() throws EncryptedDocumentException, IOException, InterruptedException {
		DatabaseUtility dutil = new DatabaseUtility();
		ExcelUtility eutil = new ExcelUtility();
		FileUtility futil = new FileUtility();
		JavaUtility jutil = new JavaUtility();
		WebDriverUtility wutil = new WebDriverUtility();
		
		futil.readDataFromPropertyFile("brower");
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
			driver.findElement(By.xpath("//span[.=' Patients ']")).click();
			driver.findElement(By.xpath("//span[.=' Add Patient']")).click();
			Thread.sleep(3000);
			int em = jutil.getRandomNo();
			
		String nam = eutil.readDataFromExcelFile("doctorsheet",0,1);
		String contact = eutil.readDataFromExcelFile("doctorsheet",1,1);
		String email = eutil.readDataFromExcelFile("doctorsheet",2,1);
		String gender = eutil.readDataFromExcelFile("doctorsheet",3,1);
		String address = eutil.readDataFromExcelFile("doctorsheet",4,1);
		String age = eutil.readDataFromExcelFile("doctorsheet",5,1);
		String medhistory = eutil.readDataFromExcelFile("doctorsheet",6,1);
		Thread.sleep(4000);
		//pom for getting random emails
		//addpatient1page addpatient = new addpatient1page(driver);
		//addpatient.addp1(nam, contact,em+email, address, age, medhistory, driver);
		
		//pom
		addpatient1page aa = new addpatient1page(driver);
		aa.addp1(nam, contact, em+email, address, age, medhistory, driver);
		//Assert.fail();
		//wutil.alertaccept(driver);
		}
	}
	
		
		
		
		
		
		
		
		
		
		
			/*FileInputStream fis= new FileInputStream("./src\\test\\resources\\addDocData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		
		
		

		Sheet sh1 = wb.getSheet("doctorsheet");
		String Name = sh1.getRow(0).getCell(2).getStringCellValue();
		String Contact = sh1.getRow(1).getCell(2).getStringCellValue();
		String Mail = sh1.getRow(2).getCell(2).getStringCellValue();
		
		/*if(Gen.equalsIgnoreCase("male"))
		{
			driver.findElement(By.xpath("//label[@for='rg-male']")).click();
		
		}
		else
		{
			driver.findElement(By.xpath("//label[@for='rg-female']")).click();
		}
		
		String Address = sh1.getRow(4).getCell(2).getStringCellValue();
		String Age = sh1.getRow(5).getCell(2).getStringCellValue();
		String Medhis = sh1.getRow(6).getCell(2).getStringCellValue();;
		String Gen = sh1.getRow(3).getCell(2).getStringCellValue();
		
		addpatient1page ad1 = new addpatient1page(driver);
		ad1.addp1(Name, Contact, Mail, Address, Age, Medhis, driver);
		
			
		driver.findElement(By.name("patname")).sendKeys(pName);
		driver.findElement(By.name("patcontact")).sendKeys(pContact);
		driver.findElement(By.name("patemail")).sendKeys(pEmail+random);
		
		driver.findElement(By.name("pataddress")).sendKeys(pAddress);
		driver.findElement(By.name("patage")).sendKeys(pAge);
		driver.findElement(By.name("medhis")).sendKeys(pMedical);
		
			driver.findElement(By.id("submit")).click();
			System.out.println("patient added !! ");

		
	}*/


