package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	@Test
	public void createcustomer()
	{
		Assert.fail();
		System.out.println("create");//failed pass
	}

	@Test(dependsOnMethods = "createcustomer")
	public void modifycustomer()
	{
		System.out.println("modify");//skip run
	}
	
	@Test
	public void deletecustomer()
	{
		System.out.println("delete");
	}
}
