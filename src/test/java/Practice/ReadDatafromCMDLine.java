package Practice;

import org.testng.annotations.Test;


public class ReadDatafromCMDLine {
	@Test
	public void read()
	{
		String UN = System.getProperty("username");
		System.out.println(UN);
		
		String PWD = System.getProperty("password");
		System.out.println(PWD);
	}

}
