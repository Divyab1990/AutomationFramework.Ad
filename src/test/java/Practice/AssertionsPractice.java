package Practice;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
	@Test
	public void sample()
	{
		String data= "abc";
		
		System.out.println("step1");
		System.out.println("step2");
		
		Assert.assertEquals(0, 1);
	//Assert.assertTrue(data.contains("s"));
		
		System.out.println("step3");
		System.out.println("step4");
	}
	
	@Test
	public void sampleSoft()
	{
       SoftAssert sa = new SoftAssert();
		String data= "abc";
        
		System.out.println("step1");
		System.out.println("step2");
		
		sa.assertEquals(0, 1);
		
		System.out.println("step3");
		
		sa.assertTrue(data.contains("c"));
		
		System.out.println("step4");
		
		sa.assertAll();
	}

}
