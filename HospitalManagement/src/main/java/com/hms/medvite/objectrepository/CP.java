package com.hms.medvite.objectrepository;

public class CP {

	//AddDoctor
	/*public void AddDoctor() throws IOException, InterruptedException {
	DatabaseUtility dutil = new DatabaseUtility();
	ExcelUtility eutil = new ExcelUtility();
	FileUtility futil = new FileUtility();
	JavaUtility jutil = new JavaUtility();
	WebDriverUtility wutil = new WebDriverUtility();
	
int ran = jutil.getRandomNo();
// dutil.connectToDB();
	WebDriver driver= null;
	FileInputStream fis= new FileInputStream("./src\\test\\resources\\CommonData.Properties.txt");
	Properties p = new Properties();
	p.load(fis);
	


	//String expData= "MEDVITE"+random ;
	String BROWSER = p.getProperty("browser");
	//String USER1 = p.getProperty("user1");
	String	URL = p.getProperty("url");
	String USERNAME= p.getProperty("adminusername");
	String PASSWORD= p.getProperty("adminpassword");

	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver= new ChromeDriver();
	}
	else if (BROWSER.equalsIgnoreCase("edge")) 
	{
		driver= new EdgeDriver();
	}
	else {
		driver= new FirefoxDriver();
	}*/
	
	
	/*String docname = eutil.readDataFromExcelFile("adminsheet",0,2);
	driver.findElement(By.name("docname")).sendKeys(docname);
	
	String cliAddress = eutil.readDataFromExcelFile("adminsheet",2,2);
	driver.findElement(By.name("clinicaddress")).sendKeys(cliAddress);
	
	
	String docFees = eutil.readDataFromExcelFile("adminsheet",3,2);
	driver.findElement(By.name("docfees")).sendKeys(docFees);
	
	

	
	String docno = eutil.readDataFromExcelFile("adminsheet",4,2);
	driver.findElement(By.xpath("//input[@name='doccontact']")).sendKeys(docno);
	
	
	
	String docemail = eutil.readDataFromExcelFile("adminsheet",5,2);
	driver.findElement(By.name("docemail")).sendKeys(docemail);
	
	String password = eutil.readDataFromExcelFile("adminsheet",6,2);
	driver.findElement(By.name("npass")).sendKeys(password);
	
	String conpassword = eutil.readDataFromExcelFile("adminsheet",7,2);
	driver.findElement(By.name("cfpass")).sendKeys(conpassword);
	
	driver.findElement(By.name("submit")).click();
	
	
	
	  driver.switchTo().alert().accept();*/





	

}
