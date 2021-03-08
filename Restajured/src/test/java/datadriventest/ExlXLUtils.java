package datadriventest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExlXLUtils {

	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static FileInputStream fis;
	public static FileOutputStream fout;

	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	public static int getRowCount(String xlfile, String  xlsheet) throws IOException {
		
			fis=new FileInputStream(xlfile);
		    wb=new XSSFWorkbook(fis);
			 sh=wb.getSheet("xlsheet");
			int Rowcount= sh.getLastRowNum();
			wb.close();
			fis.close();
			return Rowcount;
		}

		public static int getCellcount(String xlfile, String  xlsheet,int rownum ) throws IOException
		{
			
			//String excelPath1="./data/Empdetails.xlsx";
		    fis=new FileInputStream(xlfile);
		    wb=new XSSFWorkbook(fis);
			 sh=wb.getSheet("xlsheet");
			 row= sh.getRow(rownum);
			int cellcount= row.getLastCellNum();
			
			wb.close();
			fis.close();
			return cellcount;
				
			
			}
		
		public static String getCellData(String xlfile, String xlsheet,int rownum,int colunm) throws IOException 
		{
		    fis=new FileInputStream(xlfile);
		    wb=new XSSFWorkbook(fis);
			 sh=wb.getSheet("xlsheet");
			 row= sh.getRow(rownum);
			  cell=row.getCell(colunm);
			  String data;
			  try {
				  DataFormatter formater=new DataFormatter();
				String Celldata=  formater.formatCellValue(cell);
				return Celldata;
						  
			  } catch(Exception exe)
			  {
				  data="";
			  }
			  wb.close();
			  fis.close();
			  return data;
				
			}
		public static void setCellData(String xlfile, String xlsheet,int rownum,int colunm,String data) throws IOException
		{
			 fis=new FileInputStream(xlfile);
			    wb=new XSSFWorkbook(fis);
				 sh=wb.getSheet("xlsheet");
				 row= sh.getRow(rownum);
				  cell=row.createCell(colunm);
				  cell.setCellValue(data);
				  fout=new FileOutputStream(xlfile);
				  wb.write(fout);
				  wb.close();
				  fis.close();
				  fout.close();
				  
		}



		
}