package com.test.utility;

import java.util.ArrayList;

import com.excelutil.test.Xls_Reader;

public class TestUtil {

	
	public static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcel(){
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try {
			
			reader = new Xls_Reader("/Users/wrp/git/SeleniumAutomation-Web/WebAutomation/src/test/resources/Testdata/FacebookTestdata.xlsx");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String sheetName = "RegTestData";
		
		int rowCount = reader.getRowCount(sheetName);

		for(int rowNum=2; rowNum<=rowCount; rowNum++) {
			
			String username = reader.getCellData("RegTestData", "username", rowNum);
			
			String password  = reader.getCellData("RegTestData", "password", rowNum);
			
			Object ob[] = {username , password};
			
			myData.add(ob);
			
		}
		return myData;
		
		
	}
}
