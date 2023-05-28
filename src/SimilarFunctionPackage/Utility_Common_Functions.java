package commonFunctionPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;

public class Utility_Common_Functions {
	 @AfterTest
	public static void evedenceFileCreator(String filename,String requestBody,String responseBody) throws IOException
	{
		File fileObj = new File("C:\\Users\\Sai\\OneDrive\\Desktop\\storage of assignments\\" +filename+".txt");
		System.out.println(" A net text file created to record request and response of the API : " +fileObj.getName());
	    FileWriter fileWriterObj=new FileWriter(fileObj);
	    fileWriterObj.write("request body :" +requestBody+"\n\n");
	    fileWriterObj.write("response Body : " +responseBody);
	    fileWriterObj.close();
	    System.out.println("request body and response body are saved in :" +fileObj.getName());
	}
	
	public static ArrayList<String> readDataExcel(String sheeetName,String testCaseName) throws IOException
	{
		ArrayList<String> arrayListObj =new ArrayList<String>();
		//step 1 :- create the obj of file input stream
		FileInputStream fileInputStreamObj=new FileInputStream("C:\\Users\\Sai\\OneDrive\\Desktop\\storage of assignments\\Post_Test_Data.xlsx");
		//step 2 :- Access the excel file
		XSSFWorkbook xSSFWorkbookObj =new XSSFWorkbook(fileInputStreamObj);
		
		
		//step 3 :- access sheet name 	
		int countofsheet=xSSFWorkbookObj.getNumberOfSheets();
	  for(int i=0;i<countofsheet;i++)
	   {
		  String sheetname=xSSFWorkbookObj.getSheetName(i);
		  if(sheetname.equalsIgnoreCase(sheetname))
		  	{
			  //access the row
			  XSSFSheet sheet=xSSFWorkbookObj.getSheetAt(i);
			  Iterator<Row> rows=sheet.iterator();
			  //Row r=rows.next();
			  while (rows.hasNext())
			  	{
				  Row r1=rows.next();
				  if(r1.getCell(0).getStringCellValue().equalsIgnoreCase(testCaseName))
				  {
					Iterator<Cell> cellvalues=r1.cellIterator();	
    				while(cellvalues.hasNext()) {
					String testdata = cellvalues.next().getStringCellValue();
				    arrayListObj.add(testdata);
			        }
		        }
		   
	         }
          }
	  }
	  xSSFWorkbookObj.close();
return arrayListObj;
	}
	
}