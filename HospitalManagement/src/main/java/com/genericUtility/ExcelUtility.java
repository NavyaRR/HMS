package com.genericUtility;

	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.util.HashMap;

	import org.apache.poi.EncryptedDocumentException;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;

	public class ExcelUtility {
		/**
		 * this method is used to read data from excel file.
		 * @author navya
		 * @param sheetName
		 * @param rowNo
		 * @param cellNo
		 * @return
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */
		
		public String readDataFromExcelFile(String sheetName, int rowNo , int cellNo) throws EncryptedDocumentException, IOException
		{
			FileInputStream fis = new FileInputStream(IpathConstant.ExcelPath);
			
			Workbook wb=  WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			
			String value = sh.getRow(rowNo).getCell(cellNo).getStringCellValue();
			wb.close();
			return value;
			 
		}
		
		
		 /**
		  * this method is used read multiple data from excel file
		  * 
		  * @param sheetName
		  * @param cellNo
		  * @return
		  * @throws EncryptedDocumentException
		  * @throws IOException
		  */

	 	public HashMap<String, String> readMultipleDataFromExcel(String sheetName , int cellNo ) throws EncryptedDocumentException, IOException  
		{
			FileInputStream fis = new FileInputStream(IpathConstant.ExcelPath);
			Workbook wb = WorkbookFactory.create(fis);
			
			Sheet sh= wb.getSheet(sheetName);
			int lastRow = sh.getLastRowNum();
			
			
			HashMap<String, String> map = new HashMap<String, String>();
			
			for(int i=0; i<=lastRow; i++)
			{
					 String key = sh.getRow(i).getCell(cellNo).getStringCellValue();
					 String value = sh.getRow(i).getCell(cellNo+1).getStringCellValue();
					 map.put(key, value);
			}
			wb.close();
			return map;
		}
		
		
		/**
		 * this method is used to get count last row count.
		 * @author navya
		 * @param sheetName
		 * @return
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */
		public int getTotalRowCount (String sheetName) throws EncryptedDocumentException, IOException
		{
			FileInputStream fis=  new FileInputStream(IpathConstant.ExcelPath);
			Workbook wb= WorkbookFactory.create(fis);
			
			Sheet sh= wb.getSheet(sheetName);
			int rowCount= sh.getLastRowNum();
			wb.close();
			return rowCount;
			
		}
		
		/**
		 * this method is used to get count of last cell
		 * @param sheetName
		 * @return
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */
		public int getTotalCellCount(String sheetName) throws EncryptedDocumentException, IOException
		{
			FileInputStream fis = new FileInputStream(IpathConstant.ExcelPath);
			 Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			int cellCount = sh.getRow(0).getLastCellNum();
			wb.close();
			return cellCount;
		}
		
		/**
		 * this method is used for writing data into excel file.
		 * @author navya
		 * @param sheetName
		 * @param rowNo
		 * @param cellNo
		 * @param value
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */
		public void writeDataIntoExcel(String sheetName, int rowNo, int cellNo , String value) throws EncryptedDocumentException, IOException
		{
			FileInputStream fis= new FileInputStream(IpathConstant.ExcelPath);
			Workbook wb = WorkbookFactory.create(fis);
			
			Sheet sh= wb.getSheet(sheetName);
			sh.createRow(rowNo).createCell(cellNo).setCellValue(value);
			
			FileOutputStream fos= new FileOutputStream(IpathConstant.ExcelPath);
			wb.write(fos);
			wb.close();
			
		}
		

}
