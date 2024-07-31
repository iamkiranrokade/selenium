package GenericUtils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class DataProviderMethod {
	@DataProvider
	public String[] [] dataProviderMethodd(){
		  File file= new File(".\\test-data\\DWS.xlsx");
		  Workbook work=null;  
		  try {
		  FileInputStream fis = new FileInputStream(file);
		   work= WorkbookFactory.create(fis);
		  }
		  catch(Exception e) {
			  
		  }
		  Sheet sheet = work.getSheet("Sheet1");
		  int rowCount=sheet.getPhysicalNumberOfRows();
		  int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();
		  String[][] result = new String[rowCount-1][cellCount];
		  for(int i =1;i<rowCount;i++) {
			 for(int j =0;j<cellCount;j++) {
				 String data = sheet.getRow(i).getCell(j).toString();
				result[i-1][j]=data;
			 }
		  }	 
			return result;
		  }
 }
