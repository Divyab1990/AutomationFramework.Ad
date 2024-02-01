package GenericUtilities;

import java.util.Date;

/**
 * this class consists of generic method related to java
 */

public class JavaUtility {
	
	/**
	 * this method will capture the current system date in required format
	 * 
	 */
	
	public String getsystemdate()
	{
		Date d = new Date();
		String[] dArr = d.toString().split(" ");
		String date = dArr[2]+"-"+dArr[1]+"-"+dArr[5]+"_"+dArr[3].replace(":", "-");
		return date;
	}

}
