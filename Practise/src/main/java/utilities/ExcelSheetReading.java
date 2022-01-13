package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheetReading {
	@SuppressWarnings({ "resource", "null" })
	
		/*public ArrayList<String> getData(String testcaseName) throws IOException
		{
			
			ArrayList<String> a=new ArrayList<String>();
			
			FileInputStream fis=new FileInputStream("E:\\java mindtree workspace\\Practise\\TestData\\Book1.xlsx");
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			
			int n=workbook.getNumberOfSheets();
			for(int i=0;i<n;i++)
			{
				if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))  //accessing a particular sheet
				{
					XSSFSheet sheet=workbook.getSheetAt(i);
					
					//Identifying testcases column by scanning the entire row
					
					Iterator<Row> row=sheet.iterator(); //sheet is a collection of rows
					Row firstrow=row.next();
					Iterator<Cell> ce=firstrow.iterator();  //row is a collection of cells
					int k=0;
					int column=0;
					while(ce.hasNext())
					{
						Cell value=ce.next();
						if(value.getStringCellValue().equalsIgnoreCase("testcases"))
						{
						   column=k;	
						}
						k++;
					}
					System.out.println(column);
					
					
					//once column is identified then scan entire testcase column to identify purchae testcase row
					while(row.hasNext())
					{
						Row r=row.next();
						if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName))
						{
							
							//after you grab purchase testcase row thn put all the data of that row 
							
							Iterator<Cell> cv=r.cellIterator();
							while(cv.hasNext())
							{
								Cell c=cv.next();
								if(c.getCellTypeEnum()==CellType.STRING)
								{
						          a.add(c.getStringCellValue())	;		
					     		}
								else
								{
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
								}
							}
						}
					}
					
				}
			}
			
			return a;
		}*/
		
		
	public static ArrayList<String> getdata() throws IOException {
		FileInputStream f = new FileInputStream("C:\\Users\\kaush\\Downloads\\Practise\\TestData\\Book1.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(f);
		 ArrayList<String>a= new ArrayList<String>();
		 XSSFSheet sheet= workbook.getSheet("Sheet1");
		 Iterator<Row> row= sheet.iterator();
		 Row r1=row.next();
		 Iterator<Cell> c=r1.cellIterator();
		 while(c.hasNext())
		 {
			 Cell value=c.next();
			 a.add(value.getStringCellValue());
		 }
		 return a;
	}
}
