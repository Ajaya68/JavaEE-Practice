//JDBC Program to create a table

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "MYDB4PM", "MYDB4PM");
			
			Statement stmt=con.createStatement();
			stmt.execute("create table student(roll_no number(3),name varchar2(10),marks number(3))");
			IO.println("Table Created Successfully");
		} catch (ClassNotFoundException | SQLException e) {
			// 
			e.printStackTrace();
		}
	}
}
