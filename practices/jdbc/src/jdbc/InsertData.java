package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {

	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "MYDB4PM", "MYDB4PM");
			IO.println("Connected");
			Statement stmt = con.createStatement();
			stmt.executeUpdate("Insert into student values(1,'Ajaya',78)");
			IO.println("One record inserted successfully");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
