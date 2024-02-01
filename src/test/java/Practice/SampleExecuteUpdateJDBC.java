package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleExecuteUpdateJDBC {
	
	public static void main(String[] args) throws SQLException {
		
		//Create driver object and import from Mysql
		Driver driverRef = new Driver();
		
		//Step1: Register the database/driver
		DriverManager.registerDriver(driverRef);
		
		//Step2: get the connection with Database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adselenium", "divya", "divya");
		
		//Step3: issue create statement
		Statement state = conn.createStatement();
		
		//Step4: execute a query
		//executeupdate()  is used for non select querries- create, insert, delete, truncate,drop, update
		int result = state.executeUpdate("insert into student_info values(13, 'kavya', 'computerscience');");
		if (result==1) 
		{
			System.out.println("Data added");
		}
		
		//Step5: Close the Database
		conn.close();
	}

}
