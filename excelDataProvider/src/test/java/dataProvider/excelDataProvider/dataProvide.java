package dataProvider.excelDataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvide {

	@Test(dataProvider="driveTest")
	public void testCaseData(String s1, String s2, int id) {
		System.out.println(s1 + s2 + id);
	}
	/*
	@DataProvider(name="driveTest")
	public Object[][] getData() throws FileNotFoundException {
		DataFormatter formatter = new DataFormatter();
		//Object[][] data = {{"hello","java",101},{"hi","ruby",900},{"bye","c",800}};
		//every row of excel should be sent to one array.
		FileInputStream file = new FileInputStream("");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheetIndex(0);
		int rowCount = sheet.getPhysicalNumberofRows();
		XSSFRow row = sheet.getRow();
		int columnCount = row.getLastCellNum();
		Object[][] data = new Object[rowCount-1][rowCount];
		for(int i=0;i<rowCount-1;i++) {
			
			for(j=0;j<columnCount;j++) {
				XSSFCell cell = row.getCell(j);
				data[i][j] = formatter.formatCellValue(cell);
			}
		}*/
		//return data;
	}
