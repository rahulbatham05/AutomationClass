package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static Object[][] arr;
	String data;
	static XSSFWorkbook wb;
	public static Object[][] readExcelData(String SheetName) {

		try {
			File file = new File(System.getProperty("user.dir") + "/TestData/Data.xlsx");
			System.out.println(file);
			FileInputStream fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet(SheetName);
			XSSFRow row = sheet.getRow(1);

			int rowcount = sheet.getPhysicalNumberOfRows();
			System.out.println("Row count is " + rowcount);
			int column = row.getPhysicalNumberOfCells();

			arr = new Object[rowcount - 1][column];

			for (int i = 1; i < rowcount; i++) {
				for (int j = 0; j < column; j++) {
					arr[i - 1][j] = getData(SheetName,i,j);
				}
			}

		} catch (FileNotFoundException ex) {
			System.out.println("File is not found " + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("Not able to read data " + ex.getMessage());
		}
		return arr;

	}
	
	public static String getData(String sheetName, int row, int column)
	{
		XSSFCell cell=wb.getSheet(sheetName).getRow(row).getCell(column);
		String data="";
		if(cell.getCellType()==CellType.STRING)
		{
			data=cell.getStringCellValue();
		}
		else if(cell.getCellType()==CellType.NUMERIC)
		{	double dataindouble;
		dataindouble=cell.getNumericCellValue();
			data=String.valueOf(dataindouble);
		}
		else if(cell.getCellType()==CellType.BLANK)
		{
			data="";
		}
		return data;
	}
}
