package excelprgms;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelread 
{
	XSSFWorkbook wb;
	XSSFSheet sheet;
	public Excelread(String excelpath) throws IOException
	{
		File path=new File(excelpath);
		FileInputStream fis=new FileInputStream(path);
	wb=new XSSFWorkbook(fis);	
	
	}
	public String data(int sheetno,int rownum,int colno)
	{
		sheet=wb.getSheetAt(sheetno);
		String data1=sheet.getRow(rownum).getCell(colno).getStringCellValue();
		return data1;
	}
	public int getrowcount(int sheetno)
	{
		int row=wb.getSheetAt(sheetno).getLastRowNum();
		row=row+1;
		return row;
		
	}
	
	

}
