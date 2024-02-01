package GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementation for the iretryanalyser interface of the Testng
 */

public class RetryAnalyserImplementation implements IRetryAnalyzer
{
	int count=0;
	int retrycount =3; //manual analysis
	@Override
	public boolean retry(ITestResult result) {
		
		//0<3 , 1<3, 2<3, 3<3=stops retrying
		while (count<retrycount) 
		{
			count++; //1  2  3
			return true; // retry retry retry
		}
		return false; //stops retrying
	}
	

}
