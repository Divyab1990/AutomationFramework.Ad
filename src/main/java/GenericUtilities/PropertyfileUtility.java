package GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyfileUtility {
	/**
	 * This method will read data from property file and return the value to caller
	 * @parameterized key
	 * @return
	 * @throws IOException 
	 * @throws IO exception
	 */
	
	public String readdatafromPropertyfile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}

}
