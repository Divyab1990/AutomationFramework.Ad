package Practice;

import java.io.IOException;

import GenericUtilities.Exceldatautility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyfileUtility;

public class GenericMethodPractice {

	public static void main(String[] args) throws IOException { //Caller funtion //user
		
		PropertyfileUtility p = new PropertyfileUtility();
		String value = p.readdatafromPropertyfile("url");
		System.out.println(value);
		
		Exceldatautility e = new Exceldatautility();
	   String data = e.readdatafromExceldata("Contacts",1,2);
	   System.out.println(data);
	   
	   JavaUtility j = new JavaUtility();
	   String date = j.getsystemdate();
	   System.out.println(date);
	   
	}
}
		
		
		
		//int a=10;
		//int b=20;
		//int c=a+b;
		//System.out.println(c);
		
		/*int sum= add(10, 20);
		System.out.println(sum+10);
		add(2,450);
		add(300,400);
	}
	
	public static int add(int a, int b)// called method //generic method// reusable
	{
		int c=a+b;
		return c;
	}

}*/
