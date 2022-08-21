package sfdc.org.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import sfdc.org.PageObjects.BaseClassPage;

public class ReadExcelData extends BaseClassPage {
	@DataProvider (name="sfdcCredentials")
	public static String[][]  getExcelData(Method m) throws EncryptedDocumentException, IOException {
		String[][] testData = null;
		File f = new File(System.getProperty("user.dir") + "/src/main/resources/TestData/sfdcTestData.xlsx");
		System.out.println("From readxml");
		
		FileInputStream fi = new FileInputStream(f);							
		//Workbook wb = WorkbookFactory.create(fi);
		Workbook wb=   new XSSFWorkbook(fi);
		// Excel sheet name 	
		Sheet sheetName = wb.getSheet(m.getName());
		
		DataFormatter dformat = new DataFormatter();
		
		int iTotalRows = sheetName.getLastRowNum();
		Row rowCells = sheetName.getRow(0);
		int iTotalColumns = rowCells.getLastCellNum();

		testData = new String[iTotalRows][iTotalColumns];
		for (int i = 1; i <= iTotalRows; i++) {
			for (int j = 0; j < iTotalColumns; j++)

			{
				
                      testData[i-1][j]=dformat.formatCellValue(sheetName.getRow(i).getCell(j));

			}
		}
		wb.close();
		return testData;

		
	}
	@DataProvider (name="ValidCredentials")
	public static String[][]  getExcelData() throws IOException {
		String[][] testData = null;
		File f = new File(System.getProperty("user.dir") + "/src/main/resources/TestData/sfdcTestData.xlsx");
		System.out.println("From readxml");
		
		FileInputStream fi = new FileInputStream(f);							
		//Workbook wb = WorkbookFactory.create(fi);
		Workbook wb=   new XSSFWorkbook(fi);
		// Excel sheet name 	
		Sheet sheetName = wb.getSheet(FileUtility.readPropertiesFile("excel.read.validcredentials"));
		
		DataFormatter dformat = new DataFormatter();
		
		int iTotalRows = sheetName.getLastRowNum();
		Row rowCells = sheetName.getRow(0);
		int iTotalColumns = rowCells.getLastCellNum();

		testData = new String[iTotalRows][iTotalColumns];
		for (int i = 1; i <= iTotalRows; i++) {
			for (int j = 0; j < iTotalColumns; j++)

			{
				
                      testData[i-1][j]=dformat.formatCellValue(sheetName.getRow(i).getCell(j));

			}
		}
		wb.close();
		return testData;

		
	}
	
	
	
	
	

}
