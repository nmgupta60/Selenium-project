package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelDataConfig {
	

 public ExcelDataConfig() {
 }

	public static String getdata(int sheetNumber, int row, int column) {
		Workbook wb = null;
		 Sheet sheet1 = null;
		try {
			
			 FileInputStream outputStream = new FileInputStream(
			 new File("C:\\Users\\ARJUN\\eclipse-workspace\\USGBC\\TestData\\Input.xls"));
			 wb = new HSSFWorkbook(outputStream);
			 } catch (Exception e) {
			 System.out.println(e.getMessage());
			 }
		sheet1 = wb.getSheetAt(sheetNumber);
		String data = sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	}


}
