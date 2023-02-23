package dataProvider;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {
	
	@DataProvider(name="EmpLogin")
	public static Object[][] getData()
	{
		Object[][]arr=ExcelReader.readExcelData("Login");
		return arr;
	}
	
	/*
	 * @DataProvider(name="LoginDataSet") public static Object[][] getData1() {
	 * Object[][]arr=ExcelReader.getDataFromSheet("Login"); return arr; }
	 * 
	 */

}
