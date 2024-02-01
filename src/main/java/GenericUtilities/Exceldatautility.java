package GenericUtilities;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Exceldatautility {
	/**
	 * This class consists of generic methods related to excel file
     * This method will read data from excel file and return the value to caller
	 * @param sheetname
	 * @param rowIndex
	 * @param cellIndex
	 * @return
	 * @throws IOException
	 */
	
	public String readdatafromExceldata(String sheetname,int rowIndex,int cellIndex) throws IOException
	{
		FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\Ad.Sele Test Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		String value = wb.getSheet(sheetname).getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		return value;
	}

}
