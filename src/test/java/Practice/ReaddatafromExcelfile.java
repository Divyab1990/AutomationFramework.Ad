package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReaddatafromExcelfile {

	public static void main(String[] args) throws Throwable {
		
		//Step1: open the document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Ad.Sele Test Data.xlsx");
		
		//Step2: Create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step3: Navigate to required sheet
		Sheet sheet = wb.getSheet("Contacts");
		
		//Step4: Navigate to required row
		Row row = sheet.getRow(5);
		
		//Step5: Navigate to required column
		Cell cel = row.getCell(3);
		
		//Step6: Capture the value in the cell
		String value = cel.getStringCellValue();
		System.out.println(value);
	}

}
