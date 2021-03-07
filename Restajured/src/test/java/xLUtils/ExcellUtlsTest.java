package xLUtils;

import java.io.IOException;






public class ExcellUtlsTest {

	@SuppressWarnings("static-access")
	private static void Main(String[]args) throws IOException {
		// TODO Auto-generated method stub

		String Projectdir=System.getProperty("user.dir");
		System.out.println(Projectdir);
		String excellPath="./data/Empdetails.xlsx";
		String SheetName="Sheet1";
		ExcellXLUtils excell=new ExcellXLUtils(excellPath, SheetName);
		excell.getRowCount();
		excell.getCellData(0, 1);
		excell.getCellData(0, 2);
		
	}
	
	


}
