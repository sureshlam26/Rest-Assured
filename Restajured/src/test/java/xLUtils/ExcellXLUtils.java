package xLUtils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcellXLUtils {
	static XSSFWorkbook wb;
	static XSSFSheet sh;

	public ExcellXLUtils(String excellPath,String SheetName) throws IOException {
		try {
			
			wb = new XSSFWorkbook(excellPath);
			sh = wb.getSheet("SheetName");
		} catch (Exception exe) {
			System.out.println(exe.getMessage());
			System.out.println(exe.getCause());
			exe.printStackTrace();

		}

	}

	/*public static void main(String[] args) throws IOException {
		getRowCount();
		getCellData();
	}*/

	public static void getCellData(int rownum, int colcount) throws IOException {
		try {
			// String projDir=System.getProperty("user.dir");
			// System.out.println(projDir);
			//String excelPath="./data/Empdetails.xlsx";

			// wb=new XSSFWorkbook(excelPath);
			// sh=wb.getSheet("Sheet1");
			DataFormatter formater = new DataFormatter();
			Object value = formater.formatCellValue(sh.getRow(rownum).getCell(colcount));
			System.out.println(value);
			// double cellvalue=sh.getRow(1).getCell(2).getNumericCellValue();
			// System.out.println(cellvalue);
		} catch (Exception exe) {
			System.out.println(exe.getMessage());
			System.out.println(exe.getCause());
			exe.printStackTrace();

		}

	}

	public static void getRowCount() {
		try {
			// String projDir=System.getProperty("user.dir");
			// System.out.println(projDir);
			// String excelPath="./data/Empdetails.xlsx";

			// wb=new XSSFWorkbook(excelPath);
			// sh=wb.getSheet("Sheet1");
			
			int rowCount = sh.getPhysicalNumberOfRows();
			System.out.println("rowcount is:" + rowCount);
			
		} catch (Exception exe) {
			System.out.println(exe.getMessage());
			System.out.println(exe.getCause());
			exe.printStackTrace();

		}

	}
}
