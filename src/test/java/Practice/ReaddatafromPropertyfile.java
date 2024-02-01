package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReaddatafromPropertyfile {

	public static void main(String[] args) throws Throwable {
		
		//Step1: open the document in java Readable format		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		
		//Step2: Create obj of Properties class from java.util
		Properties pro = new Properties();
		
		//Step3: LOad the fis into property class
		pro.load(fis);
		
		//Step4: Provide key and read the value
		String value = pro.getProperty("username");
		System.out.println(value);
		
	}

}
