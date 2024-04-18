package TestNG;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.genericUtility.IpathConstant;

public class Login1 {
@DataProvider
public Object[][] data() throws EncryptedDocumentException, IOException
{
	FileInputStream fis = new FileInputStream(IpathConstant.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Logindata");
	int rowcount = sh.getLastRowNum();
 int cellcount = sh.getRow(0).getLastCellNum();	
 
 Object[][] obj = new Object[rowcount][cellcount];
	for(int i=0;i<rowcount;i++)
	{
		for(int j=2;j<cellcount;j++)
		{
	obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
				}
	}
	return obj;

	
		

	}

}
