package Com.NopCommerce.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSManager {
	
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	FileInputStream FI;
	
	public int GetRowCount(String path ,String SheetName) throws IOException
	{
		FI = new FileInputStream(path);
		workbook = new XSSFWorkbook(FI);
		sheet = workbook.getSheet(SheetName);
		
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		FI.close();
		return rowcount;
		
	}
	
	public int GetColCount(String path, String SheetName) throws IOException
	{
		FI = new FileInputStream(path);
		workbook = new XSSFWorkbook(FI);
		sheet = workbook.getSheet(SheetName);
		
		int colcount = sheet.getRow(1).getLastCellNum();
		workbook.close();
		FI.close();
		return colcount;
	}
	
	public String GetXLSData(String path, String SheetName, int rows, int cols) throws IOException
	{
		FI = new FileInputStream(path);
		workbook = new XSSFWorkbook(FI);
		
		sheet = workbook.getSheet(SheetName);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		row = sheet.getRow(rows);
		cell = row.getCell(cols);
		
		try {
			data = formatter.formatCellValue(cell);
		}
		catch(Exception e)
		{
			data = "";
			e.printStackTrace();
		}
		return data;
	
	}

}
