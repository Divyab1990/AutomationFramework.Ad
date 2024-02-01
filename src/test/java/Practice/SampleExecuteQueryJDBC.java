package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleExecuteQueryJDBC {
	
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
		//executequery name is used for select querries
		ResultSet result = state.executeQuery("select* from Student_info;");
		while (result.next()) 
		{
			System.out.println(result.getInt(1)+"-"+(result.getString(2))+"-"+result.getString(3));
		}
		
		//Step5: Close the Database
		conn.close();
	}

}
