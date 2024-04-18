package ADMIN;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericUtility.Baseclass;
import com.genericUtility.ExcelUtility;
import com.genericUtility.FileUtility;
import com.genericUtility.JavaUtility;
import com.genericUtility.WebDriverUtility;
import com.hms.medvite.objectrepository.Loginpage;
import com.hms.medvite.objectrepository.addDocpage;

@Test
@Listeners(com.genericUtility.ListnerImpClass.class)
public class AddDoctor extends Baseclass
{
	@Test(retryAnalyzer = com.genericUtility.RetryAnalyser.class)

	public void Login2() throws EncryptedDocumentException, IOException, InterruptedException {


		JavaUtility jutil = new JavaUtility();
		ExcelUtility eutil = new ExcelUtility();
		WebDriverUtility wutil = new WebDriverUtility();
		FileUtility futil=new FileUtility();

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
		/*driver.findElement(By.name("username")).sendKeys(USERNAME);
				driver.findElement(By.name("password")).sendKeys(PASSWORD);
				driver.findElement(By.name("submit")).click();*/
		//pom
		Loginpage loginpage = new Loginpage(driver);
		loginpage.LoginToApp(un,pw);

        int rn = jutil.getRandomNo();
		//loginpage = new Loginpage(driver);

		driver.findElement(By.xpath("//span[.=' Doctors ']")).click();
		driver.findElement(By.xpath("//span[.=' Add Doctor']")).click();
		WebElement docspe = driver.findElement(By.name("Doctorspecialization"));
		wutil.handleDropdownbyVisibleText(docspe, "Dentist");

		String nam = eutil.readDataFromExcelFile("adminsheet",0,2);
		String add = eutil.readDataFromExcelFile("adminsheet",2,2);
		String fee = eutil.readDataFromExcelFile("adminsheet",3,2);
		String cont = eutil.readDataFromExcelFile("adminsheet",4,2);
		String mail = eutil.readDataFromExcelFile("adminsheet",5,2);
		String pass = eutil.readDataFromExcelFile("adminsheet",6,2);
		String conpass = eutil.readDataFromExcelFile("adminsheet",7,2);


		addDocpage ad = new addDocpage(driver);
		ad.addDoctor(nam, add, fee, cont, rn+mail, pass, conpass, driver);				
	}
}



